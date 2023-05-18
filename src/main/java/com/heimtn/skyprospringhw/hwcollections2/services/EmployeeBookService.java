package com.heimtn.skyprospringhw.hwcollections2.services;

import com.heimtn.skyprospringhw.hwcollections2.objects.Employee;

import java.util.List;

public interface EmployeeBookService {
    void startEmployeesBook();

    Integer generateKey(String firstName, String lastName, String surName);

    Integer generateKey(Employee employee);

    Employee getEmployee(String firstName, String lastName, String surName);

    void addEmployee(Employee employee);

    Employee removeEmployee(String firstName, String lastName, String surName);

    List<Employee> getListEmp();

    int getSumSalary();

    Employee getEmpMinSalary();

    Employee getEmpMaxSalary();

    int getMiddleSalary();

    void indexingSalary(int rate);

    List<Employee> infoDepart(int depart);

    List<Employee> selectMinSalary(int salary);

    List<Employee> selectMaxSalary(int salary);

    void changeEmployee(String lastName, String firstName, String surName, int value);
}
