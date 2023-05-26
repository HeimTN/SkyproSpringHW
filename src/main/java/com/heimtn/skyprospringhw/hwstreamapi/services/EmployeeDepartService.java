package com.heimtn.skyprospringhw.hwstreamapi.services;

import com.heimtn.skyprospringhw.hwcollections2.objects.Employee;

import java.util.List;

public interface EmployeeDepartService {
    void addEmployee(Employee emp);

    Employee maxSalaryByDepart(int depart);

    Employee minSalaryByDepart(int depart);

    List<Employee> fullListDepart(Integer depart);
}
