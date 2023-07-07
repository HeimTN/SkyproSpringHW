package com.heimtn.skyprospringhw.hwcollectionsandSM.controllers;

import com.heimtn.skyprospringhw.hwcollectionsandSM.objects.Employee;
import com.heimtn.skyprospringhw.hwcollectionsandSM.services.DepartmentService;
import com.heimtn.skyprospringhw.hwcollectionsandSM.services.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService){
        this.departmentService = departmentService;
    }


    @GetMapping("/{id}/employees")
    public List<Employee> employees(@PathVariable Integer id){
        return departmentService.getDepartListEmp(id);
    }

    @GetMapping("/{id}/salary/sum")
    public Integer salarySum(@PathVariable Integer id){
        return departmentService.salarySum(id);
    }

    @GetMapping("/{id}/salary/max")
    public Integer salaryMax(@PathVariable Integer id){
        return departmentService.salaryMax(id);
    }

    @GetMapping("/{id}/salary/min")
    public Integer salaryMin(@PathVariable Integer id){
        return departmentService.salaryMin(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> employeesDepart(){
        return departmentService.getMapEmp();
    }

}
