package com.saurabhshcs.springboot.aws.controller;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SendMessageController {

//
//    private QueueMessagingTemplate queueMessagingTemplate;
//
//    @Autowired
//    public SendMessageController(AmazonSQSAsync amazonSqs) {
//        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSqs);
//    }
//
//
//    @Value("${cloud.aws.end-point.uri}")
//    private String endpoint;
//
//    @GetMapping("/receive/messages")
//    public void receiveMessage(){
//        log.info("_____You have received a message from Saurabh: ");
//
//    }
//
//    @GetMapping("/send/{message}")
//    public void sendMessagetoSQS(@PathVariable String message){
//        log.info("____Endpoint: ", endpoint);
//        log.info("____Message: ", message);
//        queueMessagingTemplate.send("https://sqs.us-east-1.amazonaws.com/471112640102/FirstQ", MessageBuilder.withPayload("Ram Ram Sa").build());
//    }
}
