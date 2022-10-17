package studentmanager;

import java.util.ArrayList;
import java.util.Collections;

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
        // Declare variables and objects
        String stuName = null;
        String courseName = null;

        // note: ID CAN BE DUPLICATED

        // Student schedule addition Loop
        do {

            // Loop checking NUMBER of students exceeding 10 (count for unique IDs)
            int count = 1;
            for (Student student : studentList) { // Tranverse over the studentList
                // Creates another loop/list to compare the students' IDs
                for (Student uniqueIDs : studentList) {
                    // Checks if stuIDs from the first loop is different from elements throughout
                    // the duplicated ones,
                    if (student.getStuID() != uniqueIDs.getStuID()) {
                        count++;
                    }
                }
                break;
            }

            if (count >= 2) {
                String choice = input.getDoubleChoice("Do you want to continue (Y/N)?", "Y", "N");

                if (!choice.equals("Y")) {
                    break;
                }
            }

            // User inputs ID. If ID exists, SKIP student name input
            int stuID = input.getNumber("Input Student ID: ", 1, Integer.MAX_VALUE);

            // Checks if inputted ID is unique.
            if (!checkIDExisting(stuID, studentList)) {

                // User inputs student name
                stuName = input.getString("Input Student Name: ");

                // Add the existing student info to student input
            } else {
                for (Student student : studentList) {
                    if (checkIDExisting(stuID, studentList)) {
                        stuName = student.getName();
                        break;
                    }
                    break;
                } // Tranverses the studenList again and copy the student info with the same ID to
                  // the current student input
            }

            // User inputs semester
            int semester = input.getNumber("Input Semester: ", 1, Integer.MAX_VALUE);

            // User inputs course name
            // note: choose course from an existing list
            int courseNumber = input.getNumber("Input course number (1 - Java ; 2 - .Net ; 3 - C/C++): ", 1, 3);

            // initialize courseName from courseNumber input
            switch (courseNumber) {
                case 1:
                    courseName = "Java";
                    break;
                case 2:
                    courseName = ".Net";
                    break;
                case 3:
                    courseName = "C/C++";
                    break;
                default:
                    break;
            }

            // Create a Student object and append all the inputs then add it to the
            // arraylist
            Student student = new Student(stuID, stuName, semester, courseName);
            studentList.add(student);

            System.out.println(" > Student added :) \n");
        } while (true);
    }

    public static void FindAndSort(ArrayList<Student> studentList) {
        // Declare objects and variables

        // Student Schedule Search & Sort Loop
        do {
            String searchInput = input.getString("Input student name to search: ");

            // Creates temporary student list to store the found info
            ArrayList<Student> foundStudentList = new ArrayList<>();

            // tranverses the studentList
            for (Student student : studentList) {

                // checks if student name contains search input
                if (student.getName().contains(searchInput)) {
                    // Add the newly accessed info to the arraylist studentInfo
                    foundStudentList.add(student);

                }
            }

            // checks if the search found any proper students
            if (foundStudentList.isEmpty()) {
                System.out.println(" > Student not found! try again.");
                break;
            }

            Collections.sort(foundStudentList);

            // when all is searched, prints out the temporary arraylist studentInfo
            System.out.println("Name\t\tSemester\t\tCourse Name");

            for (Student student : foundStudentList) {
                student.displayOne();
                System.out.println();
            }

            break;
        } while (true);
    }

    public static void UpdateOrDelete(ArrayList<Student> studentList) {
        // Declare variables and create objects

        // Student Search by ID Loop
        do {
            int searchID = input.getNumber("Input ID of student to update: ", 0, Integer.MAX_VALUE);

            // check if inputted ID doesn't exists
            if (!checkIDExisting(searchID, studentList)) {
                System.out.println(" > Student not found! try again.");
            }

            // If inputted student ID exists:
            else { // CASE 1: Multiple schedules from a student

                // Creates temporary student list to store the found info
                ArrayList<Student> foundStudentList = new ArrayList<>();

                // tranverses the studentList
                for (Student student : studentList) {

                    // check if inputted ID exists
                    if (student.getStuID() == searchID) {
                        // Add the newly accessed info to the arraylist studentInfo
                        foundStudentList.add(student);
                    }
                }

                // Print out the whole schedule of that student and let user choose which to
                // operate on
                System.out.println(" > Here's the schedule of student ID " + searchID + ": ");
                System.out.println("Name\t\tSemester\t\tCourseName");

                for (Student student : foundStudentList) { // tranverse the temporary student list
                    student.displayOne();
                    System.out.print("\t\t" + foundStudentList.indexOf(student) + "\n");
                }

                // Get user input on choosing schedule
                int scheduleInput = input.getNumber("Choose one schedule to perform operations on: ", 0, foundStudentList.size());
                // Get user input on choosing operation
                String doubleChoice = input.getDoubleChoice("Update / Delete (type U or D)", "U", "D");

                // UPDATE CASE
                if (doubleChoice.equals("U")) {
                    
                    Student studentUpdate = studentList.get(scheduleInput); // <---- exact schedule of student
                    int updateChoice;
                    
                    // Student Update loop
                    do {
                        System.out.println("1. Student ID ; 2. Student Name ; 3. Schedule Semester ; 4. Schedule Course Name ; 5. Done");
                        updateChoice = input.getNumber("Please choose an element to update: ", 1, 5);

                        switch (updateChoice) {
                            case 1:// Change student ID (note: Change all instances of schedule)
                                updateID(studentList, searchID);
                                break;
                            case 2:
                                updateName(studentList, searchID);
                                break;
                            case 3:
                                updateSemester(studentUpdate, studentList);
                                break;
                            case 4:
                                updateCourse(studentUpdate, studentList);
                                break;
                        }
                    } while (updateChoice < 5);
                }

                // DELETE CASE
                else if (doubleChoice.equals("D")) {
                    Student studentDelete = studentList.get(scheduleInput);
                }
                
                break;
            } 
        } while (true);
    }

    public static void displayAll(ArrayList<Student> studentList) {
    }

    // Other utility sub functions
    public static boolean checkIDExisting(int stuID, ArrayList<Student> studentList) {
        // declare variable
        boolean isExist = false;

        // loop accessing elements of array one by one
        for (Student student : studentList) {
            // comparing id with each existing id elements - similar to linear search
            if (student.getStuID() == stuID) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    public static void updateID(ArrayList<Student> studentList, int searchID) {
        do {
            int IDUpdate = input.getNumber("Input new ID: ", 0, Integer.MAX_VALUE);

            // Checks if ID exists
            if (checkIDExisting(IDUpdate, studentList)) {
                System.out.println("ID duplicated!, try again!");
            } else {
                // Update new ID on all instances of schedule
                for (Student student : studentList) {// tranverse the original student list
                    if (student.getStuID() == searchID) {
                        student.setStuID(IDUpdate);
                    }
                }
                break;
            }

        } while (true);

    }

    private static void updateName(ArrayList<Student> studentList, int searchID) {
        do {
            String nameUpdate = input.getString("Input new name: ");

            // Update new name on all instances of schedule
            for (Student student : studentList) {// tranverse the original student list
                if (student.getStuID() == searchID) {
                    student.setName(nameUpdate);
                }
            }
            break;

        } while (true);
    }

    private static void updateCourse(Student studentUpdate, ArrayList<Student> studentList) {
        do {
            String courseNameUpdate = null;
            // User inputs course name
            // note: choose course from an existing list
            int courseNumber = input.getNumber("Input course number to update (1 - Java ; 2 - .Net ; 3 - C/C++): ", 1, 3);

            // initialize courseName from courseNumber input
            switch (courseNumber) {
                case 1:
                    courseNameUpdate = "Java";
                    break;
                case 2:
                    courseNameUpdate = ".Net";
                    break;
                case 3:
                    courseNameUpdate = "C/C++";
                    break;
                default:
                    break;
            }

            for (Student student : studentList){
                if (student.equals(studentUpdate)){
                    System.out.println(student);
                    System.out.println(studentUpdate);
                    student.setCourseName(courseNameUpdate);
                } break;
            }
            System.out.println(" > Course name updated! :)");
            break;
        } while(true);
    }

    private static void updateSemester(Student studentUpdate, ArrayList<Student> studentList) {
        do{
            //take semester integer from user input
            int semesterUpdate = input.getNumber("Input semester to update", 0, Integer.MAX_VALUE);

            for (Student student : studentList) {
                if (student.equals(studentUpdate)){
                    System.out.println(student);
                    System.out.println(studentUpdate);
                    student.setSemester(semesterUpdate);
                } break;
            }
            System.out.println(" > Semester updated! :)");
            break;
        } while(true);
    }

}