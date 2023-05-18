package com.heimtn.skyprospringhw.hwcollections2.objects;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String surName;
    private int depart;
    private int salary;
    private int id;
    private static int counter = 1;

    public Employee(String firstName, String lastName, String surName, int depart, int salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        if(depart > 0 && depart <= 5) this.depart = depart;
        else throw new IllegalArgumentException("Неверный номер отдела");
        this.salary = salary;
        this.id = counter;
        counter++;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getSurName(){
        return surName;
    }
    public int getDepart(){
        return depart;
    }
    public int getSalary(){
        return salary;
    }
    public int getId(){
        return id;
    }
    public void setDepart(int temp){
        this.depart = temp;
    }
    public void setSalary(int temp){
        this.salary = temp;
    }
    @Override
    public String toString(){
        if(this != null)
            return getId()+". Сотрудник: "+getLastName()+" "+getFirstName()+" "+getSurName()+"; Отдел №"+getDepart()+" Получает зарплату: "+getSalary()+" руб.";
        else return "Сотрудник отсутсвует";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return depart == employee.depart && salary == employee.salary && id == employee.id && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(surName, employee.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, surName, depart, salary, id);
    }
}
