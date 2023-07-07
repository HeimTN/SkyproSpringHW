package com.heimtn.skyprospringhw.hwcollectionsandSM.services;

import com.heimtn.skyprospringhw.hwcollectionsandSM.objects.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    private DepartmentService departmentService;


    @BeforeEach
    public void setUp(){
        List<Employee> mocEmpList = Arrays.asList(
                new Employee("Какой то", "Чел 1", 1000, 1),
                new Employee("Какой то", "Чел 2", 100, 1),
                new Employee("Какой то", "Чел 3", 90, 10),
                new Employee("Какой то", "Чел 4", 100, 10),
                new Employee("Какой то", "Чел 5", 100, 5),
                new Employee("Какой то", "Чел 6", 1, 3),
                new Employee("Какой то", "Чел 7", 100, 3),
                new Employee("Какой то", "Чел 8", 1009, 3)
        );

        Mockito.when(employeeService.getList()).thenReturn(mocEmpList);

        departmentService = new DepartmentServiceImpl(employeeService);
    }

    @Test
    public void getDepartListEmp(){
        List<Employee> actual = departmentService.getDepartListEmp(10);
        List<Employee> actual1 = departmentService.getDepartListEmp(3);
        List<Employee> actual2 = departmentService.getDepartListEmp(5);

        List<Employee> expected = employeeService.getList().stream().filter(e -> e.getDepartment() == 10).toList();
        List<Employee> expected1 = employeeService.getList().stream().filter(e -> e.getDepartment() == 3).toList();
        List<Employee> expected2 = employeeService.getList().stream().filter(e -> e.getDepartment() == 5).toList();

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    public void getDepartListEmpNegative(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> departmentService.getDepartListEmp(7));
        Assertions.assertEquals("Данного департамента в базе нет", thrown.getMessage());

        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class,
                () -> departmentService.getDepartListEmp(-1));
        Assertions.assertEquals("Данного департамента в базе нет", thrown1.getMessage());
    }

    @Test
    public void salarySum(){
       Assertions.assertEquals(1110, departmentService.salarySum(3));
       Assertions.assertEquals(100, departmentService.salarySum(5));
    }

    @Test
    public void salarySumNegative(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> departmentService.salarySum(7));
        Assertions.assertEquals("Данного департамента в базе нет", thrown.getMessage());
    }

    @Test
    public void salaryMax(){
        Assertions.assertEquals(1000, departmentService.salaryMax(1));
        Assertions.assertEquals(100, departmentService.salaryMax(10));
        Assertions.assertEquals(1009, departmentService.salaryMax(3));
        Assertions.assertEquals(100, departmentService.salaryMax(5));
    }

    @Test
    public void salaryMaxNegative(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> departmentService.salaryMax(7));
        Assertions.assertEquals("Данного департамента в базе нет", thrown.getMessage());
    }

    @Test
    public void salaryMin(){
        Assertions.assertEquals(100, departmentService.salaryMin(1));
        Assertions.assertEquals(90, departmentService.salaryMin(10));
        Assertions.assertEquals(1, departmentService.salaryMin(3));
        Assertions.assertEquals(100, departmentService.salaryMin(5));
    }

    @Test
    public void salaryMinNegative(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> departmentService.salaryMin(7));
        Assertions.assertEquals("Данного департамента в базе нет", thrown.getMessage());
    }

    @Test
    public void getMapEmp(){
        Map<Integer, List<Employee>> actualMap = departmentService.getMapEmp();

        Map<Integer, List<Employee>> expectedMap = new HashMap<>();;
        List<Employee> temp = employeeService.getList().stream().sorted(Comparator.comparing(Employee::getDepartment)).toList();
        for(Employee emp : temp){
            if(!expectedMap.containsKey(emp.getDepartment())){
                List<Employee> temp1 = employeeService.getList().stream().filter(e -> Objects.equals(e.getDepartment(), emp.getDepartment())).toList();
                expectedMap.put(emp.getDepartment(), temp1);
            }
        }
        List<Employee> actual = departmentService.getMapEmp().get(10);
        List<Employee> actual1 = departmentService.getMapEmp().get(5);
        List<Employee> actual2 = departmentService.getMapEmp().get(3);

        List<Employee> expected = expectedMap.get(10);
        List<Employee> expected1 = expectedMap.get(5);
        List<Employee> expected2 = expectedMap.get(3);

        Assertions.assertEquals(expectedMap, actualMap);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);

    }
}
