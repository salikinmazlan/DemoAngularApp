package com.example.demo.cqrs.employee.command.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cqrs.employee.command.domain.EmployeeCommandFacade;
import com.example.demo.cqrs.employee.command.dto.EmployeeCommandDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/employee/command")
@RequiredArgsConstructor
class EmployeeCommandResources {

	private final EmployeeCommandFacade employeeCommandFacade;
	
	@PostMapping
	ResponseEntity<EmployeeCommandDto> add(@RequestBody EmployeeCommandDto employeeCommandDto){
		return employeeCommandFacade.add(employeeCommandDto);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<EmployeeCommandDto> update(@PathVariable Long id, @RequestBody EmployeeCommandDto employeeCommandDto){
		return employeeCommandFacade.update(id, employeeCommandDto);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> delete(@PathVariable Long id) {
		employeeCommandFacade.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
