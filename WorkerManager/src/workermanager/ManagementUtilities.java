/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workermanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mmotkim
 */
public class ManagementUtilities {

    public static void displayMenu() {
        System.out.println("\n======== Worker Management ========");
        System.out.println("   1. Add Worker");
        System.out.println("   2. Up Salary");
        System.out.println("   3. Down Salary");
        System.out.println("   4. Display Information salary");
        System.out.println("   5. Exit");
    }

    

    public static void addWorker(File WorkerListFile) throws FileNotFoundException, IOException {
        //Create objects
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter VNTime = DateTimeFormatter.ofPattern("dd/MM/YYYY ");
        ArrayList<Worker> WorkerList = ManagementUtilities.getWorkerList(WorkerListFile);

        System.out.println("--------- Add Worker ----------");

        //Get ID
        int id;
        //loop to get user input's ID and checks if it's duplicated
        do {
            id = input.getNumber(sc, "Enter Code: ", 1, Integer.MAX_VALUE);

            if (checkIdExisting(id, WorkerListFile)) {
                System.out.println("Worker ID already exists!");
            } else {
                break;
            }

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

        writeToFile(WorkerListFile, worker.toString());

        System.out.println(" > Worker added!");
    }

    public static void writeToFile(File file, String string) throws IOException {
        FileWriter newFile = new FileWriter(file, true);
        newFile.write(string + "\n");
        newFile.flush();
        newFile.close();
    }

    public static void increaseSalary(File WorkerListFile, File SalaryHistory) throws FileNotFoundException, IOException {
        
        //Create objects
        ArrayList<Worker> WorkerList = ManagementUtilities.getWorkerList(WorkerListFile);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter VNTime = DateTimeFormatter.ofPattern("dd/MM/YYYY ");
        Scanner scFile = new Scanner(WorkerListFile);
        
        System.out.println("------- Up/Down Salary -------");
        //Get ID
        int id;
        //loop to get user input's ID and checks if it exists
        do {
            id = input.getNumber(sc, "Enter Code: ", 1, Integer.MAX_VALUE);

            if (checkIdExisting(id, WorkerListFile)) {
                System.out.println(" > Worker ID found!");
                break;
            } else {
                System.out.println(" > Worker ID not found! Try again.");
            }

        } while (true);

        //Get Salary Input
        int salaryIncrease = input.getNumber(sc, "Enter Salary: ", 0, Integer.MAX_VALUE);

        //tranverse the arraylist to find the exact worker
        for (Worker worker : WorkerList) {
            if (worker.getId() == id) {
                worker.setSalary(worker.getSalary() + salaryIncrease);
            }
        }

        SalaryHistory history = new SalaryHistory(id, "UP", LocalDate.now().format(VNTime));
        writeToFile(SalaryHistory, history.toString());
        System.out.println(" > Salary raised :)");

    }

    public static void decreaseSalary(File WorkerListFile, File SalaryHistory) throws FileNotFoundException, IOException {
        //Create objects
        ArrayList<Worker> WorkerList = ManagementUtilities.getWorkerList(WorkerListFile);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter VNTime = DateTimeFormatter.ofPattern("dd/MM/YYYY ");
        System.out.println("------- Up/Down Salary -------");
        Scanner scFile = new Scanner(WorkerListFile);

        //Get ID
        int id;
        //loop to get user input's ID and checks if it exists
        do {
            id = input.getNumber(sc, "Enter Code: ", 1, Integer.MAX_VALUE);

            if (checkIdExisting(id, WorkerListFile)) {
                System.out.println(" > Worker ID found!");
                break;
            } else {
                System.out.println(" > Worker ID not found! Try again.");
            }

        } while (true);

        //Get Salary Input
        int salaryIncrease = input.getNumber(sc, "Enter Salary: ", 0, Integer.MAX_VALUE);

        while (scFile.hasNext()) {
            String line = scFile.nextLine();
            String[] workerString = line.split("|");

            int newSalary = Integer.parseInt(workerString[2]);
        }

        //tranverse the arraylist to find the exact worker
        for (Worker worker : WorkerList) {
            if (worker.getId() == id) {
                worker.setSalary(worker.getSalary() + salaryIncrease);
            }
        }

        SalaryHistory history = new SalaryHistory(id, "UP", LocalDate.now().format(VNTime));
        writeToFile(SalaryHistory, history.toString());
        System.out.println(" > Salary subtracted :(");

    }

    public static void displayAll(File WorkerListFile, File salaryHistoryFile) throws FileNotFoundException, IOException {
        ArrayList<Worker> WorkerList = ManagementUtilities.getWorkerList(WorkerListFile);
        ArrayList<SalaryHistory> SalaryHistory = getSalaryHistory(salaryHistoryFile);
        System.out.println("---------------------Display Information Salary--------------------");
        System.out.println("Code\tName\t\tAge\t\tSalary\t\tStatus\t\tDate");

        //loop accessing each worker element in arraylist
        for (int i = 0; i < WorkerList.size(); i++) {
            Worker worker = WorkerList.get(i);
            for (SalaryHistory history : SalaryHistory) {
                if (history.getId() == worker.getId()) {
                    System.out.println("W " + worker.getId() + "\t" + worker.getName() + "\t\t" + worker.getAge() + "\t\t" + worker.getSalary() + "\t\t" + history.getStatus() + "\t\t" + history.getDate());
                }
            }

            //for each worker, prints out the data in correct format
        }

    }

    public static File checkFileExisting(String fileName) throws IOException {
        File WorkerListFile = new File(fileName);
        //checks if file already exists
        if (WorkerListFile.createNewFile()) {
            System.out.println("File doesn't exists!");
        }
        return WorkerListFile;
    }

    public static ArrayList<SalaryHistory> getSalaryHistory(File salaryHistoryFile) throws FileNotFoundException {

        Scanner sc = new Scanner(salaryHistoryFile);
        ArrayList<SalaryHistory> SalaryHistory = new ArrayList<>();
        String line;
        SalaryHistory history;
        String[] salaryString;

        //Scans each line on inputted file
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            salaryString = line.split("|");

            history = new SalaryHistory(Integer.parseInt(salaryString[0]), salaryString[1], salaryString[2]);
            SalaryHistory.add(history);
        }

        sc.close();
        return SalaryHistory;
    }

    public static ArrayList<Worker> getWorkerList(File workerListFile) throws FileNotFoundException, IOException {
        ArrayList<Worker> workerList = new ArrayList<>();
        String line;
        String[] workerString;
        //Scans each line on inputted file
//        while (sc.hasNext()) {
//            line = sc.nextLine();
//            workerString = line.split("|");
//
//            worker = new Worker(Integer.parseInt(workerString[0]), workerString[1], Integer.parseInt(workerString[2]), Integer.parseInt(workerString[3]), workerString[4]);
//            workerList.add(worker);
//        }
//        sc.close();

        BufferedReader br = new BufferedReader(new FileReader(workerListFile));
        while((line = br.readLine()) != null){
            workerString = line.split("|");
            
            Worker worker = new Worker(Integer.parseInt(workerString[0]), workerString[1], Integer.parseInt(workerString[2]), Integer.parseInt(workerString[3]), workerString[4]);
            workerList.add(worker);
        }
 
        return workerList;
    }

    private static boolean checkIdExisting(int id, File WorkerListFile) throws FileNotFoundException {
        //declare variable
        boolean isExist = false;
        Scanner sc = new Scanner(WorkerListFile);
        

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] workerString = line.split("|");

            if (id == Integer.parseInt(workerString[0])) {
                isExist = true;
            }
        }

        sc.close();

        return isExist;
    }
}
