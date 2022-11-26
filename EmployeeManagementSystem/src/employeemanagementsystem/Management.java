/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
        int newId;
        int choice = 0;
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
        
        //properties Update loop
        do{
            updateMenu();
            choice = input.getNumber("Select an option: ", -1, 11);
            
            switch(choice){
                case 1:
                    update.setId(newId);
                    break;
                case 2:
                    update.setFirstName(input.getString("Input new First Name: ")); 
                    break;
                case 3:
                    update.setLastName(input.getString("Input new last name: "));
                    break;
                case 4:
                    update.setPhone(input.getString("Input new phone number: ", "^[0-9]{10}$"));
                    break;
                case 5:
                    update.setEmail(input.getString("Input new email:", "^[\\w]+@([\\w]+\\.)+[\\w-]{2,4}$"));
                    break;
                case 6:    
                    update.setAddress(input.getString("Input new address: "));
                    break;
                case 7:
                    update.setDOB(input.getDate("Input new date of birth (day/month/year): "));
                    break;
                case 8:
                    update.setSex(input.getDoubleChoice("Input new gender (M/L)", "M", "L"));
                    break;
                case 9: 
                    update.setSalary(input.getNumber("Input new salary: ", 0, Integer.MAX_VALUE));
                    break;
                case 10:
                    update.setAgency(input.getString("Input new agency: "));
                    break;  
            }
        } while(choice > 0);

    }

    static void removeEmployee(ArrayList<Employee> employeeList) {
        //check if list is empty
        if(employeeList.isEmpty()){
            System.out.println("empty list!");
        }
        //get exact employee from user input
        Employee employeeToDelete = getEmployee(employeeList);
        //delete that employee
        employeeList.remove(employeeToDelete);

    }

    static void searchEmployee(ArrayList<Employee> employeeList) {
        ArrayList<Employee> foundList = new ArrayList<>();
        //check if list is empty
        if(employeeList.isEmpty()){
            System.out.println("empty list!");
        }
        
        //search loop
        do{
            String searchInput = input.getString("Input Employee name to search: ");
            
            //tranverse the employee list and add employees found to foundList
            for (Employee employee : employeeList) {
                if (employee.getFullName().contains(searchInput)){
                    foundList.add(employee);
                }
            }
            
            if(foundList.isEmpty()){
                System.out.println("No employee found! try again.");
            } else 
                displayAll(foundList);
        } while(true);
        
        
        
    }

    static void updateMenu(){
        System.out.println("Update Options:");
        System.out.println("1. Update ID");
        System.out.println("2. Update First Name");
        System.out.println("3. Update Last Name");
        System.out.println("4. Update Phone Number");
        System.out.println("5. Update Email address");
        System.out.println("6. Update address");
        System.out.println("7. Update date of birth");
        System.out.println("8. Update Gender");
        System.out.println("9. Update Salary");
        System.out.println("10. Update Agency");
        System.out.println("0. Exit");
    }
    
    static void sortEmployee(ArrayList<Employee> employeeList) {
        Collections.sort(employeeList);
        displayAll(employeeList);
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
