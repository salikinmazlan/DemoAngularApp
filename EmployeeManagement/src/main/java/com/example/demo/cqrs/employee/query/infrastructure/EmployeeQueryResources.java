package com.example.demo.cqrs.employee.query.infrastructure;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.cqrs.employee.query.domain.EmployeeFacade;
import com.example.demo.cqrs.employee.query.dto.EmployeeFilter;
import com.example.demo.cqrs.employee.query.dto.EmployeeResultDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/employee/query")
@RequiredArgsConstructor
class EmployeeQueryResources {
	private final EmployeeFacade employeeFacade;
	
	@GetMapping()
	ResponseEntity<List<EmployeeResultDto>> getEmployees(EmployeeFilter filter,
															@PageableDefault(value = Integer.MAX_VALUE) Pageable pageable){
		return ResponseEntity.ok(employeeFacade.getEmployees(filter,pageable));
	}

	@GetMapping("/{id}")
	ResponseEntity<EmployeeResultDto> getEmployeeById(@PathVariable Long id){
		return ResponseEntity.ok(employeeFacade.getEmployeeById(id));
	}

}
