package com.csmithswim.intro.employees;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

    private @Id @GeneratedValue Long id;
    private String name;
    private String role;
    private Integer age;

    //Necessary to put a default constructor in case we don't use another constructor
    public Employee() {};

    public Employee(Long id, String name, String role, Integer age) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.age = age;
    }

    public Employee(String name, String role, Integer age) {
        this.name = name;
        this.role = role;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return String.format("Employee(id=%s, name=%s, role=%s, age=%s)", id, name, role, age);
    }

}
