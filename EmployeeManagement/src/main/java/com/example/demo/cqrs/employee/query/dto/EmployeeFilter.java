package com.example.demo.cqrs.employee.query.dto;

import javax.validation.Valid;

import lombok.Builder;
import lombok.Getter;

@Valid
@Getter
@Builder
public class EmployeeFilter {

	private Long id;
	private String name;
	private Integer age;
	private String role;
	private Boolean status;
}
