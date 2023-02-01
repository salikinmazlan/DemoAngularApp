package com.example.demo.cqrs.employee.command.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.cqrs.employee.command.dto.EmployeeCommandDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeCommandFacade {

	private final EmployeeCommandRepository employeeCommandRepository;
	private final EmployeeCommandMapper employeeCommandMapper;
	
	public ResponseEntity<EmployeeCommandDto> add(EmployeeCommandDto employeeCommandDto) {
		employeeCommandRepository.save(employeeCommandMapper.toEntity(employeeCommandDto));
		return ResponseEntity.ok(employeeCommandDto);
	}

	public ResponseEntity<EmployeeCommandDto> update(Long id, EmployeeCommandDto employeeCommandDto) {
		EmployeeCommandEntity employeeCommandEntity = employeeCommandMapper.toEntity(employeeCommandDto);
		employeeCommandEntity = employeeCommandRepository.findById(id).get();
		employeeCommandEntity.setName(employeeCommandDto.getName());
		employeeCommandEntity.setAge(employeeCommandDto.getAge());
		employeeCommandEntity.setRole(employeeCommandDto.getRole());
		employeeCommandEntity.setStatus(employeeCommandDto.getStatus());
		employeeCommandRepository.save(employeeCommandEntity);
		return ResponseEntity.ok(employeeCommandDto);
	}

	public void delete(Long id) {
		employeeCommandRepository.deleteById(id);;
	}
}
