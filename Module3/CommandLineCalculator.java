package Module3;

/*
Challenge 1: Command-Line Calculator
------------------------------------
- Accept two numbers and an operator as command-line arguments
- Supports addition (+) and subtraction (-)
- Allow integer and floating-point numbers
- Ensures correct decimal places in output based on input (e.g., 0.1 + 0.2 → 1 decimal place)
- Display an error for invalid inputs or unsupported operators
- Capture 5 variations of tests
*/

// ctr26 06/12/2025

// Step 1: Take the string array args and split it by each space
// Step 2: Use a switch for the second value in the newly split array to determine which operation to perform
// Step 3: Throw exception if the new array has less than 3 values
// Step 4: Convert the numbers from strings to their respective type using type casting
// Step 5: Throw exception if the number are not able to properly convert
// Step 6: Perform the operation and assign the result to new sum variable
// Step 7: Calculate how many decimal places the original inputs have and format the sum using that value

public class CommandLineCalculator extends BaseClass {
    private static String ucid = "ctr26"; // <-- change to your ucid

    public static void main(String[] args) {
        printHeader(ucid, 1, "Objective: Implement a calculator using command-line arguments.");

        if (args.length != 3) {
            System.out.println("Usage: java M3.CommandLineCalculator <num1> <operator> <num2>");
            printFooter(ucid, 1);
            return;
        }

        try {
            System.out.println("Calculating result...");
            // extract the equation (format is <num1> <operator> <num2>)

            // check if operator is addition or subtraction

            // check the type of each number and choose appropriate parsing

            // generate the equation result (Important: ensure decimals display as the
            // longest decimal passed)
            // i.e., 0.1 + 0.2 would show as one decimal place (0.3), 0.11 + 0.2 would shows
            // as two (0.31), etc

        } catch (Exception e) {
            System.out.println("Invalid input. Please ensure correct format and valid numbers.");
        }

        printFooter(ucid, 1);
    }
}