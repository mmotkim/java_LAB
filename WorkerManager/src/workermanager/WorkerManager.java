/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package workermanager;

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
        
        //2.Navigational code 
        do{
            //2.1 Display menu
            display.displayMenu();
            //2.2 Ask and Get user's choice
            choice = getInput.getUserChoice(sc);
            //2.3 Loop for management options
            switch(choice){
                case 1://Add Worker
                    
                case 2://Up Salary
                    
                case 3://Down salary
                    
                case 4://Display information salary
                    
            } 
        } while (choice < 5);
    }
    
}
