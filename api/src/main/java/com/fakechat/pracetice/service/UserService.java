package com.fakechat.pracetice.service;

import com.fakechat.pracetice.model.User;

public interface UserService {


    User login(String username, String pwd);

    int register(String username, String pwd);
}
