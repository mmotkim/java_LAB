/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrixcalculator;

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
                if (number < 0 || number > max) {
                    throw new Exception();
                }

                // Chefcks if number input is rational
                if ((int) number != number) {
                    throw new Error();
                }

            } catch (NumberFormatException ex) { // checks if user inputted a string
                System.out.println("Value of matrix is digit ");
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
    
    public static int[][] inputMatrix(int matrixNumber){
        //User inputs Matrix Row and Column
        int row = getNumber("Enter Row Matrix 1:",1,Integer.MAX_VALUE);
        int col = getNumber("Enter Column Matrix 1:",1,Integer.MAX_VALUE);
        
        //Create matrix as using multi-dimensional array using the properties inputted
        int[][] matrix = new int[row][col];
        
        //Double Loop for inputting matrix values, accessing all columns for each rows
        for(int r = 0; r < row; r++){//For rows
            
            for (int c = 0; c < col; c++){//For columns
                
                //User inputs exact value of the matrix
                matrix[r][c] = getNumber("Enter Matrix" + matrixNumber + "["+r+"]" + "["+c+"]:",0,Integer.MAX_VALUE); 
                
            }
        }
        
        return matrix;
    }
}
