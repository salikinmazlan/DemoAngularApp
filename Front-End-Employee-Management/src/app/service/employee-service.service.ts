import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../employee/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  private apiUrl = "http://localhost:8080/api/v1";


  constructor(private httpClient: HttpClient) { }

  getEmployeeList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.apiUrl}/employee/query`);
  }

  addEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post<Employee>(`${this.apiUrl}/employee/command`, employee);
  }

  getEmployeeById(id: number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.apiUrl}/employee/query/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.apiUrl}/employee/command/${id}`,employee);
  }

  deleteEmployee(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.apiUrl}/employee/command/${id}`);
  }
}
