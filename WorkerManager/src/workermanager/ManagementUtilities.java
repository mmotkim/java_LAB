/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workermanager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mmotkim
 */
public class ManagementUtilities {
    
    public static void displayMenu(){
        System.out.println("\n======== Worker Management ========");
        System.out.println("   1. Add Worker");
        System.out.println("   2. Up Salary");
        System.out.println("   3. Down Salary");
        System.out.println("   4. Display Information salary");
        System.out.println("   5. Exit");
    }

    private static boolean checkIdExisting(int id, ArrayList<Worker> WorkerList) {
        //declare variable
        boolean isExist = false;
        
        //loop accessing elements of array one by one
        for (Worker worker : WorkerList) {
            //comparing id with each existing id elements - similar to linear search
            if (worker.getId() == id) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }
        
    
    public static void addWorker(ArrayList<Worker> WorkerList){
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("--------- Add Worker ----------");
        
        //Get ID
        
        int id;
        //loop to get user input's ID and checks if it's duplicated
        do{
            id = input.getNumber(sc, "Enter Code: ", 1, Integer.MAX_VALUE);
            
            if (checkIdExisting(id, WorkerList)) {
                System.out.println("Worker ID already exists!");
            } else 
                break;
            
        } while (true);
        
        //Get Name
        String name = input.getString(sc, "Enter Name: ", true);
        //Get Age
        int age = input.getNumber(sc, "Enter Age: ", 18, 50);
        //Get Salary
        int salary = input.getNumber(sc, "Enter Salary: ", 0, Integer.MAX_VALUE);
        //Get work location
        String location = input.getString(sc, "Enter work location: ", false);
        
        
        //Create an Worker object and append all the inputs then add it to the array list
        Worker worker = new Worker(id, name, age, salary, location);
        WorkerList.add(worker);
    }
    
    public static void increaseSalary(ArrayList<Worker> WorkerList){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("------- Up/Down Salary -------");
        
        //Get ID
        int id;
        //loop to get user input's ID and checks if it exists
        do{
            id = input.getNumber(sc, "Enter Code: ", 1, Integer.MAX_VALUE);
            
            if (checkIdExisting(id, WorkerList)) {
                System.out.println(" > Worker ID found!");
                break;
            } else 
                System.out.println(" > Worker ID not found! Try again.");
            
        } while (true);
        
        
        //Get Salary Input
        int salaryIncrease = input.getNumber(sc, "Enter Salary: ", 0, Integer.MAX_VALUE);
        
        
        //loop to find correct worker
        for (Worker worker : WorkerList) {
            //comparing id with each existing id elements - similar to linear search
            if (worker.getId() == id) {
                //add inputted salary to current worker's salary
                worker.setSalary(worker.getSalary() + salaryIncrease);
                System.out.println(" > Salary raised :)");
                break;
            }
        }
    }
    
    public static void decreaseSalary(ArrayList<Worker> WorkerList){
        Scanner sc = new Scanner(System.in);

        System.out.println("------- Up/Down Salary -------");

        //Get ID
        int id;
        //loop to get user input's ID and checks if it exists
        do {
            id = input.getNumber(sc, "Enter Code: ", 1, Integer.MAX_VALUE);

            if (checkIdExisting(id, WorkerList)) {
                System.out.println(" > Worker ID found!");
                break;
            } else {
                System.out.println(" > Worker ID not found! Try again.");
            }

        } while (true);

        //Get Salary Input
        int salaryIncrease = input.getNumber(sc, "Enter Salary: ", 0, Integer.MAX_VALUE);

        //loop to find correct worker
        for (Worker worker : WorkerList) {
            //comparing id with each existing id elements - but this time perform math operations
            if (worker.getId() == id) {
                //subtract inputted salary from current worker's salary
                worker.setSalary(worker.getSalary() - salaryIncrease);
                System.out.println(" > Salary subtracted :(");
                break;
            }
        }
        
    }
    
    public static void displayAll(ArrayList<Worker> WorkerList){
        System.out.println("---------------------Display Information Salary--------------------");
        System.out.println("Code\tName\t\tAge\t\tSalary\t\tStatus\t\tDate");
        
        //loop accessing each worker element in arraylist
        for (int i = 0; i < WorkerList.size(); i++) {
            Worker worker = WorkerList.get(i);
            
            //for each worker, prints out the data in correct format
            System.out.println("W " + worker.getId() + "\t" + worker.getName() + "\t\t" + worker.getAge() + "\t\t" + worker.getSalary() );
        }
        
    }
}
