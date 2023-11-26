package com.example.employeeservice.Controller;

import com.example.employeeservice.Model.Employee;
import com.example.employeeservice.Repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    public Employee newEmployee(@RequestBody Employee employee){
        LOGGER.info("Employee Added: " + employee.toString());
        return repository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> listEmployees(){
        LOGGER.info("Employees Listed...!");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee searchById(@PathVariable("id") Long id){
        LOGGER.info("Employee Details with id: " + id);
        return repository.findByEmployeeId(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> searchByDeptId(@PathVariable("departmentId") Long departmentId){
        LOGGER.info("Employees with Department Id: " + departmentId);
        return repository.findByDepartment(departmentId);
    }

}
