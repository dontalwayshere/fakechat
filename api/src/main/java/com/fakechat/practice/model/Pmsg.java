package com.fakechat.practice.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Pmsg implements Serializable {

    private String id;

    private String fid;

    private String tid;

    private String content;

    private int contentType;

    private String creatTime;

}
