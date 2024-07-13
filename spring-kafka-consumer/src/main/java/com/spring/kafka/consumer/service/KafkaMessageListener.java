package com.spring.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.spring.kafka.dto.Employee;

@Service
public class KafkaMessageListener {

	Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

	/*@KafkaListener(topics = "Keerthi-new-topic", groupId = "keerthi-group-1")
	public void consume1(String message) {
		logger.info("Consumer-1 Message : " + message + " received successfully !!");
	}*/
	
	@KafkaListener(topics = "employee-topic", groupId = "employee-group-1")
	public void consumeCustomMessageTopic(@Payload Employee employee) {
		logger.info("Received custom message: {} ", employee);
	}
	/*public void consumeCustomMessageTopic(Employee employee) {
		logger.info("consumer consumed the events {} ", employee.toString());
	}*/

	@KafkaListener(topics = "dummy-topic", groupId = "dummy-group-1")
	public void consumeSimpleTextMessage(String message) {
		logger.info("Consumer-2 Message : " + message + " received successfully !!");
	}

	/*@KafkaListener(topics = "my-topic", groupId = "keerthi-group-1")
	public void consume3(String message) {
		logger.info("Consumer-3 Message : " + message + " received successfully !!");
	}

	@KafkaListener(topics = "Keerthi-new-topic", groupId = "keerthi-group-1")
	public void consume4(String message) {
		logger.info("Consumer-4 Message : " + message + " received successfully !!");
	}*/

}
