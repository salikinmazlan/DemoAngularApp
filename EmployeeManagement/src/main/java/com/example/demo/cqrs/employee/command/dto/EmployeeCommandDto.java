package com.example.demo.cqrs.employee.command.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EmployeeCommandDto {

	Long id;
	String name;
	Integer age;
	String role;
	Boolean status;
}
