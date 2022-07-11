package com.fakechat.pracetice.service.impl;

import com.fakechat.pracetice.mapper.UserMapper;
import com.fakechat.pracetice.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;


    @Override
    public int save(String username, String pwd) {
        return userMapper.save(username,pwd);
    }
}
