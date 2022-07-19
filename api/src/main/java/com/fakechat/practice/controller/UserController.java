package com.fakechat.practice.controller;

import com.fakechat.practice.common.msg.MessageBox;
import com.fakechat.practice.common.config.ResponseConstant;
import com.fakechat.practice.model.Friend;
import com.fakechat.practice.model.User;
import com.fakechat.practice.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


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
    public MessageBox<Integer> login(String username, String pwd) {
        User user = userService.login(username, pwd);
        return user != null ? MessageBox.ok(user.getId()) : MessageBox.failMsg(ResponseConstant.RESP_LOGIN_ERROR);
    }

    @PostMapping("/getFriendList")
    public MessageBox<List<Friend>> getFriendList(String uid,String username) {
        return MessageBox.ok(userService.getFriendList(uid,username));
    }




}
