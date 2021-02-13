package com.homework.model;

import java.util.Date;

public class Form {

    private String lastName;
    private String name;
    private String middleName;
    private int age;
    private double salary;
    private String email;
    private String workAddress;
    private Date date;
    private String browser;

    public void setDate(Date date) {
        this.date = date;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public Date getDate() {
        return date;
    }

    public String getBrowser() {
        return browser;
    }

    public Form() {
    }

    public Form(String lastName, String name, String middleName, int age, double salary, String email, String workAddress) {
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.age = age;
        this.salary = salary;
        this.email = email;
        this.workAddress = workAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }
}
