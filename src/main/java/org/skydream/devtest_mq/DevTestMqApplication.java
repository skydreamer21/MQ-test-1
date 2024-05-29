package org.skydream.devtest_mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class DevTestMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevTestMqApplication.class, args);
    }

}
