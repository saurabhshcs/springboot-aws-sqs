package com.saurabhshcs.springboot.aws.sqs;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.saurabhshcs.springboot.aws.controller.SendMessageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


//@SpringBootApplication //(exclude = {ContextStackAutoConfiguration.class})


@SpringBootApplication//(exclude = {ContextStackAutoConfiguration.class})
@RestController
@ComponentScan(basePackages = "com.saurabhshcs.springboot.aws.sqs")
public class SpringbootAwsSqsApplication {

//	@Autowired(required = true)
	private QueueMessagingTemplate queueMessagingTemplate;

	@Value("${cloud.aws.end-point.uri}")
	private String endpoint;
	@Autowired
    public SpringbootAwsSqsApplication(AmazonSQSAsync amazonSqs) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSqs);
    }

	@GetMapping("/send/{message}")
	public void sendMessageToQueue(@PathVariable String message) {
		queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsSqsApplication.class, args);
	}

}
