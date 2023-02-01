import { Component, OnInit } from '@angular/core';
import { Data, Router } from '@angular/router';
import { Employee } from '../employee/employee';
import { EmployeeServiceService } from '../service/employee-service.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  employee : Employee = new Employee();

  constructor(private employeeService: EmployeeServiceService,
              private router: Router) {}

  ngOnInit(): void {    
  }

  saveEmployee(){
    this.employeeService.addEmployee(this.employee).subscribe({
      next: (data) => {
        console.log(data);
        this.goToEmployeeList();
      },
      error: (error: any) => {
        console.log(error);
      }
    });
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }

  onSubmit(){ 
    this.saveEmployee();
  }

}
