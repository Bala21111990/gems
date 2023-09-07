
package com.engineering.microservice.awsdynamodb.controller;


import com.engineering.microservice.awsdynamodb.domain.Employee;
import com.engineering.microservice.awsdynamodb.exception.DataNotFoundException;
import com.engineering.microservice.awsdynamodb.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiOperation("Add Gems to Employee")
@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    @CrossOrigin
    public List<Employee> all() {
        return employeeService.getAll();

    }

    @PostMapping
    @CrossOrigin
    public Employee save(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping(value = "/{id}")
    @CrossOrigin
    public Employee update(@PathVariable("id") String id, @RequestBody Employee employee) {
        return employeeService.update(employee,id);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Employee getEmployeeById(@PathVariable(value = "id") String id) {
        return employeeService.getById(id).orElseThrow(() -> new DataNotFoundException("not found"));
    }
    @DeleteMapping("/{id}")
    @CrossOrigin
    public void deleteEmployee(@PathVariable(value = "id") String id) {
        employeeService.delete(id);
    }

}
