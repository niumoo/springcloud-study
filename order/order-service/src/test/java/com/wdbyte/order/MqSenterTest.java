package com.wdbyte.order;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 * 发送 Rabbit MQ 消息
 *
 * @author niujinpeng
 * @Date 2020/3/23 8:08
 */
@Component
public class MqSenterTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("orderQueue", "now " + new Date());
    }

}
