package com.example.demo.cqrs.employee.command.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "employee")
//@SQLDelete(sql = "UPDATE employee SET is_deleted = true WHERE id=?")
//@Where(clause= "is_deleted = false")
class EmployeeCommandEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String name;
	
	@NonNull
	private Integer age;
	
	@NonNull
	private String role;
	
	@NonNull
	private Boolean status = true;
	
	@NonNull
	private Boolean isDeleted = false;
}
