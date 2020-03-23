package com.wdbyte.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 接收 Rabbit MQ 消息
 *
 * @author niujinpeng
 * @Date 2020/3/23 8:06
 */
@Component
@Slf4j
public class RabbitMqReceiver {
    // 第一种方式：不会自动创建队列
    // @RabbitListener(queues = "orderQueue")

    // 第二种方式：可以自动创建队列
    @RabbitListener(queuesToDeclare = @Queue("orderQueue"))
    public void process(String message) {
        log.info("RabbitMq Receiver: {}", message);
    }
}
