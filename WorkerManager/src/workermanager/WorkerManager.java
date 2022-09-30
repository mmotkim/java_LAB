/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package workermanager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mmotkim
 */
public class WorkerManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1.Declare variables and create objects
        Scanner sc = new Scanner(System.in);
        int choice;
        ArrayList<Worker> WorkerList = new ArrayList<>();
        
        //2.Navigational code 
        do{
            //2.1 Display menu
            ManagementUtilities.displayMenu();
            //2.2 Ask and Get user's choice
            choice = input.getNumber(sc, "", 1, 5);
            //2.3 Loop for management utilities
            switch(choice){
                case 1://Add Worker to the arraylist
                    ManagementUtilities.addWorker(WorkerList);
                    break;
                case 2://Up Salary - increase a worker's salary by an user input's amount
                    ManagementUtilities.increaseSalary(WorkerList);
                    break;
                case 3://Down salary - decrease a worker's salary by an user input's amount
                    ManagementUtilities.decreaseSalary(WorkerList);
                    break;
                case 4://Display information salary
                    ManagementUtilities.displayAll(WorkerList);
                    break;
            } 
        } while (choice < 5);
    }
    
}
