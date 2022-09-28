/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workermanager;

import java.util.Scanner;

/**
 *
 * @author Mmotkim
 */
public class input {
    public static int getNumber(Scanner sc, String prompt, int min, int max){
        //Declare variables and create objects
        String input;
        double number;
        
        do{
            System.out.print(prompt);
            input = sc.nextLine();
            
            //checks if user Input is empty
            if (input.isEmpty()){
                System.out.println("\nInput can't be empty! " + prompt);
                continue;
            }
            
            try{
                number = Double.parseDouble(input);
                
                if (number < min || number > max){
                    throw new Exception();
                    
                }
                
                if ((int)number != number){
                    throw new Error();
                    
                } 
                
            } catch (NumberFormatException ex){
                System.out.println("Input can't be a string! " + prompt);
                continue;
                
            } catch (Exception OutOfRange){
                System.out.println("Input must be in range! " + prompt);
                continue;
                
            } catch (Error Irrational){
                System.out.println("Input must be rational! " + prompt);
                continue;
                
            } break;  
        } while (true);
        
        return (int)number;
    }
    
    public static String getString(Scanner sc, String prompt, boolean excludeNumber){
        //Create objects and declare variables
        String input;
        
        
        //User input loop, checks for validity of input
        do {
            System.out.print(prompt);
            input = sc.nextLine();

            //Checks if user input is empty
            if (input.isEmpty()) {
                System.out.println("\nInput can't be empty! ");
            } else {

                //Checks if string contains number
                if (excludeNumber = false){
                    break;
                } else {
                    //converts input string to character array
                    char[] chars = input.toCharArray();
                    //Loop acceessing each character and check if there's a number
                    for (char c : chars) {
                        if (Character.isDigit(c)) {
                            System.out.print("Input must not contain number! \n");
                        } 
                    } continue;
                    
                } 
            } break;
        } while (true);
        return input;
    } 
    
}
    
