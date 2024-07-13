package com.spring.kafka.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Employee {
	
	private int id;
	private String name;
	private String designation;
	private String address;
 	
}
