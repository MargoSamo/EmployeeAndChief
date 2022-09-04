package com.mariia.domain;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Chief {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "chief")
    private List<Employee> employee;

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chief{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                '}';
    }
}