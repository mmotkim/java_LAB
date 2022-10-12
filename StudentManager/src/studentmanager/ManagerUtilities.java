package studentmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerUtilities {

    public static void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t1.  Create");
        System.out.println("\t2.  Find and Sort");
        System.out.println("\t3.  Update/Delete");
        System.out.println("\t4.  Report");
        System.out.println("\t5.  Exit");
    }

    public static boolean checkIDExisting(int stuID, ArrayList<Student> studentList){
        //declare variable
        boolean isExist = false;
        
        //loop accessing elements of array one by one
        for (Student student : studentList) {
            //comparing id with each existing id elements - similar to linear search
            if (student.getStuID() == stuID) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }
    
    public static void createStudent(ArrayList<Student> studentList) {
        //Declare variables and objects
        Scanner sc = new Scanner(System.in);
        String stuName = null;
        int semester = -1;
        String courseName = null;

        //note: ID CAN BE DUPLICATED
        
        
        //Student schedule addition Loop
        do{
            //Loop checking NUMBER of students has exceed 10 (count for unique IDs)
            int count = 1;
            for (Student student : studentList) { //
                //Creates another
                for (Student uniqueIDs : studentList) {
                    //
                    if (student.getStuID() != uniqueIDs.getStuID()) {
                        count++;
                    }
                }
                break;
            }

            if (count >= 2) {
                String choice = input.getDoubleChoice(sc, "Do you want to continue (Y/N)?", "Y", "N");

                if (!choice.equals("Y")) {
                    break;
                }
            }

            //User inputs ID
            //note: if ID exists, SKIP student name and semester input
            int stuID = input.getNumber(sc, "Input Student ID: ", 1, Integer.MAX_VALUE);

            //Checks if inputted ID is unique. 
            if (!checkIDExisting(stuID, studentList)) {

                //User inputs student name
                stuName = input.getString(sc, "Input Student Name: ");

                //User inputs semester
                semester = input.getNumber(sc, "Input Semester: ", 1, Integer.MAX_VALUE);

            }



            //User inputs course name
            //note: choose course from an existing list
            int courseNumber = input.getNumber(sc, "Input course number (1 - Java ; 2 - .Net ; 3 - C/C++): ", 1, 3);

            //initialize courseName from courseNumber input
            switch (courseNumber) {
                case 1: {
                    courseName = "Java";
                }
                case 2: {
                    courseName = ".Net";
                }
                case 3: {
                    courseName = "C/C++";
                }
            }

            //Create a Student object and append all the inputs then add it to the arraylist
            Student student = new Student(stuID, stuName, semester, courseName);
            studentList.add(student);

        } while (true);
    }

    public static void FindAndSort(ArrayList<Student> studentList) {
        //Declare objects and variables
        Scanner sc = new Scanner(System.in);
        
        //Student Schedule Find & Sort Loop
        do{
            String searchInput = input.getString(sc, "Input student name to search: ");
            
            //tranverse the studentList
            for (Student student : studentList) {
                //checks if student name contains search input
                if (student.getName().contains(searchInput)) {
                    
                    //prints found student's info
                    System.out.println("Name \t\t Semester \t\t  Course Name");
                    System.out.println(student.getName() + "\t\t" + student.getSemester() + "\t\t" + student.getCourseName());
                    
                    
                } 
                
                System.out.println(" > Student not found! try again.. ");
            } 
            
            break;
        } while(true);
    }

    public static void UpdateOrDelete(ArrayList<Student> studentList) {
    }

    public static void displayAll(ArrayList<Student> studentList) {
    }

    //Other utility sub functions
    public static void displayOne(ArrayList<Student> studentList){
        Student student = new Student();
        
    }
}
