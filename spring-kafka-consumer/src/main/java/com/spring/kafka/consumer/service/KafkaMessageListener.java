package com.spring.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {
	
	Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);
	
	@KafkaListener(topics = "Keerthi-new-topic", groupId = "keerthi-group-1")
	public void consume(String message) {
		logger.info("Message : "+message+" received successfully !!");
	}

}
