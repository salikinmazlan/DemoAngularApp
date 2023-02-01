package com.example.demo.cqrs.employee.query.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.cqrs.employee.query.dto.EmployeeFilter;
import com.example.demo.cqrs.employee.query.dto.EmployeeResultDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeFacade {
	private final EmployeeQueryRepository employeeQueryRepository;
	private final EmployeeQueryMapper employeeQueryMapper;

	public List<EmployeeResultDto> getEmployees(EmployeeFilter filter, Pageable pageable) {
		if(filter == null) {
			filter = EmployeeFilter.builder().build();
		}
		
		EmployeeSpecification employeeSpecification = new EmployeeSpecification(filter);
		Page<EmployeeEntity> employees = employeeQueryRepository.findAll(employeeSpecification, pageable);
		return employeeQueryMapper.employeeToDto(employees);
	}

	public EmployeeResultDto getEmployeeById(Long id) {
		EmployeeEntity employeeEntity = employeeQueryRepository.findById(id).get();
		return EmployeeResultDto.builder()
				.name(employeeEntity.getName())
				.age(employeeEntity.getAge())
				.role(employeeEntity.getRole())
				.status(employeeEntity.getStatus())
				.build();
	}
}
