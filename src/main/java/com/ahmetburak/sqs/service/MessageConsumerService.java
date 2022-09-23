package com.ahmetburak.sqs.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MessageConsumerService {

    @Value("${app.uri-with-queue-name}")
    private String queueName;

    @SqsListener(value = "${app.uri-with-queue-name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage(String message, @Header("MessageId") String messageId) {
        log.info("Message is received successfully! Message: {} MessageId: {}", message,messageId);
    }

}
