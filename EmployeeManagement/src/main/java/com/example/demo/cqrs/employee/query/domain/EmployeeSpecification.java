package com.example.demo.cqrs.employee.query.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.cqrs.employee.query.dto.EmployeeFilter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class EmployeeSpecification implements Specification {
	private final EmployeeFilter filter;
	
	@Override
	public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();

		if (filter.getId() != null) {
			predicates.add(criteriaBuilder.equal(root.get(EmployeeEntity_.id), filter.getId()));
		}
		
		if (filter.getName() != null) {
			predicates.add(criteriaBuilder.like(
								criteriaBuilder.lower(root.get(EmployeeEntity_.name)), "%" + filter.getName().toLowerCase() + "%"));
		}
		
		if (filter.getAge() !=null) {
			predicates.add(criteriaBuilder.equal(root.get(EmployeeEntity_.age), filter.getAge()));
		}
		
		if (filter.getRole() != null) {
			predicates.add(criteriaBuilder.like(
								criteriaBuilder.lower(root.get(EmployeeEntity_.role)), filter.getRole()));	
		}
		
		if (filter.getStatus() != null) {
			predicates.add(criteriaBuilder.equal(root.get(EmployeeEntity_.status), filter.getStatus()));
		}
		
		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	}

	
	
}
