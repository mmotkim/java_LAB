/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package geometrycalculator;

import java.util.Scanner;

/**
 *
 * @author Mmotkim
 */
public class GeometryCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declare variables and create objects
        Scanner sc = new Scanner(System.in);
        
        //1. Input Rectangle properties
        Rectangle rectangle = input.getRectangle(sc);
        //2. Input Circle properties
        Circle circle = input.getCircle(sc);
        //3. Input Triangle properties
        Triangle triangle = input.getTriangle(sc);
        //4. Display required geometry computations
        display(rectangle, circle, triangle);
    }

    public static void display(Rectangle rectangle, Circle circle, Triangle triangle){
        System.out.println("-----Rectangle-----");
        rectangle.printResult();
        System.out.println("-----Circle-----");
        circle.printResult();
        System.out.println("-----Triangle-----");
        triangle.printResult();
    }
    
}
