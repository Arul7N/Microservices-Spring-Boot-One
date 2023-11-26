package com.example.employeeservice.Repository;

import com.example.employeeservice.Model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class EmployeeRepository {

    public List<Employee> employees = new ArrayList<>();


    public Employee addEmployee(Employee employee){
        employees.add(employee);
        return employee;
    }

    public Employee findByEmployeeId(Long id){
        return employees.stream()
                .filter(a -> a.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("There is No Such Employee with that ID: " + id));
    }

    public List<Employee> findAll(){
        return employees;
    }

    public List<Employee> findByDepartment(Long departmentId){
        return employees.stream()
                .filter(e -> e.departmentId().equals(departmentId))
                .toList();
    }
}
