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
public class getInput {
    public static int getUserChoice(Scanner sc){
        //Declare variables and create objects
        String input;
        double number;
        
        do{
            input = sc.nextLine();
            
            //checks if user Input is empty
            if (input.isEmpty()){
                System.out.println("Choice can't be empty");
                continue;
            }
            
            try{
                number = Double.parseDouble(input);
                
                if (number <= 0 || number > 5){
                    throw new Exception();
                    
                }
                
                if ((int)number != number){
                    throw new Error();
                    
                } 
                
            } catch (NumberFormatException ex){
                System.out.println("Choice can't be a string!");
                continue;
                
            } catch (Exception OutOfRange){
                System.out.println("Choice must be in range (1 -> 5)!");
                continue;
                
            } catch (Error Irrational){
                System.out.println("Choice must be rational!");
                continue;
                
            } break;  
        } while (true);
        
        return (int)number;
    }
}
