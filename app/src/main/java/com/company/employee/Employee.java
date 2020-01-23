package com.company.employee;

public class Employee {
    String name,position;
    int number_of_day;
    double salary;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }


    public int getNumber_of_day() {
        return number_of_day;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(String name, String position , double salary) {
        this.name = name;
        this.position = position;
         this.salary = salary;

    }
}
