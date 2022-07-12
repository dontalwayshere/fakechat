package com.fakechat.practice.service.impl;


import com.fakechat.practice.mapper.UserMapper;
import com.fakechat.practice.model.Friend;
import com.fakechat.practice.model.User;
import com.fakechat.practice.service.UserService;
import com.fakechat.practice.utils.ApiUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String pwd) {
        pwd = ApiUtils.stringToMD5(pwd + "register" + username);
        return userMapper.selectByUsernameAndPwd(username, pwd);
    }

    @Override
    public int register(String username, String pwd) {
        List<User> users = userMapper.selectByUsername(username);
        if (users.size() > 0) {
            return -1;
        }
        pwd = ApiUtils.stringToMD5(pwd + "register" + username);
        return userMapper.save(username, pwd);
    }

    @Override
    public List<Friend> getFriendList(String uid,String username) {
        return userMapper.selectFriendList(uid,username);
    }

}
