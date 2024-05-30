package org.skydream.devtest_mq.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.skydream.devtest_mq.config.RabbitmqBindingProperties;
import org.skydream.devtest_mq.dto.MessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RabbitmqService {

    private final RabbitmqBindingProperties rabbitmqBindingProperties;
    private final RabbitTemplate rabbitTemplate;

    /**
     * 1. Queue로 메시지 발행
     * 2. Producer 역할 -> Direct Exchange 전략
     * @param messageDto
     */
    public void sendMessage(MessageDto messageDto) {
        log.info("message send : {}", messageDto.toString());
        this.rabbitTemplate.convertAndSend(rabbitmqBindingProperties.getExchangeName(),
                rabbitmqBindingProperties.getRoutingKey(), messageDto);
    }

    @RabbitListener(queues = "#{rabbitmqBindingProperties.queueName}")
    public void receiveMessage(MessageDto messageDto) {
        log.info("Received Message : {}", messageDto);
    }
}
