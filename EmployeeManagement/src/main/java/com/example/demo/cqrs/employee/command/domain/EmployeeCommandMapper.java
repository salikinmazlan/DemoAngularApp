package com.example.demo.cqrs.employee.command.domain;

import org.mapstruct.Mapper;

import com.example.demo.cqrs.employee.command.dto.EmployeeCommandDto;

@Mapper
interface EmployeeCommandMapper {
	EmployeeCommandEntity toEntity(EmployeeCommandDto employeeDto);
}
