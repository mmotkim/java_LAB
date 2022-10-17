
LAB211 Assignment
Type:
Long Assignment
Code:
J1.L.P0021
LOC:
150
Slot(s):
5


Title 
  	Create a Java console program to manage students.
Background Context
Write a program to manage information of student. The program implements terminology of Object Oriented Programming (OOP) paradigm. OOP is one of the best choosing ways to design software program. 
In this assignment, we will use ArrayList to store list of student. In fact, ArrayList is popular used to manipulate with data. ArrayList provides some useful methods, such as: add(), remove(), sort() ., etc.


Program Specifications
A student information consists of ID, Student Name, Semester, Course Name (There are only three courses: Java, .Net, C/C++). The program allows use to create list of student, update/delete student information. On the other hand, use can search student(s) and sort result by student name

Main Screen as below:

WELCOME TO STUDENT MANAGEMENT
Create
Find and Sort
Update/Delete
Report
Exit
(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).
 Function details: 
There are 4 functions in Student Management Screen, as bellow:
Create: user creates student by inputting information from keyboard. User has to create at least 10 students, if number of students greater than 10, the program shows a message: Do you want to continue (Y/N)? Choose Y to continue, N to return main screen.
Find/Sort: Find and list student (by name) and sort by name, it should display: Student name, semester and Course Name. User inputs student name or a part of student name.
Update/Delete: The program allows user find a student by ID. After finding a student by Id, a question is displayed (Do you want to update (U) or delete (D) student. If user chooses U, the program allows user updating. Choose D for deleting student.
Report: write a function to display student(s) with total Courses of this student, as: Student name, Course and Total of Course, for example:



Student name    Course
Nguyen Van A    Java
Nguyen Van A    Java
Nguyen Van B    .Net
Nguyen Van B    Java


 The report as below:
Nguyen Van A | Java | 2
Nguyen Van B | Java | 1
Nguyen Van C | Java | 1

Technical Requirements
1. Using Object-Oriented programming style
2. Use only core Java functions and classes.

Guidelines

Slot            Task                  Description
1               Code Design           Create student: Student should create a Student class with attributes: id, studentName, semester and courseName
2               Find and sort student Should Collections.sort() and overwrite compare() method in Comparator interface
3               Update/Delete student
4               Report
5               Review program        Mentor reviews student’s program.


[J1.L.P0021.docx](https://github.com/mmotkim/java_LAB/files/9801010/J1.L.P0021.docx)
