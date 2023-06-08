package com.heimtn.skyprospringhw.hwcollections2.controllers;

import com.heimtn.skyprospringhw.hwcollections2.exceptions.UnCorrectStringException;
import com.heimtn.skyprospringhw.hwcollections2.objects.Employee;
import com.heimtn.skyprospringhw.hwcollections2.services.EmployeeBookService;
import com.heimtn.skyprospringhw.hwcollections2.services.EmployeeBookServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp-book")
public class EmployeeBookController {
    private final EmployeeBookService employeeBookService = new EmployeeBookServiceImpl();

    @GetMapping("/start")
    public String start(){
        employeeBookService.startEmployeesBook();
        return "Здарова";
    }

    @GetMapping("/add")
    public Employee addEmp(@RequestParam("firstName")String firstName,
                           @RequestParam("lastName")String lastName,
                           @RequestParam("surName")String surName,
                           @RequestParam("depart")int depart,
                           @RequestParam("salary")int salary){
        if(checkString(firstName)&&checkString(lastName)&&checkString(surName)) {
            Employee temp = new Employee(standString(firstName), standString(lastName), standString(surName), depart, salary);
            employeeBookService.addEmployee(temp);
            return temp;
        } else throw new UnCorrectStringException("Введены некорректные данные");
    }

    @GetMapping("/get")
    public Employee getEmp(@RequestParam("firstName")String firstName,
                           @RequestParam("lastName")String lastName,
                           @RequestParam("surName")String surName){
        if(checkString(firstName)&&checkString(lastName)&&checkString(surName)) {
            return employeeBookService.getEmployee(standString(firstName), standString(lastName), standString(surName));
        } else throw new UnCorrectStringException("Введены некорректные данные");
    }
    @GetMapping("/remove")
    public Employee removeEmp(@RequestParam("firstName")String firstName,
                              @RequestParam("lastName")String lastName,
                              @RequestParam("surName")String surName){
        if(checkString(firstName)&&checkString(lastName)&&checkString(surName)) {
            return employeeBookService.removeEmployee(standString(firstName), standString(lastName), standString(surName));
        } else throw new UnCorrectStringException("Введены некорректные данные");
    }

    @GetMapping("/full-list")
    public List<Employee> fullList(){
        return employeeBookService.getListEmp();
    }

    @GetMapping("/sum-salary")
    public int sumSalary(){
        return employeeBookService.getSumSalary();
    }
    @GetMapping("/min-salary")
    public Employee minSalary(){
        return employeeBookService.getEmpMinSalary();
    }
    @GetMapping("/max-salary")
    public Employee maxSalary(){
        return employeeBookService.getEmpMaxSalary();
    }
    @GetMapping("/middle-salary")
    public int middleSalary(){
        return  employeeBookService.getMiddleSalary();
    }
    @GetMapping("/indexing")
    public String indexingSalary(@RequestParam("rate")int rate){
        employeeBookService.indexingSalary(rate);
        return "Зарплата увеличена";
    }
    @GetMapping("/depart-info")
    public List<Employee> infoDepart(@RequestParam("depart")int depart){
        return employeeBookService.infoDepart(depart);
    }
    @GetMapping("/emp-min-salary")
    public List<Employee> empMinSalary(@RequestParam("salary")int salary){
        return employeeBookService.selectMinSalary(salary);
    }
    @GetMapping("/emp-max-salary")
    public List<Employee> empMaxSalary(@RequestParam("salary")int salary){
        return employeeBookService.selectMaxSalary(salary);
    }
    @GetMapping("/change-emp")
    public String changeEmp(@RequestParam("firstName")String firstName,
                            @RequestParam("lastName")String lastName,
                            @RequestParam("surName")String surName,
                            @RequestParam("value")int value){
        if(checkString(firstName)&&checkString(lastName)&&checkString(surName)) {
            employeeBookService.changeEmployee(standString(lastName), standString(firstName), standString(surName), value);
            return "Сотрудник изменен";
        } else throw new UnCorrectStringException("Введены некорректные данные");
    }

    private boolean checkString(String str){
        return StringUtils.isAlpha(str) && StringUtils.isNoneEmpty(str);
    }

    private String standString(String str){
        str = StringUtils.lowerCase(str);
        return StringUtils.capitalize(str);
    }
}
