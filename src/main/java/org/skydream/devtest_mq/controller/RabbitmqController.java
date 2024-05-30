package org.skydream.devtest_mq.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.skydream.devtest_mq.dto.MessageDto;
import org.skydream.devtest_mq.service.RabbitmqService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class RabbitmqController {

    private final RabbitmqService rabbitmqService;

    @PostMapping("/send/message")
    public ResponseEntity<String> send(@RequestBody MessageDto messageDto) {
        rabbitmqService.sendMessage(messageDto);
        return ResponseEntity.ok("Message sent to Rabbit MQ");
    }
}
