/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datecompare;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Mmotkim
 */
public class DateCompare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //1. User input first date
        LocalDate date1 = getDate("Please enter the first date: ");
        //2. User input second date
        LocalDate date2 = getDate("Please enter the second date: ");
        //3. Compare the dates and print the result
        compareDates(date1, date2);
        
    }

    private static void compareDates(LocalDate date1, LocalDate date2) {
        if(date1.compareTo(date2) > 0){
            System.out.println("\nDate1 is after Date2");
        } else if (date1.compareTo(date2) < 0){
            System.out.println("\nDate1 is before Date 2");
        } else System.out.println("\nFirst Date is the same as second date.");
    }

    private static LocalDate getDate(String prompt) {
        Scanner sc = new Scanner(System.in);
        String input;
        DateTimeFormatter VNTime = DateTimeFormatter.ofPattern(("dd/MM/yyyy"));
        LocalDate date = null;

        //date input loop
        do{
            System.out.print(prompt);            
            input = sc.nextLine();
            
            // checks if user input is empty
            if (input.isEmpty()) {
                System.out.println("Inputted string can't be empty!\n");
                continue;
            }
            
            try{
                date = LocalDate.parse(input, VNTime);

            } catch (DateTimeParseException parseEx){
                System.out.println("Wrong date format! please enter format as day/month/year!\n");
                continue;
            }
            
            break;
        }while(true);
        
        return date;
    }
    
}
