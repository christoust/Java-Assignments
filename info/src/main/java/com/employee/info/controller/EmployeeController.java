package com.employee.info.controller;


import com.employee.info.entity.Employee;
import com.employee.info.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping("/save")
    public ResponseEntity<String> saveEmp(@RequestBody Employee employee)
    {
        employeeRepo.save(employee);
        return new ResponseEntity<>("Added new employee",HttpStatusCode.valueOf(200));

    }

    @GetMapping("{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empId)
    {
        Optional<Employee> emp = employeeRepo.findById(empId);
        return ResponseEntity.ok(emp.get());
    }

}
