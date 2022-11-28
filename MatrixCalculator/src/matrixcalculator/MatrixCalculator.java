/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matrixcalculator;

/**
 *
 * @author Mmotkim
 */
public class MatrixCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declare variables
        int choice;
        //Navigational Code
        do{
            //1.Display menu
            display.displayMenu();
            //2.User input calculate choice
            choice = input.getNumber("Your choice: ",1,4);
            //3.User input matrixes
            int[][] matrix1 = input.inputMatrix(1);
            int[][] matrix2 = input.inputMatrix(2);
            //4.Calculator ultilities choice loop
                switch(choice){
                    case 1: 
                        //Addition Matrix
                        additionMatrix(matrix1, matrix2);
                        break;
                    case 2:
                        //Subtraction Matrix
                        subtractionMatrix(matrix1, matrix2);
                        break;
                    case 3:
                        //Multiplication Matrix
                        multiplicationMatrix(matrix1, matrix2);
                        break;
                }
        } while (choice < 4);
    }
    
    public static void additionMatrix(int[][] matrix1, int[][]matrix2){
        
        //Prints out calculation properties
        display.displayOne(matrix1);
        System.out.print("+\n");
        display.displayOne(matrix2);
        System.out.print("=\n");
        
        int rowLength = matrix1.length;
        int colLength = matrix1[0].length;
        int sum[][] = new int[rowLength][colLength];
        
        //Double loop to add matrix, access every value 
        for(int r=0; r < rowLength; r++){//Access rows
            
            for(int c=0; c < colLength; c++){//Access columns
                
                sum[r][c] = matrix1[r][c] + matrix2[r][c]; //Perform addition on each matrix value at their precise positions accordingly
            }
        }
        
        //Display result of the addition
        System.out.println("-------- Result --------");
        display.displayOne(sum);
    }
    
    public static void subtractionMatrix(int[][] matrix1, int[][]matrix2){
        System.out.println("-------- Subtraction --------");
        
        //Prints out calculation properties
        display.displayOne(matrix1);
        System.out.print("-\n");
        display.displayOne(matrix2);
        System.out.print("=\n");
        
        //Declare necessary variables
        int rowLength = matrix1.length;
        int colLength = matrix1[0].length;
        int sum[][] = new int[rowLength][colLength];
        
        //Double loop to add matrix, access every value 
        for(int r=0; r < rowLength; r++){//Access rows
            
            for(int c=0; c < colLength; c++){//Access columns
                
                sum[r][c] = matrix1[r][c] - matrix2[r][c]; //Perform subtraction on each matrix value at their precise positions accordingly
            }
        }
        
        //Display result of the subtraction
        System.out.println("-------- Result --------");
        display.displayOne(sum);
    }
    
    public static void multiplicationMatrix(int[][] matrix1, int[][]matrix2){
        
        
        //Prints out calculation properties
        display.displayOne(matrix1);
        System.out.print("-\n");
        display.displayOne(matrix2);
        System.out.print("=\n");
        
        //Declare necessary variables
        int rowLength = matrix1.length;
        int colLength = matrix1[0].length;
        int sum[][] = new int[rowLength][colLength];
        
        //Double loop to add matrix, access every value 
        for(int r=0; r < rowLength; r++){//Access rows
            
            for(int c=0; c < colLength; c++){//Access columns
                
                sum[r][c] = matrix1[r][c] - matrix2[r][c]; //Perform subtraction on each matrix value at their precise positions accordingly
            }
        }
        
        //Display result of the subtraction
        System.out.println("-------- Result --------");
        display.displayOne(sum);
    }
    
    
    
    
    
}
