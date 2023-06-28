package com.heimtn.skyprospringhw.hwcollectionsandSM.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    private final DepartmentService departmentService= new DepartmentServiceImpl(employeeService);

    @Test
    public void getDepartListEmp(){
        //Проверка возвращения списка с нужным департаментом
        Mockito.when(departmentService.getDepartListEmp(5).get(Mockito.anyInt()).getDepartment()).thenReturn(5);
        Assertions.assertEquals(5, departmentService.getDepartListEmp(5).get(Mockito.anyInt()).getDepartment());
    }

    @Test
    public void salarySum(){
        //Проверка возвращения суммы зарплат
        Mockito.when(departmentService.salarySum(Mockito.anyInt())).thenReturn(Mockito.anyInt());
        Assertions.assertEquals(Mockito.anyInt(), departmentService.salarySum(Mockito.anyInt()));
    }

    @Test
    public void salaryMax(){
        //Проверка возвращения максимальной зарплаты
        Mockito.when(departmentService.salaryMax(Mockito.anyInt())).thenReturn(Mockito.anyInt());
        Assertions.assertEquals(Mockito.anyInt(), departmentService.salaryMax(Mockito.anyInt()));
    }

    @Test
    public void salaryMin(){
        //Проверка возвращения минимальной зарплаты
        Mockito.when(departmentService.salaryMin(Mockito.anyInt())).thenReturn(Mockito.anyInt());
        Assertions.assertEquals(Mockito.anyInt(), departmentService.salaryMin(Mockito.anyInt()));
    }

    @Test
    public void getMapEmp(){
        //Проверка вовзращения полного списка всех сотрудников с сортировкой по департаментам
        Mockito.when(departmentService.getMapEmp().get(10).get(Mockito.anyInt()).getDepartment()).thenReturn(10);
        Assertions.assertEquals(10, departmentService.getMapEmp().get(10).get(Mockito.anyInt()).getDepartment());
    }
}
