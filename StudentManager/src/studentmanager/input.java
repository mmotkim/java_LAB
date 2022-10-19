package studentmanager;

import java.util.Scanner;

public class input {

    public static int getNumber(String prompt, int min, int max) {
        // Declare variables and create objects
        Scanner sc = new Scanner(System.in);
        String input;
        double number;

        // User Input Loop for checking appropriate input format
        do {
            System.out.println(prompt);
            input = sc.nextLine();

            // checks if user input is empty
            if (input.isEmpty()) {
                System.out.println("Input can't be empty!");
                continue;
            }

            try {
                number = Double.parseDouble(input);

                // Checks if number input is within accepted range
                if (number < min || number > max) {
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
            System.out.println(prompt);
            input = sc.nextLine();

            // checks if user input is empty
            if (input.isEmpty()) {
                System.out.println("Inputted string can't be empty!");
                continue;
            }

            break;
        } while (true);

        return input;
    }

    public static String getDoubleChoice(String prompt, String firstChoice, String secondChoice) {
        // Create objects and declare variables
        Scanner sc = new Scanner(System.in);
        String input;

        // User Input Loop for checking appropriate input format.
        do {
            System.out.println(prompt);
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
                System.out.println("Inputted choice isn't appropriate");
            }

        } while (true);

        return input;

        // 1 duc java
        // 1 duc .net
        // 2 nam
    }

    public static String getCourse(){
        String courseName = null;
        // User inputs course name
        // note: choose course from an existing list
        int courseNumber = input.getNumber("Input course number to update (1 - Java ; 2 - .Net ; 3 - C/C++): ", 1, 3);

        // initialize courseName from courseNumber input
        switch (courseNumber) {
            case 1:
                courseName = "Java";
                break;
            case 2:
                courseName = ".Net";
                break;
            case 3:
                courseName = "C/C++";
                break;
            default:
                break;
        }

        return courseName;
    }
}
