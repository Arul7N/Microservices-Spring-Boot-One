package com.example.departmentservice.Model;


import java.util.ArrayList;
import java.util.List;

public class Department {

    private Long id;
    private String department;
    private List<Employee> employees = new ArrayList<Employee>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", employees=" + employees +
                '}';
    }

    public Department(Long id, String department) {
        this.id = id;
        this.department = department;
    }

    public Department() {
    }
}
