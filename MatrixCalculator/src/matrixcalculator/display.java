/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrixcalculator;


/**
 *
 * @author Mmotkim
 */
class display {

    static void displayMenu() {
        System.out.println("=======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }
    
    static void displayOne(int[][] matrix){
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        
        //Double loop to access all columns for each row of matrix
        for (int r = 0; r < rowLength; r++) {//Access rows
            
            for(int c = 0; c < colLength; c++){//Access columns

                System.out.print("[" + matrix[r][c] + "]");
                
            }
            //Line break for each row
            System.out.println("");
        }
    }
    
    
    
}
