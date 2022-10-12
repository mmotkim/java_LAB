/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mmotk
 */
public class StudentManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1. Declare variables and create objects
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> StudentList = new ArrayList<>();
        int choice;

        //2. Navigational Code
        do{
            //2.1 Display menu
            ManagerUtilities.displayMenu();
            //2.2 Get user's choice
            choice = input.getNumber(sc, "", 1, 5);
            //2.3 Manager utility choices loop
            switch(choice){
                case 1: //Add Student to arraylist
                    ManagerUtilities.createStudent(StudentList);
                    break;
                case 2: //Find and sort student both by name in arraylist then display them
                    ManagerUtilities.FindAndSort(StudentList);
                    break;
                case 3: //Prompt and ask for update/delete choice and perform functions accordingly
                    ManagerUtilities.UpdateOrDelete(StudentList);
                    break;
                case 4: //Display all students info
                    ManagerUtilities.displayAll(StudentList);
                    break;
            }       
        } while (choice < 5);
        
    }
    
}
