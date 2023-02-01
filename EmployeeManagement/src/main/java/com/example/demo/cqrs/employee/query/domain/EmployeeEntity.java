package com.example.demo.cqrs.employee.query.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@EqualsAndHashCode
@Table(name = "employee")
@Where(clause = "is_deleted = false")
class EmployeeEntity {

	@Id
	private Long id;
	private String name;
	private Integer age;
	private String role;
	private Boolean status;
	
}
