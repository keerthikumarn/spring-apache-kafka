package com.spring.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.spring.kafka.consumer.dto.Employee;

@Service
public class KafkaMessageListener {

	Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

	/*@KafkaListener(topics = "Keerthi-new-topic", groupId = "keerthi-group-1")
	public void consume1(String message) {
		logger.info("Consumer-1 Message : " + message + " received successfully !!");
	}*/
	
	@KafkaListener(topics = "Keerthi-custom-topic", groupId = "keerthi-group-1")
	public void consumeCustomMessageTopic(Employee employee) {
		logger.info("Consumer consumed the custom message: " + employee.toString() + " successfully !!");
	}

	/*@KafkaListener(topics = "keerthi-topic", groupId = "keerthi-group-1")
	public void consume2(String message) {
		logger.info("Consumer-2 Message : " + message + " received successfully !!");
	}

	@KafkaListener(topics = "my-topic", groupId = "keerthi-group-1")
	public void consume3(String message) {
		logger.info("Consumer-3 Message : " + message + " received successfully !!");
	}

	@KafkaListener(topics = "Keerthi-new-topic", groupId = "keerthi-group-1")
	public void consume4(String message) {
		logger.info("Consumer-4 Message : " + message + " received successfully !!");
	}*/

}
