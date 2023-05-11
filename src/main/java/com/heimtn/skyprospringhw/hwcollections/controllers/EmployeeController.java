package com.heimtn.skyprospringhw.hwcollections.controllers;

import com.heimtn.skyprospringhw.hwcollections.objects.Employee;
import com.heimtn.skyprospringhw.hwcollections.services.EmployeeService;
import com.heimtn.skyprospringhw.hwcollections.services.EmployeeServiceImpl;
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
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        employeeService.addEmp(firstName,lastName);
        return employeeService.searchEmp(firstName,lastName);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        employeeService.removeEmp(firstName,lastName);
        return new Employee(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return employeeService.searchEmp(firstName, lastName);
    }
    @GetMapping("/list")
    public List<Employee> fullListEmployee(){
        return employeeService.getList();
    }
}
