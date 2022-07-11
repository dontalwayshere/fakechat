package com.fakechat.pracetice.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into `fakechat`.`user` ( `username`, `pwd`) values (#{username}, #{pwd})")
    int save(String username, String pwd);

}
