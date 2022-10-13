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
        System.out.print("\t5.  Exit");
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

            //Loop checking NUMBER of students exceeding 10 (count for unique IDs)
            int count = 1;
            for (Student student : studentList) { //Tranverse over the studentList
                //Creates another loop/list to compare the students' IDs
                for (Student uniqueIDs : studentList) {
                    //Checks if stuIDs from the first loop is different from elements throughout the duplicated ones, 
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

            //Add the existing student info to student input
            } else {
                for (Student student : studentList){
                    if (checkIDExisting(stuID, studentList)){
                        stuName = student.getName();
                        semester = student.getSemester();
                        break;
                    }
                    break;
                }//Tranverses the studenList again and copy the student info with the same ID to the current student input 
            }

            
            //User inputs course name
            //note: choose course from an existing list
            int courseNumber = input.getNumber(sc, "Input course number (1 - Java ; 2 - .Net ; 3 - C/C++): ", 1, 3);

            //initialize courseName from courseNumber input
            if (courseNumber == 1) courseName = "Java";
            else if (courseNumber == 2) courseName = ".Net";
            else if (courseNumber == 3) courseName = "C/C++";

            //Create a Student object and append all the inputs then add it to the arraylist
            Student student = new Student(stuID, stuName, semester, courseName);
            studentList.add(student);

            System.out.println(" > Student added :) \n");
        } while (true);
    }

    public static void FindAndSort(ArrayList<Student> studentList) {
        //Declare objects and variables
        Scanner sc = new Scanner(System.in);
        
        //Student Schedule Search Loop
        do{
            String searchInput = input.getString(sc, "Input student name to search: ");

            //Creates temporary student list to store the found info
            ArrayList<Student> studentInfoList = new ArrayList<Student>();

            //tranverses the studentList
            for (Student student : studentList) {
                
                //checks if student name contains search input
                if (student.getName().contains(searchInput)) {
                    //Add the newly accessed info to the arraylist studentInfo
                    studentInfoList.add(student);
                    continue;
                   
                }
            } 

            //checks if the search found any proper students
            if (studentInfoList.isEmpty()){
                System.out.println(" > Student not found! try again.");
                break;
            }

            //when all is searched, prints out the temporary arraylist studentInfo
            System.out.println("Name\t\tSemester\t\tCourse Name");

            for(Student studentInfo : studentInfoList){
                System.out.println(studentInfo.getName() + "\t\t" + studentInfo.getSemester() + "\t\t\t" + studentInfo.getCourseName());
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
