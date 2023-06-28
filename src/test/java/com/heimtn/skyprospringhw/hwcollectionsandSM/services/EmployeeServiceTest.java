package com.heimtn.skyprospringhw.hwcollectionsandSM.services;

import com.heimtn.skyprospringhw.hwcollectionsandSM.exceptions.EmployeeAlreadyAddedException;
import com.heimtn.skyprospringhw.hwcollectionsandSM.exceptions.EmployeeNotFoundException;
import com.heimtn.skyprospringhw.hwcollectionsandSM.exceptions.EmployeeStorageIsFullException;
import com.heimtn.skyprospringhw.hwcollectionsandSM.objects.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void getList(){
        //Формальная проверка метода возвращающего лист, т.к. в дальнейшем планирую использовать для проверок
        Assertions.assertTrue(employeeService.getList() instanceof List<Employee>);
    }


    @Test
    public void addEmp(){
        //Добавление нового сотрудника
        employeeService.addEmp("Алексей", "Алёшков", 2, 30400);
        Assertions.assertTrue(employeeService.getList().contains(new Employee("Алексей", "Алёшков", 2, 30400)));

        //Попытка добавления сотрудника который уже есть в базе
        employeeService.addEmp("Евгений", "Добрый", 2, 30400);
        EmployeeAlreadyAddedException thrown = Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmp("Евгений", "Добрый", 2, 30400));
        Assertions.assertEquals("Такой сотрудник уже есть", thrown.getMessage());

        //Проверка ограничения базы
        employeeService.addEmp("Какой то", "Чел 1", 1, 100);
        employeeService.addEmp("Какой то", "Чел 2", 1, 100);
        employeeService.addEmp("Какой то", "Чел 3", 1, 100);
        employeeService.addEmp("Какой то", "Чел 4", 1, 100);
        employeeService.addEmp("Какой то", "Чел 5", 1, 100);
        employeeService.addEmp("Какой то", "Чел 6", 1, 100);
        employeeService.addEmp("Какой то", "Чел 7", 1, 100);
        employeeService.addEmp("Какой то", "Чел 8", 1, 100);
        EmployeeStorageIsFullException thrown1 = Assertions.assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.addEmp("Какой то", "Чел 9", 1, 100));
        Assertions.assertEquals("Лист заполнен", thrown1.getMessage());
    }

    @Test
    public void removeEmp(){
        employeeService.addEmp("Алексей", "Алёшков", 2, 30400);
        employeeService.addEmp("Евгений", "Добрый", 2, 30400);

        //Проверка удаления сотрудника
        employeeService.removeEmp("Алексей", "Алёшков", 2, 30400);
        Assertions.assertFalse(employeeService.getList().contains(new Employee("Алексей", "Алёшков", 2, 30400)));

        //Попытка удаления уже удаленного сотрудника
        EmployeeNotFoundException thrown = Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.removeEmp("Алексей", "Алёшков", 2, 30400));
        Assertions.assertEquals("Сотрудник для удаления не найден", thrown.getMessage());

        //Попытка удаления сотрудника которого небыло в базе
        EmployeeNotFoundException thrown1 = Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.removeEmp("Какой то", "Чел 1", 1, 100));
        Assertions.assertEquals("Сотрудник для удаления не найден", thrown1.getMessage());

        //Попытка удаления сотрудника из пустой базы
        employeeService.removeEmp("Евгений", "Добрый", 2, 30400);
        EmployeeNotFoundException thrown2 = Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.removeEmp("Какой то", "Чел 1", 1, 100));
        Assertions.assertEquals("Сотрудник для удаления не найден", thrown2.getMessage());
    }

    @Test
    public void searchEmp(){
        employeeService.addEmp("Алексей", "Алёшков", 2, 30400);
        employeeService.addEmp("Евгений", "Добрый", 2, 30400);

        //Проверка поиска сотрудника
        Assertions.assertEquals(employeeService.searchEmp("Алексей", "Алёшков", 2, 30400),
                new Employee("Алексей", "Алёшков", 2, 30400));

        //Проверка поиска несуществующего сотрудника
        EmployeeNotFoundException thrown = Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.searchEmp("Какой то", "Чел 1", 1, 100));
        Assertions.assertEquals("Сотрудник не найден", thrown.getMessage());

        //Проверка поиска сотрудника с ошибкой в данных
        EmployeeNotFoundException thrown1 = Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.searchEmp("Олексей", "Алёшков", 2, 30400));
        Assertions.assertEquals("Сотрудник не найден", thrown1.getMessage());

        //Проверка поиска по пустой базе
        employeeService.removeEmp("Алексей", "Алёшков", 2, 30400);
        employeeService.removeEmp("Евгений", "Добрый", 2, 30400);
        EmployeeNotFoundException thrown2 = Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.searchEmp("Алексей", "Алёшков", 2, 30400));
        Assertions.assertEquals("Сотрудник не найден", thrown2.getMessage());
    }
}
