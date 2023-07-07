package com.heimtn.skyprospringhw.hwcollectionsandSM.services;

import com.heimtn.skyprospringhw.hwcollectionsandSM.objects.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;
    private final Map<Integer, List<Employee>> employeeList;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService){
        this.employeeService = employeeService;
        this.employeeList = new HashMap<>();
        List<Employee> tempEmpList = employeeService.getList();
        tempEmpList.stream().forEach(e -> {
            if(!employeeList.containsKey(e.getDepartment())){
                employeeList.put(e.getDepartment(), getListDepartEmpForMap(tempEmpList, e.getDepartment()));
            }
        });
    }

    private List<Employee> getListDepartEmpForMap(List<Employee> temp, int depart){
        return temp.stream().filter(e -> e.getDepartment() == depart).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getDepartListEmp(Integer depart){
        if(employeeList.containsKey(depart)) {
            return employeeList.get(depart);
        }
        else throw new IllegalArgumentException("Данного департамента в базе нет");
    }

    @Override
    public Integer salarySum(Integer depart){
        Integer sum = 0;
        for(Employee emp : getDepartListEmp(depart)){
            sum = sum + emp.getSalary();
        }
        return sum;
    }

    @Override
    public Integer salaryMax(Integer depart){
        Integer max = Integer.MIN_VALUE;
        for(Employee emp : getDepartListEmp(depart)){
            if(max < emp.getSalary()) max = emp.getSalary();
        }
        return max;
    }

    @Override
    public Integer salaryMin(Integer depart){
        Integer min = Integer.MAX_VALUE;
        for(Employee emp : getDepartListEmp(depart)){
            if(min > emp.getSalary()) min = emp.getSalary();
        }
        return min;
    }

    @Override
    public Map<Integer, List<Employee>> getMapEmp(){
        return employeeList;
    }




}
