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

    public static void createStudent(ArrayList<Student> studentList) {
        //Declare variables and objects
        Scanner sc = new Scanner(System.in);

        //note: ID CAN BE DUPLICATED
        
        
        //Student schedule addition Loop
        do{
        //Loop checking NUMBER of students has exceed 10 (count for unique IDs)
        for(Student student : StudentList){
            if student.getStuID()
        }

        //User inputs ID
        int stuID = input.getNumber(sc, "Input Student ID: ", 1, Integer.MAX_VALUE);

        //User inputs student name
        String stuName = input.getString(sc, "Input Student Name: ");
        
        //User inputs semester
        int semester = input.getNumber(sc, "Input Semester: ", 1, Integer.MAX_VALUE);

        //User inputs course name
        String courseName = input.getString(sc, "Input Course Name: ")

        //Create a Student object and append all the inputs then add it to the arraylist
        Student student = new Student(stuID, stuName, semester, courseName);
        studentList.add(student);

        } while(true);




    }

    public static void FindAndSort(ArrayList<Student> studentList) {
    }

    public static void UpdateOrDelete(ArrayList<Student> studentList) {
    }

    public static void displayAll(ArrayList<Student> studentList) {
    }

}
