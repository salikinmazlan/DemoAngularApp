package com.example.demo.cqrs.employee.query.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class EmployeeResultDto {

	Long id;
	String name;
	Integer age;
	String role;
	Boolean status;
}
