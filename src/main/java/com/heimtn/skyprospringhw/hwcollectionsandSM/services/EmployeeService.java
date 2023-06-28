package com.heimtn.skyprospringhw.hwcollectionsandSM.services;

import com.heimtn.skyprospringhw.hwcollectionsandSM.objects.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmp(String firstName, String lastName, Integer depart, Integer salary);

    void removeEmp(String firstName, String lastName, Integer depart, Integer salary);

    Employee searchEmp(String firstName, String lastName, Integer depart, Integer salary);

    List<Employee> getList();
}
