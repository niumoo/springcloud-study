package com.wdbyte.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Stream 消息接收端
 *
 * @author niujinpeng
 * @Date 2020/3/31 21:39
 */
@Component
@EnableBinding(SteamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(SteamClient.INPUT)
    public void proceee(Object message) {
        log.info("StreamReceiver:{}", message);
    }
}
