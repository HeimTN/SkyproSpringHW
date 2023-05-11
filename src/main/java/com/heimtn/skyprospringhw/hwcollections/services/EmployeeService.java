package com.heimtn.skyprospringhw.hwcollections.services;

import com.heimtn.skyprospringhw.hwcollections.objects.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmp(String firstName, String lastName);
    void removeEmp(String firstName, String lastName);
    Employee searchEmp(String firstName, String lastName);
    List<Employee> getList();
}
