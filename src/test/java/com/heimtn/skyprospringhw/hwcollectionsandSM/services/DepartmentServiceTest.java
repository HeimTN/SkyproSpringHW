package com.heimtn.skyprospringhw.hwcollectionsandSM.services;

import com.heimtn.skyprospringhw.hwcollectionsandSM.objects.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


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
        List<Employee> actual1 = departmentService.getDepartListEmp(1);

        Assertions.assertEquals(10,actual.get(Mockito.anyInt()).getDepartment());
        Assertions.assertEquals(1,actual1.get(Mockito.anyInt()).getDepartment());
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
        Map<Integer, List<Employee>> actual = departmentService.getMapEmp();

        Assertions.assertEquals(10, actual.get(10).get(Mockito.anyInt()).getDepartment());
        Assertions.assertEquals(1, actual.get(1).get(Mockito.anyInt()).getDepartment());
        Assertions.assertEquals(3, actual.get(3).get(Mockito.anyInt()).getDepartment());
        Assertions.assertEquals(5, actual.get(5).get(Mockito.anyInt()).getDepartment());
    }
}
