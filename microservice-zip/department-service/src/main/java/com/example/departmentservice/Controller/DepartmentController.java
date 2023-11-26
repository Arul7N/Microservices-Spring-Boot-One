package com.example.departmentservice.Controller;

import com.example.departmentservice.Client.EmployeeClient;
import com.example.departmentservice.Model.Department;
import com.example.departmentservice.Repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department newDepartment(@RequestBody Department department){
        LOGGER.info("Department Add: " + department.toString());
        return repository.addDepartment(department);
    }

    @GetMapping
    public List<Department> showAllDepartment(){
        LOGGER.info("Department find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Department searchById(@PathVariable Long id){
        LOGGER.info("Department find by Id: " + id);
        return repository.findByDepartmentId(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Department find with employees");
        List<Department> departments = repository.findAll();
        departments.forEach(department ->
                department.setEmployees(
                        employeeClient.searchByDeptId(department.getId())));

        return departments;
    }

}
