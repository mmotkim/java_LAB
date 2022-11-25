/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employeemanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author Mmotkim
 */
public class EmployeeManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1. Create objects
        int choice;
        ArrayList<Employee> employeeList = new ArrayList<>();
        //2. Navigational loop
        do{
            //2.1 Display menu
            Management.displayMenu();
            //2.2 Get user input on management choices
            choice = input.getNumber("Choose an option: ", 0, 6);
            //2.3 Perform management utilities
            switch(choice){
                case 1:
                    Management.addEmployee(employeeList);
                    break;
                case 2:
                    Management.updateEmployee(employeeList);
                    break;
                case 3:
                    Management.removeEmployee(employeeList);
                    break;
                case 4:
                    Management.searchEmployee(employeeList);
                    break;
                case 5:
                    //sort by salary
                    Management.sortEmployee(employeeList);
                    break;
            }
        } while(choice < 5);
    }
    
}
