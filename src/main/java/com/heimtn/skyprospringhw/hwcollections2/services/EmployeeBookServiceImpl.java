package com.heimtn.skyprospringhw.hwcollections2.services;

import com.heimtn.skyprospringhw.hwcollections2.objects.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService{
    private final Map<Integer, Employee> employees = new HashMap<>();
    private final Set<Map.Entry<Integer,Employee>> entries = employees.entrySet();


    @Override
    public void startEmployeesBook(){
        addEmployee(new Employee("Иван","Иванов","Иванович",2,10200));
        addEmployee(new Employee("Василий","Васнецов","Васильевич",3,29300));
        addEmployee(new Employee("Пётр","Петров","Петрович",1,89200));
        addEmployee(new Employee("Диана","Девинцина","Петрова",4,800));
        addEmployee(new Employee("Антон","Рылов","Валерьевич",5,190990));
        addEmployee(new Employee("Анна","Кудрявцева","Иванова",5,74000));
        addEmployee(new Employee("Елисей","Быков","Инокентевич",2,32000));
        addEmployee(new Employee("Екатерина","Синицина","Дмитриевна",1,12000));
        addEmployee(new Employee("Леонид","Кудряшов","Антонович",3,7800));
        addEmployee(new Employee("Денис","Антонов","Валерьевич",4,43900));
    }

    @Override
    public Integer generateKey(String firstName, String lastName, String surName){
        return Objects.hash(firstName, lastName, surName);
    }

    @Override
    public Integer generateKey(Employee employee){
        return Objects.hash(employee.getFirstName(),employee.getLastName(),employee.getSurName());
    }

    @Override
    public Employee getEmployee(String firstName, String lastName, String surName){
        Integer temp = generateKey(firstName,lastName,surName);
        if(employees.containsKey(temp)){
            return employees.get(temp);
        }
        throw new RuntimeException("Сотрудник не найден");
    }

    @Override
    public void addEmployee(Employee employee){
        Integer temp = generateKey(employee);
        if(employees.containsKey(temp)){
            employees.put(temp, employee);
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, String surName){
        Integer temp = generateKey(firstName,lastName,surName);
        if(employees.containsKey(temp)){
           return employees.remove(temp);
        }
        throw new RuntimeException("Сотрудник не найден");
    }

    @Override
    public List<Employee> getListEmp(){
        return employees.values().stream().toList();
    }

    @Override
    public int getSumSalary(){
        int sum = 0;
        List<Employee> temp = getListEmp();
        for (Employee employee : temp) {
            if(employee != null)
                sum += employee.getSalary();
        }
        return sum;
    }

    @Override
    public Employee getEmpMinSalary(){
        int temp = Integer.MAX_VALUE;
        Employee temp1 = null;
        List<Employee> temp3 = getListEmp();
        for (Employee employee : temp3) {
            if (employee != null && temp > employee.getSalary()) {
                temp = employee.getSalary();
                temp1 = employee;
            }
        }
        return temp1;
    }

    @Override
    public Employee getEmpMaxSalary(){
        int temp = Integer.MIN_VALUE;
        Employee temp1 = null;
        List<Employee> temp3 = getListEmp();
        for (Employee employee : temp3) {
            if (employee != null && temp < employee.getSalary()) {
                temp = employee.getSalary();
                temp1 = employee;
            }
        }
        return temp1;
    }

    @Override
    public int getMiddleSalary(){
        return getSumSalary()/employees.size();
    }

    @Override
    public void indexingSalary(int rate){
        float temp = (float)rate/100;
        for(Map.Entry<Integer,Employee> entry : entries){
            Employee temp1 = employees.get(entry.getKey());
            temp1.setSalary((int)(temp1.getSalary()+temp1.getSalary()*temp));
        }
    }

    @Override
    public List<Employee> infoDepart(int depart){

        Set<Employee> empDepart = new HashSet<>();
        for(Map.Entry<Integer,Employee> entry : entries){
            Employee temp1 = employees.get(entry.getKey());
            if(temp1.getDepart() == depart)  empDepart.add(temp1);
        }
        return empDepart.stream().toList();
    }

    @Override
    public List<Employee> selectMinSalary(int salary){
        Set<Employee> emp = new HashSet<>();
        for(Map.Entry<Integer,Employee> entry : entries){
            Employee temp1 = employees.get(entry.getKey());
            if(temp1.getSalary() < salary)  emp.add(temp1);
        }
        return emp.stream().toList();
    }

    @Override
    public List<Employee> selectMaxSalary(int salary){
        Set<Employee> emp = new HashSet<>();
        for(Map.Entry<Integer,Employee> entry : entries){
            Employee temp1 = employees.get(entry.getKey());
            if(temp1.getSalary() > salary)  emp.add(temp1);
        }
        return emp.stream().toList();
    }

    @Override
    public void changeEmployee(String lastName, String firstName, String surName, int value){
        if(value > 5){
            Employee temp = getEmployee(firstName, lastName, surName);
            temp.setSalary(value);
            employees.put(generateKey(firstName, lastName, surName),temp);
        }
        else if(value > 0){
            Employee temp = getEmployee(firstName, lastName, surName);
            temp.setDepart(value);
            employees.put(generateKey(firstName, lastName, surName),temp);
        }
        else throw new RuntimeException("Неверные входные данные для изменения сотрудника");
    }
}
