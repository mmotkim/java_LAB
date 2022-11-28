/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mmotkim
 */
class Management {

    static void displayMenu() {
        System.out.println("========= Task program ==========");
        System.out.println("\t1. Add task");
        System.out.println("\t2. Delete task");
        System.out.println("\t3. Display task");
        System.out.println("\t4. Exit");

    }

    static int addTask(File taskListFile, int id) throws FileNotFoundException, IOException {
        ArrayList<Task> taskList = getTaskList(taskListFile);

        int taskType = 0;

        do {
            System.out.println("------------Add Task---------------");
            //declare id appropriately.
            String name = input.getString("Input task name: ");

            displayTaskTypes();
            taskType = input.getNumber("Choose a task type: ", 0, 5);

            String date = input.getDate("Input task date (day/month/year) :", true);

            Double planFrom = input.getDouble("From: ", 8, 17.5);
            Double planTo = input.getDouble("To: ", planFrom, 17.5);

            String assignee = input.getString("Assignee: ");
            String reviewer = input.getString("Reviewer: ");

            //create a task object then check for collision
            Task task = new Task(id, taskType, name, date, planFrom, planTo, assignee, reviewer);
            
            if (checkCollision(taskListFile, task)) {
                System.out.println("Assignee busy with another task! Input again.");
                continue;
            } else {
                taskList.add(task);
                id++;
            }

            break;
        } while (true);
        
        writeToFile(taskListFile, taskList);
        return id;
    }

    static boolean checkCollision(File taskListFile, Task task1) throws FileNotFoundException {
        ArrayList<Task> taskList = getTaskList(taskListFile);

        for (Task task2 : taskList) {
            //check for duplication of task date and assignee
            if (task1.getDate().equals(task2.getDate())
                    && task1.getAssignee().equals(task2.getAssignee())) {
                
                //if task time collide, both end times would be more than the other's start time
                if (task1.getPlanTo() - task2.getPlanFrom() > 0
                        && task2.getPlanTo() - task1.getPlanFrom() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkIdDuplicate(ArrayList<Task> taskList, int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    static int getLastID(File taskListFile) throws FileNotFoundException{
        ArrayList<Task> taskList = getTaskList(taskListFile);
        if(taskList.isEmpty()){
            return 1;
        }
        
        return taskList.get(taskList.size() - 1).getId() + 1;
    }

    static void displayTaskTypes() {
        System.out.println("ID  |  Name");
        System.out.println("1   |  Code");
        System.out.println("2   |  Test");
        System.out.println("3   |  Design");
        System.out.println("4   |  Review");
    }

    static void deleteTask(File taskListFile) throws FileNotFoundException, IOException {
        ArrayList<Task> taskList = getTaskList(taskListFile);
        System.out.println("---------Del Task---------");
        //check if list is empty
        if(taskList.isEmpty()){
            System.out.println("No task to delete..");
            return;
        }

        //check if id exists
        int id = input.getNumber("Input ID of task to delete: ", 0, Integer.MAX_VALUE);
        while (!checkIdDuplicate(taskList, id)) {
            System.out.println("ID not found! try again");
            id = input.getNumber("Input ID of task to delete: ", 0, Integer.MAX_VALUE);
        }

        //for-int loop to avoid exception when deleting
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.getId() == id) { //finding the correct task based on id
                taskList.remove(i);
                break;
            }
        }

        writeToFile(taskListFile, taskList);
    }

    static void displayTask(File taskListFile) throws FileNotFoundException {
        ArrayList<Task> taskList = getTaskList(taskListFile);
        
        //check if list is empty
        if(taskList.isEmpty()){
            System.out.println("No task to display..");
            return;
        }

        System.out.println("----------------------------------------- Task ---------------------------------------");
        System.out.println("ID\tName\tTask type\tDate\t\tTime\tAssignee\tReviewer");
        for (Task task : taskList) {
            System.out.println(task.getId() + "\t" + task.getName()
                    + "\t" + task.getTaskTypeName(task.getType()) + "\t\t" + task.getDate()
                    + "\t" + (task.getPlanTo() - task.getPlanFrom())
                    + "\t" + task.getAssignee() + "\t\t" + task.getReviewer());
        }

    }

    static File checkFile(String fileName) throws IOException {
        File taskListFile = new File(fileName);

        //checks if file already exists
        if (taskListFile.createNewFile()) {
            System.out.println("File doesn't exist, creating anew..");
        }
        return taskListFile;
    }

    public static ArrayList<Task> getTaskList(File taskListFile) throws FileNotFoundException {
        ArrayList<Task> taskList = new ArrayList<>();
        Scanner sc = new Scanner(taskListFile);

        //Scan each line on inputted file
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] taskString = line.split(",");
//            int id = Integer.parseInt(sc.next());
//            int type = Integer.parseInt(sc.next());
//            String name = sc.next();
//            String date = sc.next();
//            double planFrom = Double.parseDouble(sc.next());
//            double planTo = Double.parseDouble(sc.next());
//            String assignee = sc.next();
//            String reviewer = sc.next();

            //create a new task object then add it to list
//            Task task = new Task(id, type, name, date, planFrom, planTo, assignee, reviewer);
            Task task = new Task(Integer.parseInt(taskString[0]), Integer.parseInt(taskString[1]),
                    taskString[2], taskString[3], Double.parseDouble(taskString[4]),
                    Double.parseDouble(taskString[5]), taskString[6], taskString[7]);
            taskList.add(task);
        }

        return taskList;
    }

    public static void writeToFile(File taskListFile, ArrayList<Task> taskList) throws IOException {
        FileWriter writer = new FileWriter(taskListFile);

        for (Task task : taskList) {
            writer.write(task.toString() + System.lineSeparator()); //\n
        }
        writer.close();

    }
}
