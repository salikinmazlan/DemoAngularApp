import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee/employee';
import { EmployeeServiceService } from '../service/employee-service.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit{

id!: number;
employee: Employee = new Employee();
  
constructor(
  private employeeService: EmployeeServiceService,
  private route: ActivatedRoute,
  private router: Router
){}

ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.employeeService.getEmployeeById(this.id).subscribe({
      next: (data) => {
        console.log(data);
        this.employee = data;
      },
      error: (error: any) => {
        console.log(error);
      }
    })

}

onSubmit(){
  this.employeeService.updateEmployee(this.id, this.employee).subscribe({
    next: (data) => {
      console.log(this.employee);
      this.goToEmployeeList();
    },
    error: (error: any) => {
      console.log(error);
    }
  })
}

goToEmployeeList(){
  this.router.navigate(['/employees']);
}

}
