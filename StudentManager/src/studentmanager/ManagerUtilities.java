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

        // note: ID CAN BE DUPLICATED

        // Student schedule addition Loop
        do {

            // Loop checking NUMBER of students exceeding 10 (counter for unique IDs)
            int count = 1;
            for (Student student : studentList) { // Tranverse over the studentList
                // Creates another loop & list to compare the students' IDs
                for (Student uniqueIDs : studentList) {
                    // Checks if stuIDs from the first loop is different from elements throughout the duplicated ones,
                    if (student.getStuID() != uniqueIDs.getStuID()) {
                        count++;
                    }
                }
                break;
            }
            
            if (count >= 3) {// <----- MAX number of students required before asking
                String choice = input.getDoubleChoice("Do you want to continue (Y/N)?", "Y", "N");

                if (!choice.equals("Y")) {
                    break;
                }
            }

            // User inputs ID. Note: If ID exists, SKIP student name input
            int stuID = input.getNumber("Input Student ID: ", 1, Integer.MAX_VALUE);

            // Checks if inputted ID is unique.
            if (!checkIDExisting(stuID, studentList)) {

                // User inputs student name
                stuName = input.getString("Input Student Name: ");

            // Add the existing student name to current student input
            } else {
                for (Student student : studentList) {
                    if (student.getStuID() == stuID) {
                        stuName = student.getName();
                        break;
                    }
                } // Tranverses the studenList again and copy the student info with the same ID to the current student input
            }

            // User inputs semester
            int semester = input.getNumber("Input Semester: ", 1, Integer.MAX_VALUE);

            String courseName = input.getCourse();

            // check if schedule is identical to any existing schedule
            if (!checkDuplicate(studentList, stuID, semester, courseName)) {

                // Create a Student object and append all the inputs then add it to the arraylist
                Student student = new Student(stuID, stuName, semester, courseName);
                studentList.add(student);

                System.out.println(" > Student added :) \n");
            } else {
                System.out.println("Student schedule already exists! Input again.");
            }
        } while (true);

    }

    public static void FindAndSort(ArrayList<Student> studentList) {

        // Student Schedule Search & Sort Loop
        do {
            if (studentList.isEmpty()) {
                System.out.println("No student to search for!");
                break;
            }
            
            String searchInput = input.getString("Input student name to search: ");

            // Creates temporary student list to store the found info
            ArrayList<Student> foundStudentList = new ArrayList<>();

            // tranverses the studentList
            for (Student student : studentList) {

                // checks if student name contains search input
                if (student.getName().toLowerCase().contains(searchInput.toLowerCase())) {
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
        do{
            if (studentList.isEmpty()){
                System.out.println("No student to update!");
                break;
            }

            int searchID = input.getNumber("Input ID of student to update/delete: ", 0, Integer.MAX_VALUE);

            // check if inputted ID doesn't exists
            if (!checkIDExisting(searchID, studentList)) {
                System.out.println("Student not found! try again.");
            }

            // If inputted student ID exists:
            else{

                // Get user input on choosing manage operation
                String doubleChoice = input.getDoubleChoice("Update / Delete (type U or D)", "U", "D");
                
                // UPDATE CASE
                if (doubleChoice.equals("U")){

                    int updateChoice;
                    //Student Update loop
                    do {
                        System.out.println("1. Student ID | 2. Student Name | 3. Schedule Semester | 4. Schedule Course Name | 5. Cancel");
                        updateChoice = input.getNumber("Please choose an element to update: ", 1, 5);

                        switch (updateChoice) {
                            case 1:// Change student ID (note: Change all instances of schedule)
                                updateID(searchID, studentList);
                                break;
                            case 2:// Change student name (note: change all instances of that student name)
                                updateName(searchID, studentList);
                                break;
                            case 3:// Change schedule's semester
                                updateSemester(searchID, studentList);
                                break;
                            case 4:// Change schedule's course name
                                updateCourse(searchID, studentList);
                                break;
                        }
                        break;
                    } while(true);
                }

                //DELETE CASE
                else if (doubleChoice.equals("D")){
                    deleteStudent(searchID, studentList);
                }
            }

            break;
        } while(true);
    }


    public static void displayAll(ArrayList<Student> studentList) {
        if(studentList.isEmpty()){
            System.out.println("No student to display!");
        } else {
            System.out.println("ID\t\tName\t\tSemester\t\tCourse Name");
            // tranverse the original student list and simply print out each student schedule
            for (Student student : studentList) {
                System.out.println(student.getStuID() + "\t\t" + student.getName() + "\t\t" + student.getSemester() + "\t\t\t" + student.getCourseName());
            }
        }
    }

    
    // Other utility sub functions
    public static boolean checkIDExisting(int stuID, ArrayList<Student> studentList) {
        // declare variable
        boolean isExist = false;

        // loop accessing elements of arraylist one by one
        for (Student student : studentList) {
            // comparing id with each existing id elements - similar to linear search
            if (student.getStuID() == stuID) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    public static void updateID(int searchID, ArrayList<Student> studentList) {
        int IDUpdate;
        
        boolean duplicate = false;

        //Find exact schedule to update
        Student scheduleToUpdate = getScheduleFromID(studentList, searchID);

        //Student schedule update Loop
        do {
            IDUpdate = input.getNumber("Input new ID: ", 1, Integer.MAX_VALUE);
            //tranverse the student list and access the all the student with ID searched
            for (Student student : studentList) {
                //access exact schedule to update on original list
                if (student.getStuID() == scheduleToUpdate.getStuID()
                    && student.getSemester() == scheduleToUpdate.getSemester()
                    && student.getCourseName().equals(scheduleToUpdate.getCourseName())) {
                        
                        //check for duplication with another schedule
                        if(checkDuplicate(studentList, IDUpdate, scheduleToUpdate.getSemester(), scheduleToUpdate.getCourseName())){
                            System.out.println("Duplicated! try again.");
                            duplicate = true;
                            break;
                        //check for duplication with another student
                        } else if(checkIDExisting(IDUpdate, studentList)){
                            //update that student name to the name of student with same ID
                            student.setName(getFirstStudentFromID(studentList, IDUpdate).getName());
                            //and update ID accordingly
                            student.setStuID(IDUpdate);
                            duplicate = false;
                            break;
                        } else {//case if inputted new ID is a new ID in studentList
                            student.setStuID(IDUpdate);
                            duplicate = false;
                            break;
                        } 
                }
            }
        
        } while (duplicate);
        System.out.println(" > Student updating complete");

    }

    private static void updateName(int searchID, ArrayList<Student> studentList) {
        do {
            String nameUpdate = input.getString("Input new name: ");

            // Update new name on all instances of schedule
            for(Student student : studentList){
                if (student.getStuID() == searchID){
                    student.setName(nameUpdate);
                }
            }
            System.out.println(" > Student name updated! :>\n");
            break;
        } while (true);
    }

    private static void updateCourse(int searchID, ArrayList<Student> studentList) {
        Student scheduleToUpdate = getScheduleFromID(studentList, searchID);

        do {
            String courseNameUpdate = input.getCourse();
            // tranverse the original list
            for (Student student : studentList) {
                // Finding exact student in original list by checking ID courseName and semester
                if (student.getStuID() == scheduleToUpdate.getStuID()
                        && student.getCourseName().equals(scheduleToUpdate.getCourseName())
                        && student.getSemester() == scheduleToUpdate.getSemester()) {

                    //checks if updated record would be identical with any existing record in student list
                    while (checkDuplicate(studentList, student.getStuID(), student.getSemester(), courseNameUpdate)) {
                        System.out.println("Update entry would duplicate with another schedule! Try again.");
                        courseNameUpdate = input.getCourse();

                        if (courseNameUpdate.equals(student.getCourseName())){//allowing user to exit when inputting the same course name of schedule (i.e unchanged schedule)
                            System.out.println("Same course name inputted, it will remain as is."); 
                            break;
                        }
                    }

                    // set individual schedule's course name
                    student.setCourseName(courseNameUpdate);
                    System.out.println(" > Course name updating done! :) \n");
                    break;
                }
            }
            break;
        } while (true);
    }

    private static void updateSemester(int searchID, ArrayList<Student> studentList) {
        Student scheduleToUpdate = getScheduleFromID(studentList, searchID);
        do {
            // take semester integer from user input
            int semesterUpdate = input.getNumber("Input semester to update", 0, Integer.MAX_VALUE);

            // tranverse the original list
            for (Student student : studentList) {
                // Finding exact student in original list by checking ID courseName and semester
                if (student.getStuID() == scheduleToUpdate.getStuID()
                        && student.getCourseName().equals(scheduleToUpdate.getCourseName())
                        && student.getSemester() == scheduleToUpdate.getSemester()) {

                    // checks if updated record would be identical with any existing record in student list
                    while(checkDuplicate(studentList, student.getStuID(), semesterUpdate, student.getCourseName())) {
                        System.out.println("Update entry would duplicate with another schedule! Try again.");
                        semesterUpdate = input.getNumber("Input semester to update", 0, Integer.MAX_VALUE);
                        
                        if(semesterUpdate == student.getSemester()){//allowing user to exit when inputting the same course name of schedule (i.e unchanged schedule)
                            System.out.println(" > Same course name inputted, it will remain as is."); 
                            break;
                        }  
                    }

                    // set individual schedule's semester
                    student.setSemester(semesterUpdate);
                    System.out.println(" > Course name updating done :) \n");
                    break;
                }
            }
            break;
        } while (true);
    }

    private static void deleteStudent(int searchID, ArrayList<Student> studentList) {
        String deleteType = input.getDoubleChoice("1. Delete Student | 2. Choose student's schedule and delete", "1", "2");

        //Delete Student Case
        if (deleteType.equals("1")){
            for (int i = 0; i < studentList.size(); i++) { // Using for-index loop to avoid ConcurrentModificationException
                Student student = studentList.get(i);
                // Finding exact student in original list by checking ID courseName and semester, then delete 
                if (student.getStuID() == searchID) {
                    studentList.remove(student);
                    break;
                }
            } 
        }

        //Delete schedule case
        else if (deleteType.equals("2")){
            //Get exact schedule from student
            Student scheduleToUpdate = getScheduleFromID(studentList, searchID);
        
            for (int i = 0; i < studentList.size(); i++) { // Using for-index loop to avoid ConcurrentModificationException
                Student student = studentList.get(i);
                // Finding exact student in original list by checking ID courseName and semester, then delete 
                if (student.getStuID() == scheduleToUpdate.getStuID()
                        && student.getCourseName().equals(scheduleToUpdate.getCourseName())
                        && student.getSemester() == scheduleToUpdate.getSemester()) {
                    studentList.remove(student);
                    break;
                }
            }
        }
        
        System.out.println(" > Student deleting complete! :> \n");
    }

    public static Student getScheduleFromID(ArrayList<Student> studentList, int searchID){
        // Creates temporary student list to store the found info
        ArrayList<Student> foundStudentList = new ArrayList<>();

        // tranverses the original list to add elements to that list
        for (Student student : studentList) {
            // check if inputted ID exists
            if (student.getStuID() == searchID) {
                // Add the newly accessed info to the arraylist studentInfo
                foundStudentList.add(student);
            }
        }

        // Print out the whole schedule of that student and let user choose which to operate on
        System.out.println(" > Here's the schedule of student ID " + searchID + ": ");
        System.out.println("Name\t\tSemester\t\tCourseName");
        for (Student student : foundStudentList) { // tranverse the temporary student list
            student.displayOne();
            System.out.print("\t\t" + (foundStudentList.indexOf(student)+1)  + "\n");
        }

        // Get user input on choosing schedule with index
        int scheduleInput = input.getNumber("Choose one schedule to perform operations on: ", 1, foundStudentList.size());
        Student scheduleToUpdate = foundStudentList.get(scheduleInput-1); // <---- exact schedule of student selected by user

        return scheduleToUpdate;
    }
    public static Student getFirstStudentFromID(ArrayList<Student> studentList, int searchID){
        //tranverse the original list
        for(Student student : studentList){
            //checks if student ID matches
            if (student.getStuID() == searchID){
                return student;
            }
        }
        return null;
        
    }
    public static boolean checkDuplicate(ArrayList<Student> studentList, int stuID, int semester, String courseName) {
        boolean isExist = false;
        // access each element in the list
        for (Student student : studentList) {
            // checks if inputted record has duplicates with any existing record in the list
            if (student.getStuID() == stuID
                    && student.getCourseName().equals(courseName)
                    && student.getSemester() == semester) {
                isExist = true;
            }
        }
        return isExist;
    }
    
    public static boolean checkDuplicate(ArrayList<Student> studentList, int stuID, String stuName) {
        boolean isExist = false;
        // access each element in the list
        for (Student student : studentList) {
            // checks if inputted record has duplicates with any existing record in the list
            if (student.getStuID() == stuID && student.getName().equals(stuName)){
                isExist = true;
            }
        }
        return isExist;
    }

    public static boolean checkDuplicate(ArrayList<Student> studentList, int stuID, String stuName, int semester, String courseName) {
        boolean isExist = false;
        // access each element in the list
        for (Student student : studentList) {
            // checks if inputted record has duplicates with any existing record in the list
            if (student.getStuID() == stuID
                    && student.getName().equals(stuName)
                    && student.getCourseName().equals(courseName)
                    && student.getSemester() == semester) {
                isExist = true;
            }
        }
        return isExist;
    }
}