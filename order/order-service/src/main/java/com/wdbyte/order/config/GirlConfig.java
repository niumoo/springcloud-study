package com.wdbyte.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 体验 config 的自动刷新
 *
 * @author niujinpeng
 * @Date 2020/3/22 21:16
 */
@Data
@Component
@ConfigurationProperties(value = "girl")
@RefreshScope
public class GirlConfig {
    private String name;
    private Integer age;
}
