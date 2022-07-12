package com.fakechat.practice.mapper;


import com.fakechat.practice.model.Friend;
import com.fakechat.practice.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into `fakechat`.`user` ( `username`, `pwd`) values (#{username}, #{pwd})")
    int save(String username, String pwd);

    @Select("select * from `fakechat`.`user`  where `username` = #{username} and  `pwd`= #{pwd}")
    User selectByUsernameAndPwd(String username, String pwd);

    @Select("select * from `fakechat`.`user`  where `username` = #{username} ")
    List<User> selectByUsername(String username);

    @Select("select * from `fakechat`.`user_friend`  where `uid` = #{uid} or `u_name` = #{username}")
    @Results({@Result(property = "fname", column = "f_name"),@Result(property = "username", column = "u_name")})
    List<Friend> selectFriendList(String uid,String username);
}
