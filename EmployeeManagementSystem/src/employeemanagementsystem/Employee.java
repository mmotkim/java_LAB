/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Mmotkim
 */
public class Employee implements Comparable<Employee> {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private LocalDate DOB;
    private String sex;
    private int salary;
    private String agency;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String phone, String email, String address, LocalDate DOB, String sex, int salary, String agency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    
    
    public String getFullName(){
        return firstName + " " + lastName;
    }

    public void displayOne(){
        System.out.println(id + "\t" + getFullName() + "\t" + phone 
                + "\t" + email + "\t" + address + "\t" + DOB + "\t" + sex 
                + "\t\t" + salary + "\t\t" + agency);
    }

    @Override
    public int compareTo(Employee e) {
        return Integer.compare(this.getSalary(), e.getSalary());
    }



    
    
    
    
}
