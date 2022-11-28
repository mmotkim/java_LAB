/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taskmanager;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Mmotkim
 */
public class TaskManager {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        //1. Create necessary objects and variables
        File taskListFile = Management.checkFile("taskList.txt");
        int choice;
        int lastID = Management.getLastID(taskListFile);
        //2. Navigational Code
        do{
            //2.1 display menu
            Management.displayMenu();
            //2.2 get user input on options
            choice = input.getNumber("Choose an option: ", 0, 5);
            //2.3 perform utilities
            switch(choice){
                case 1:
                    lastID = Management.addTask(taskListFile, lastID);
                    break;
                case 2:
                    Management.deleteTask(taskListFile);
                    break;
                case 3:
                    Management.displayTask(taskListFile);
                    break;
            }
        } while(choice < 4);
    }
    
}
