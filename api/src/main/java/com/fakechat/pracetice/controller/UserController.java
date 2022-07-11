package com.fakechat.pracetice.controller;

import com.fakechat.pracetice.common.msg.MessageBox;
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
    public MessageBox<String> register(String username, String pwd) {
        int save = userService.save(username, pwd);
        return MessageBox.ok(""+save);
    }

}
