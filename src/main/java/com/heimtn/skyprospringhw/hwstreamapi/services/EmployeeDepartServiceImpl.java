package com.heimtn.skyprospringhw.hwstreamapi.services;


import com.heimtn.skyprospringhw.hwcollections2.objects.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeDepartServiceImpl implements EmployeeDepartService{
    private Set<Employee> employeeSet = new HashSet<>();

   @Override
    public void addEmployee(Employee emp){
        employeeSet.add(emp);
    }

   @Override
    public Employee maxSalaryByDepart(int depart){
       return employeeSet.stream().filter(e -> e.getDepart() == depart)
               .max(Comparator.comparingInt(Employee::getSalary)).orElseThrow();
    }

    @Override
    public Employee minSalaryByDepart(int depart){
        return employeeSet.stream().filter(e -> e.getDepart() == depart)
                .min(Comparator.comparingInt(Employee::getSalary)).orElseThrow();
    }


    @Override
    public List<Employee> fullListDepart(Integer depart){
       if(depart == null){
            return employeeSet.stream()
                .sorted(Comparator.comparingInt(Employee::getDepart))
                .collect(Collectors.toList());
       }
       else
           return employeeSet.stream()
                   .filter(e -> e.getDepart() == depart)
                   .collect(Collectors.toList());
    }
}
