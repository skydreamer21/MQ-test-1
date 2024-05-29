package org.skydream.devtest_mq.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "spring.rabbitmq")
@AllArgsConstructor
@Getter
public class RabbitmqProperties {
    private String host;
    private int port;
    private String username;
    private String password;
}
