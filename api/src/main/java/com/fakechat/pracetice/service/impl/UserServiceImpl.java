package com.fakechat.pracetice.service.impl;

import com.fakechat.pracetice.mapper.UserMapper;
import com.fakechat.pracetice.model.User;
import com.fakechat.pracetice.service.UserService;
import com.fakechat.pracetice.utils.ApiUtils;
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
}
