package com.vime.service.impl;

import com.vime.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import javax.annotation.Resource;
import org.springframework.cloud.stream.messaging.Source;
import java.util.UUID;

/**
 * @auther zzyy
 * @create 2020-02-22 10:56
 */
@EnableBinding(Source.class) //定义消息的推送管道 与sink对应
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());//将信息写入推送管道
        System.out.println("*****serial: " + serial);
        return null;
    }
}