package com.spring.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.kafka.producer.service.KafkaMessagePublisher;

@RestController
@RequestMapping("/producer-app")
public class KafkaEventController {

	@Autowired
	private KafkaMessagePublisher messagePublisher;
	
	@GetMapping("/publish/{message}")
	public ResponseEntity<?> publishMessage(@PathVariable String message) {
		try {
			messagePublisher.sendMessageToTopic(message);
			return ResponseEntity.ok("Message published successfully !!");
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
		}
	}
	
	@GetMapping("/bulk-publish/{message}")
	public ResponseEntity<?> publishBulkMessages(@PathVariable String message) {
		try {
			for(int i = 0; i < 10000; i++) {
				messagePublisher.sendMessageToTopic(message+"__"+i);
			}
			return ResponseEntity.ok("Message published successfully !!");
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
		}
	}
}
