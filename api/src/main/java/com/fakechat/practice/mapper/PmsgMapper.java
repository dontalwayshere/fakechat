package com.fakechat.practice.mapper;


import com.fakechat.practice.model.Pmsg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

@Mapper
public interface PmsgMapper {

    @Insert("INSERT INTO `fakechat`.`p_msg` (`fid`, `tid`, `content`, `content_type`, `creattime`) VALUES ( #{fid}, #{tid}, #{content}, #{contentType}, #{creatTime});")
    @Results({@Result(property = "contentType", column = "content_type"),@Result(property = "creatTime", column = "creattime")})
    int save(Pmsg pmsg);

}
