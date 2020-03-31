package com.wdbyte.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/31 21:37
 */
public interface SteamClient {

    /**
     * 消息队列名称*
     */
    String INPUT = "myMessage";

    @Input(SteamClient.INPUT)
    SubscribableChannel input();

    @Output(SteamClient.INPUT)
    MessageChannel output();
}
