package com.fackechat.practice.message;


public class PingMessage extends Message {
    @Override
    public int getMessageType() {
        return PingMessage;
    }
}
