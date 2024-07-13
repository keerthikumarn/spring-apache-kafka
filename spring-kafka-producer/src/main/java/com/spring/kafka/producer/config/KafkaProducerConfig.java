package com.spring.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class KafkaProducerConfig {

	//@Bean
	public NewTopic createTopic() {
		return new NewTopic("Keerthi-custom-topic", 2, (short) 1);
	}

}
