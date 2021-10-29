package com.csmithswim.intro.employees;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
//common API syntax for the route to be plural
@RequestMapping("/employees")
public class EmployeeController {
    private Map<Long, Employee> employees = new HashMap<>();

    private AtomicLong idCounter = new AtomicLong();

//    private final EmployeeRepository repository;
//
//    public EmployeeController(EmployeeRepository repository) {
//        this.repository = repository;
//    }


    public EmployeeController() {
        Long id = idCounter.incrementAndGet();
        employees.put(id, new Employee(12L, "Joe", "Manager", 25));
    }

    //CRUD
    // Create - create one employee
    // Read - create one employee by ID / get all employees
    // Update - Update employee by ID
    // Destroy - delete by employee by ID

    @GetMapping
    public List<Employee> all() {
        return new ArrayList<Employee>(employees.values());
    }

    @PostMapping
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        Long id = idCounter.incrementAndGet();
        newEmployee.setId(id);
        employees.put(id, newEmployee);
        return newEmployee;
    }

    @GetMapping("/{id}")
    public Employee employee(@PathVariable Long id) {
        return employees.get(id);
    }




}
