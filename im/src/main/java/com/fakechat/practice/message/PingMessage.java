package com.fakechat.practice.message;


public class PingMessage extends Message {
    @Override
    public int getMessageType() {
        return PingMessage;
    }
}
