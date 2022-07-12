package com.fakechat.practice.service;

import com.fakechat.practice.common.msg.MessageBox;
import com.fakechat.practice.model.Friend;
import com.fakechat.practice.model.User;

import java.util.List;

public interface UserService {


    User login(String username, String pwd);

    int register(String username, String pwd);

    List<Friend> getFriendList(String uid,String username);
}
