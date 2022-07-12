package com.fakechat.practice.server.handler;


import com.fakechat.practice.message.LoginRequestMessage;
import com.fakechat.practice.message.LoginResponseMessage;
import com.fakechat.practice.server.session.SessionFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@ChannelHandler.Sharable
public class LoginRequestMessageHandler extends SimpleChannelInboundHandler<LoginRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestMessage msg) throws Exception {
        String username = msg.getUsername();
        SessionFactory.getSession().bind(ctx.channel(), username);
        LoginResponseMessage message = new LoginResponseMessage(true, username+":上线成功");
        ctx.writeAndFlush(message);
    }
}
