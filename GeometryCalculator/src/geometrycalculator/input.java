/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometrycalculator;

import java.util.Scanner;

/**
 *
 * @author Mmotkim
 */
public class input {
    public static Rectangle getRectangle(Scanner sc){

        //Get input rectangle properties
        double width = getNumber(sc, "Please input side width of Rectangle: ");
        double length = getNumber(sc, "Please input length of Rectangle: ");

        //create a rectangle object with inputted properties
        Rectangle rectangle = new Rectangle(width, length);

        return rectangle;
    }

    public static Circle getCircle(Scanner sc){

        //Get input circle properties
        double radius = getNumber(sc, "Please input radius of Circle:: ");

        //Create a circle object with inputted property
        Circle circle = new Circle(radius);

        return circle;
    }

    public static Triangle getTriangle(Scanner sc){
        //Triangle input loop
        do{
            //Get input triangle properties
            double sideA = getNumber(sc, "Please input side A of Triangle: ");
            double sideB = getNumber(sc, "Please input side B of Triangle: ");
            double sideC = getNumber(sc, "Please input side C of Triangle: ");
            
            //Check if triangle properties make a valid triangle
            if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA){
                System.out.println("Non-existent triangle! Try again.");
                continue;
            } 
            else {
                //Create a triangle object with inputted properties
                Triangle triangle = new Triangle(sideA, sideB, sideC);
                return triangle;
            }
   
        } while (true);
    }
    
    public static double getNumber(Scanner sc, String prompt){//Note: double, positive, not empty
        //Declare variables and create objects
        String input;
        double number;

        //User Input Loop
        do{
            System.out.println(prompt);
            input = sc.nextLine();

            //checks if user input is empty
            if (input.isEmpty()){
                System.out.println("Input can't be empty!");
                continue;
            }

            try {
                number = Double.parseDouble(input);

                //Check if number input is positive
                if(number <= 0){
                    throw new Exception();
                }

            } catch (NumberFormatException ex){//check if user inputted a string
                System.out.println("Input can't be a string!");
                continue;
            } catch (Exception notPositive){
                System.out.println("Input must be a positive number!");
                continue;
            }

            break;
        } while(true);
        
        return number;
    }
}
