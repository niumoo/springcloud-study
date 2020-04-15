package com.wdbyte.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wdbyte.order.message.SteamClient;

import java.util.Date;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/31 21:40
 */
@RestController
public class SendMessageController {

    @Autowired
    private SteamClient steamClient;

    @GetMapping("/send")
    public void process() {
        Message<String> build = MessageBuilder.withPayload("now" + new Date()).build();
        steamClient.output().send(build);

    }
}
