package com.fakechat.pracetice.mapper;


import com.fakechat.pracetice.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into `fakechat`.`user` ( `username`, `pwd`) values (#{username}, #{pwd})")
    int save(String username, String pwd);

    @Select("select * from `fakechat`.`user`  where `username` = #{username} and  `pwd`= #{pwd}")
    User selectByUsernameAndPwd(String username, String pwd);

    @Select("select * from `fakechat`.`user`  where `username` = #{username} ")
    List<User> selectByUsername(String username);
}
