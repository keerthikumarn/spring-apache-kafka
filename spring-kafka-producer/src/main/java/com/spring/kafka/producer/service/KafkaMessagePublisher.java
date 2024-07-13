package com.spring.kafka.producer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.spring.kafka.dto.Employee;

@Service
public class KafkaMessagePublisher {

	@Autowired
	private KafkaTemplate<String, Object> template;

	public void sendMessageToTopic(String message) {
		CompletableFuture<SendResult<String, Object>> future = template.send("dummy-topic", message);
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println(
						"Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
			}
		});
	}
	
	public void sendCustomMessageToTopic(Employee employee) {
		//CompletableFuture<SendResult<String, Object>> future = template.send("employee-topic", employee.toString());
		CompletableFuture<SendResult<String, Object>> future = template.send("employee-topic", employee);
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println(
						"Sent message=[" + employee.toString() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to send message=[" + employee.toString() + "] due to : " + ex.getMessage());
			}
		});
	}

}
