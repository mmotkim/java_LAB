/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fruitshop;

import java.util.Scanner;

/**
 *
 * @author Mmotkim
 */
class input {

    public static int getNumber(String prompt, int min, int max) {
        // Declare variables and create objects
        Scanner sc = new Scanner(System.in);
        String input;
        double number;

        // User Input Loop for checking appropriate input format
        do {
            System.out.print(prompt);
            input = sc.nextLine();

            // checks if user input is empty
            if (input.isEmpty()) {
                System.out.println("Input can't be empty!");
                continue;
            }

            try {
                number = Double.parseDouble(input);

                // Checks if number input is within accepted range
                if (number <= min || number >= max) {
                    throw new Exception();

                }

                // Chefcks if number input is rational
                if ((int) number != number) {
                    throw new Error();

                }

            } catch (NumberFormatException ex) { // checks if user inputted a string
                System.out.println("Input can't be a string! ");
                continue;

            } catch (Exception OutOfRange) {
                System.out.println("Input must be in range!");
                continue;

            } catch (Error Irrational) {
                System.out.println("Input must be rational! ");
                continue;

            }
            break;
        } while (true);

        return (int) number;
    }
    
    public static String getString(String prompt) {
        // Create objects and declare variables
        Scanner sc = new Scanner(System.in);
        String input;

        // User Input Loop for checking appropriate input format.
        do {
            System.out.print(prompt);
            input = sc.nextLine();

            // checks if user input is empty
            if (input.isEmpty()) {
                System.out.println("Inputted string can't be empty!");
                continue;
            }
            
            //checks if user input contains number

            // ^ : marks beginning of string input
            // $ : marks the end of the string input
            // + : matches if contains at least one occurance of characters inside the brackets [ ]
            // [a-zA-Z ]: allowed letters consist of lowercase and uppercase alphabetical letters and space.
            if(input.matches("^[a-zA-Z ]+$")){
                return input;
            } else {
                System.out.println("Inputted string contains invalid characters!");
            }

        } while (true);

    }
    
    public static String getDoubleChoice(String prompt, String firstChoice, String secondChoice) {
        // Create objects and declare variables
        Scanner sc = new Scanner(System.in);
        String input;

        // User Input Loop for checking appropriate input format.
        do {
            System.out.print(prompt);
            input = sc.nextLine().toUpperCase();

            // checks if user input is empty
            if (input.isEmpty()) {
                System.out.println("Inputted choice can't be empty!");
                continue;
            }

            // checks if user inputted the appropriate format
            if (input.equals(firstChoice) || input.equals(secondChoice)) {
                break;
            } else {
                System.out.println("Inputted choice isn't appropriate!");
            }

        } while (true);

        return input;

    }
}
