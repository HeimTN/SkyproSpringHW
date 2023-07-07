package com.heimtn.skyprospringhw.hwcollectionsandSM.services;

import com.heimtn.skyprospringhw.hwcollectionsandSM.exceptions.EmployeeAlreadyAddedException;
import com.heimtn.skyprospringhw.hwcollectionsandSM.exceptions.EmployeeNotFoundException;
import com.heimtn.skyprospringhw.hwcollectionsandSM.exceptions.EmployeeStorageIsFullException;
import com.heimtn.skyprospringhw.hwcollectionsandSM.objects.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private List<Employee> employees = new ArrayList<>();
    private final static int maxEmp = 10;


    @Override
    public void addEmp(String firstName, String lastName, Integer depart, Integer salary) {
        Employee employee = new Employee(firstName, lastName, salary, depart);
        if(employees.size() <= maxEmp-1) {
            if(employees.contains(employee)) throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
            else employees.add(employee);
        }
        else throw new EmployeeStorageIsFullException("Лист заполнен");
    }

    @Override
    public void removeEmp(String firstName, String lastName, Integer depart, Integer salary) {
        Employee employee = new Employee(firstName, lastName, salary, depart);
        if(employees.contains(employee)) employees.remove(employee);
        else throw new EmployeeNotFoundException("Сотрудник для удаления не найден");
    }

    @Override
    public Employee searchEmp(String firstName, String lastName, Integer depart, Integer salary) {
        Employee employee = new Employee(firstName, lastName, salary, depart);
        if (employees.contains(employee)) {
            int temp = 0;
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).equals(employee)){
                    temp = i;
                    break;
                }
            }
            return employees.get(temp);
        }
        else throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public List<Employee> getList(){
        return employees;
    }
}
