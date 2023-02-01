package com.example.demo.cqrs.employee.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EmployeeCommandRepository extends JpaRepository<EmployeeCommandEntity,Long>{

}
