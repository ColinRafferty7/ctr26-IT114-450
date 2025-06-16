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

        double sum = 0.0;

        try {
            System.out.println("Calculating result...");
            // extract the equation (format is <num1> <operator> <num2>)

            // check if operator is addition or subtraction

            // check the type of each number and choose appropriate parsing

            // generate the equation result (Important: ensure decimals display as the
            // longest decimal passed)
            // i.e., 0.1 + 0.2 would show as one decimal place (0.3), 0.11 + 0.2 would shows
            // as two (0.31), etc

            double val1 = Double.parseDouble(args[0]);
            double val2 = Double.parseDouble(args[2]);

            switch (args[1]) 
            {
                case ("+"):
                {
                    sum = val1 + val2;
                    break;
                }
                case ("-"):
                {
                    sum = val1 - val2;
                    break;
                }
                default:
                {
                    System.out.println("Operator not supported");
                    throw new Exception();
                }
            };

        } catch (Exception e) {
            System.out.println("Invalid input. Please ensure correct format and valid numbers.");
        }

        int dec = 0;

        String sumStr = "";

        if (args[0].indexOf(".") > -1 || args[2].indexOf(".") > -1)
        {
            dec = args[0].length() - args[0].indexOf(".");
            if (args[2].length() - args[2].indexOf(".") > dec)
            {
                dec = args[2].length() - args[2].indexOf(".");
            }
            sumStr = String.format("%." + (dec - 1) + "f", sum);
            System.out.println("The sum is: " + sumStr);
        }
        else
        {
            System.out.println("The sum is: " + (int) sum);
        }

        printFooter(ucid, 1);
    }
}