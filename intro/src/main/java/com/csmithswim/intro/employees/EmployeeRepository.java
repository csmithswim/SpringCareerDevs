package com.csmithswim.intro.employees;

import org.springframework.data.jpa.repository.JpaRepository;

//<> Could be imagined as parentheses
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
