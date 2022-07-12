package com.fakechat.practice.controller;

import com.fakechat.practice.common.msg.MessageBox;
import io.minio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/minio")
public class MinioController {
    @Value("${minio.endpoint}")
    private String endpoint;
    @Value("${minio.bucket}")
    private String bucket;

    private final MinioClient minioClient;

    @Autowired
    public MinioController(MinioClient minioClient) {
        this.minioClient = minioClient;
    }


    @GetMapping
    public MessageBox<String> apiTest() {
        return MessageBox.ok("apiTest");
    }

    /**
     * 文件信息
     */
    @GetMapping("/getStatObjectArgs")
    public MessageBox<String> getStatObjectArgs(String fileName) {
        try {
            StatObjectResponse statObjectResponse = minioClient.statObject(
                    StatObjectArgs.builder().bucket(bucket).object(fileName).build());
            return MessageBox.ok(statObjectResponse.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return MessageBox.fail("");
        }
    }

    /**
     * 上传文件
     *
     * @param file -
     * @return 文件URL
     */
    @PostMapping("/upload")
    public MessageBox<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .bucket(bucket) // 需要提前创建好bucket，并设置好权限
                    .object(originalFilename)
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .build();
            minioClient.putObject(putObjectArgs);
            // 访问成功上传的文件：${endpoint}/${bucket}/${filename}
            System.out.println(endpoint + "/" + bucket + "/" + originalFilename);
            return MessageBox.ok(endpoint + "/" + bucket + "/" + originalFilename);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageBox.fail("");
        }
    }

    /**
     * 下载文件
     *
     * @param filename            文件名
     * @param httpServletResponse -
     */
    @GetMapping("/download/{filename}")
    public void downloadFile(@PathVariable("filename") String filename, HttpServletResponse httpServletResponse) {
        GetObjectArgs getObjectArgs = GetObjectArgs.builder()
                .bucket(bucket)
                .object(filename)
                .build();
        try (GetObjectResponse getObjectResponse = minioClient.getObject(getObjectArgs)) {
            byte[] buf = new byte[1024];
            int len;
            try (FastByteArrayOutputStream outputStream = new FastByteArrayOutputStream()) {
                while ((len = getObjectResponse.read(buf)) != -1) {
                    outputStream.write(buf, 0, len);
                }
                outputStream.flush();
                byte[] bytes = outputStream.toByteArray();
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("application/force-download");// 设置强制下载不打开
                httpServletResponse.addHeader("Content-Disposition", "attachment;fileName=" + filename);
                try (ServletOutputStream stream = httpServletResponse.getOutputStream()) {
                    stream.write(bytes);
                    stream.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
