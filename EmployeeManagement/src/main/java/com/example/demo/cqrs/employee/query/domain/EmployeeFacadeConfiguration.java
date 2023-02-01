package com.example.demo.cqrs.employee.query.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class EmployeeFacadeConfiguration {

	@Bean
	public EmployeeFacade employeeFacadeTest(EmployeeQueryRepository employeeQueryRepository) {
		EmployeeQueryMapper employeeQueryMapper = new EmployeeQueryMapperImpl();
		
		return new EmployeeFacade(employeeQueryRepository, employeeQueryMapper);
	}
}
