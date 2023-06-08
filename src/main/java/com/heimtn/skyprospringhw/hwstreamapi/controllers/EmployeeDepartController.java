package com.heimtn.skyprospringhw.hwstreamapi.controllers;


import com.heimtn.skyprospringhw.hwcollections2.objects.Employee;
import com.heimtn.skyprospringhw.hwstreamapi.services.EmployeeDepartService;
import com.heimtn.skyprospringhw.hwstreamapi.services.EmployeeDepartServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class EmployeeDepartController {
    private final EmployeeDepartService employeeDepartService = new EmployeeDepartServiceImpl();

    @GetMapping("/start")
    public void start(){
        employeeDepartService.addEmployee(new Employee("Иван","Иванов","Иванович",2,10200));
        employeeDepartService.addEmployee(new Employee("Василий","Васнецов","Васильевич",3,29300));
        employeeDepartService.addEmployee(new Employee("Пётр","Петров","Петрович",1,89200));
        employeeDepartService.addEmployee(new Employee("Диана","Девинцина","Петрова",4,800));
        employeeDepartService.addEmployee(new Employee("Антон","Рылов","Валерьевич",5,190990));
        employeeDepartService.addEmployee(new Employee("Анна","Кудрявцева","Иванова",5,74000));
        employeeDepartService.addEmployee(new Employee("Елисей","Быков","Инокентевич",2,32000));
        employeeDepartService.addEmployee(new Employee("Екатерина","Синицина","Дмитриевна",1,12000));
        employeeDepartService.addEmployee(new Employee("Леонид","Кудряшов","Антонович",3,7800));
        employeeDepartService.addEmployee(new Employee("Денис","Антонов","Валерьевич",4,43900));
    }


    @GetMapping("/max-salary")
    public Employee maxSal(@RequestParam("departmentId")Integer departmentId){
        return employeeDepartService.maxSalaryByDepart(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee minSal(@RequestParam("departmentId")Integer departmentId){
        return employeeDepartService.minSalaryByDepart(departmentId);
    }
    @GetMapping("/all")
    public List<Employee> allEmpDepart(Integer departmentId){
        return employeeDepartService.fullListDepart(departmentId);
    }
}
