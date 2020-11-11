package com.example.demo.entity;

public class Employee {

    private Integer id;

    private String name;

    private Integer age;

    private Double pay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public Employee(Integer id, String name, Integer age, Double pay) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.pay = pay;
    }

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", pay=" + pay +
                '}';
    }
}
