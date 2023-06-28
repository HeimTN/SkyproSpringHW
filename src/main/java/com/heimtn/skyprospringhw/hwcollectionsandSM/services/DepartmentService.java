package com.heimtn.skyprospringhw.hwcollectionsandSM.services;

import com.heimtn.skyprospringhw.hwcollectionsandSM.objects.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<Employee> getDepartListEmp(Integer depart);

    Integer salarySum(Integer depart);

    Integer salaryMax(Integer depart);

    Integer salaryMin(Integer depart);

    Map<Integer, List<Employee>> getMapEmp();
}
