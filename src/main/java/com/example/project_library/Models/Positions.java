package com.example.project_library.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Positions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;
    private String name;
    private float salary;
    public Positions() {
    }

    public Positions(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
