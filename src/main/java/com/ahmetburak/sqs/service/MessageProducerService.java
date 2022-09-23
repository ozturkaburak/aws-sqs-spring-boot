package com.ahmetburak.sqs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Log4j2
@RequiredArgsConstructor
public class MessageProducerService {
    private final QueueMessagingTemplate queueMessagingTemplate;
    @Value("${app.uri-with-queue-name}")
    private String queueName;

    @Scheduled(fixedDelay = 20000)
    public void sendMessage() {
        StringBuilder message = new StringBuilder().append("Test Message:").append(new Random().nextInt(10));
        queueMessagingTemplate.convertAndSend(queueName, message);
        log.info("Message is sent successfully! {}", message);
    }

}
