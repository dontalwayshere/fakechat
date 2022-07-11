package com.fakechat.pracetice.controller;

import com.fakechat.pracetice.common.msg.MessageBox;
import com.fakechat.pracetice.common.msg.ResponseConstant;
import com.fakechat.pracetice.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;

    @PostMapping("/register")
    public MessageBox register(String username, String pwd) {
        return userService.register(username, pwd) != -1 ? MessageBox.okMsg() : MessageBox.failMsg(ResponseConstant.RESP_REGISTRATION_FAILED);
    }

    @PostMapping("/login")
    public MessageBox<String> login(String username, String pwd) {
        return userService.login(username, pwd) != null ? MessageBox.okMsg() : MessageBox.failMsg(ResponseConstant.RESP_LOGIN_ERROR);
    }

}
