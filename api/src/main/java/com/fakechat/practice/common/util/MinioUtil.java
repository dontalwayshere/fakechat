package com.fakechat.practice.common.util;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.RemoveBucketArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Minio 工具类
 */
@Component
public class MinioUtil {
    private final MinioClient minioClient;

    @Autowired
    public MinioUtil(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    /**
     * 创建 bucket （如果不存在）
     *
     * @param bucketName -
     * @return -
     */
    public boolean createBucket(String bucketName) {
        try {
            if (!existBucket(bucketName)) {
                MakeBucketArgs makeBucketArgs = MakeBucketArgs.builder().bucket(bucketName).build();
                minioClient.makeBucket(makeBucketArgs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 删除 bucket （如果存在）
     *
     * @param bucketName -
     * @return -
     */
    public boolean deleteBucket(String bucketName) {
        try {
            if (existBucket(bucketName)) {
                RemoveBucketArgs removeBucketArgs = RemoveBucketArgs.builder().bucket(bucketName).build();
                minioClient.removeBucket(removeBucketArgs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 判断指定的 bucket 是否存在
     *
     * @param bucketName -
     * @return -
     */
    public boolean existBucket(String bucketName) throws Exception{
        BucketExistsArgs bucketExistsArgs = BucketExistsArgs.builder().bucket(bucketName).build();
        return minioClient.bucketExists(bucketExistsArgs);
    }
}
