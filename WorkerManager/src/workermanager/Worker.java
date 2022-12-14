/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workermanager;

/**
 *
 * @author Mmotkim
 */
public class Worker {

    private int id;
    private String name;
    private int age;
    private int salary;
    private String location;

    
    public Worker() {
    }
    

    public Worker(int id, String name, int age, int salary, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + age + "|" + salary + "|" + location;
    }
    
    
}
