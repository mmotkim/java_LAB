/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mmotkim
 */
class Management {

    static void displayMenu() {
        System.out.println("Main menu:");
        System.out.println("\t1. Add employees");
        System.out.println("\t2. Update employees");
        System.out.println("\t3. Remove employees");
        System.out.println("\t4. Search employees");
        System.out.println("\t5. Sort employees by salary");
        System.out.println("\t6. Exit");
    }

    public static void displayAll(ArrayList<Employee> employeeList){
        System.out.println("Employee List: ");
        System.out.println("ID\tFullName\t\tPhone Number\tEmail\t\tAddress\tDate of Birth\tSex\t\tSalary\t\tAgency");
        for (Employee employee : employeeList) {
            employee.displayOne();
        }
    }
    
    static void addEmployee(ArrayList<Employee> employeeList) {        
        int id = 0;
        
        id = input.getNumber("Input ID: ", 0, Integer.MAX_VALUE);
        //checks if id already exists
        while(checkIdExisting(employeeList, id)){
            System.out.println("ID duplicated!");
            id = input.getNumber("Input ID: ", 0, Integer.MAX_VALUE);
        }
        
        String firstName = input.getString("Input First Name: ");
        
        String lastName = input.getString("Input Last Name: ");
        
        String phoneNumber = input.getString("Input phone number: ", "^[0-9]{10}$");
        
        String email = input.getString("Input email:", "^[\\w]+@([\\w]+\\.)+[\\w-]{2,4}$");
        
        String address = input.getString("Input address: ");
        
        LocalDate DOB = input.getDate("Input date (day/month/year): ");
        
        String sex = input.getDoubleChoice("Input gender (M/L)", "M", "L");
        
        int salary = input.getNumber("Input salary: ", 0, Integer.MAX_VALUE);
        
        String agency = input.getString("Input agency: ");
        
        //Create a new employee object and add it to the list
        Employee employee = new Employee(id, firstName, lastName, phoneNumber, email, address, DOB, sex, salary, agency);
        employeeList.add(employee);
        
        
    }

    static void updateEmployee(ArrayList<Employee> employeeList) {
        Scanner sc = new Scanner(System.in);
        int newId;

        //check if list is empty
        if(employeeList.isEmpty()){
            System.out.println("empty list!");
        }

        Employee update = getEmployee(employeeList);

        System.out.println("ID found! Employee info:");
        System.out.println("ID\tFullName\t\tPhone Number\tEmail\t\tAddress\tDate of Birth\tSex\t\tSalary\t\tAgency");
        update.displayOne();

        newId = input.getNumber("Input ID: ", 0, Integer.MAX_VALUE);
        //checks if id already exists
        while(checkIdExisting(employeeList, newId)){
            System.out.println("ID duplicated!");
            newId = input.getNumber("Input ID: ", 0, Integer.MAX_VALUE);
        }

        update.setId(newId);

        update.setFirstName(input.getString("Input new First Name: ")); 
        update.setLastName(input.getString("Input new last name: "));
        update.setPhone(input.getString("Input new phone number: ", "^[0-9]{10}$"));
        update.setEmail(input.getString("Input new email:", "^[\\w]+@([\\w]+\\.)+[\\w-]{2,4}$"));
        update.setAddress(input.getString("Input new address: "));
        update.setDOB(input.getDate("Input new date of birth (day/month/year): "));
        update.setSex(input.getDoubleChoice("Input new gender (M/L)", "M", "L"));
        update.setSalary(input.getNumber("Input new salary: ", 0, Integer.MAX_VALUE));
        update.setAgency(input.getString("Input new agency: "));

    }

    static void removeEmployee(ArrayList<Employee> employeeList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void searchEmployee(ArrayList<Employee> employeeList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void sortEmployee(ArrayList<Employee> employeeList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    static boolean checkIdExisting(ArrayList<Employee> employeeList, int id){
        for (Employee employee : employeeList) {
            if (employee.getId() == id){
                return true;
            }
            
        }
        return false;
    }

    public static Employee getEmployee(ArrayList<Employee> employeeList){
        int id = 0;
        
        id = input.getNumber("Input ID: ", 0, Integer.MAX_VALUE);
        //checks if id already exists
        while(!checkIdExisting(employeeList, id)){
            System.out.println("ID doesn't exists!");
            id = input.getNumber("Input ID: ", 0, Integer.MAX_VALUE);
        }


        for(Employee employee : employeeList){
            if(employee.getId() == id){
                return employee;
            } 
        }

        return null;
    }
}
