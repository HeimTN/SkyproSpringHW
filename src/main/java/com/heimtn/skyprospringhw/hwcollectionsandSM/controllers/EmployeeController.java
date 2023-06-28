package com.heimtn.skyprospringhw.hwcollectionsandSM.controllers;

import com.heimtn.skyprospringhw.hwcollectionsandSM.objects.Employee;
import com.heimtn.skyprospringhw.hwcollectionsandSM.services.EmployeeService;
import com.heimtn.skyprospringhw.hwcollectionsandSM.services.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                @RequestParam("depart") Integer depart, @RequestParam("salary") Integer salary){
        employeeService.addEmp(firstName,lastName, salary, depart);
        return employeeService.searchEmp(firstName,lastName, salary, depart);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                   @RequestParam("depart") Integer depart, @RequestParam("salary") Integer salary){
        employeeService.removeEmp(firstName,lastName, salary, depart);
        return new Employee(firstName, lastName, salary, depart);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                 @RequestParam("depart") Integer depart, @RequestParam("salary") Integer salary){
        return employeeService.searchEmp(firstName, lastName, salary, depart);
    }
    @GetMapping("/list")
    public List<Employee> fullListEmployee(){
        return employeeService.getList();
    }
}
