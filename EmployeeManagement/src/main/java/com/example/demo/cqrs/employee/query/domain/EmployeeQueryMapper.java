package com.example.demo.cqrs.employee.query.domain;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.example.demo.cqrs.employee.query.dto.EmployeeResultDto;

@Mapper
interface EmployeeQueryMapper {

	EmployeeResultDto toEntity(EmployeeEntity employeeEntity);
	List<EmployeeResultDto> employeeToDto(Page<EmployeeEntity> employeeEntity);
}
