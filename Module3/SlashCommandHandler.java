package Module3;

/*
Challenge 2: Simple Slash Command Handler
-----------------------------------------
- Accept user input as slash commands
  - "/greet <name>" → Prints "Hello, <name>!"
  - "/roll <num>d<sides>" → Roll <num> dice with <sides> and returns a single outcome as "Rolled <num>d<sides> and got <result>!"
  - "/echo <message>" → Prints the message back
  - "/quit" → Exits the program
- Commands are case-insensitive
- Print an error for unrecognized commands
- Print errors for invalid command formats (when applicable)
- Capture 3 variations of each command except "/quit"
*/

import java.util.Scanner;

public class SlashCommandHandler extends BaseClass {
    private static String ucid = "ctr26"; // <-- change to your UCID

    public static void main(String[] args) {
        printHeader(ucid, 2, "Objective: Implement a simple slash command parser.");

        Scanner scanner = new Scanner(System.in);

        // Can define any variables needed here

        // ctr26 06/15/2025

        // Step 1: Take user input using the scanner and split it by spaces
        // Step 2: Create a switch that checks the first index for each of the valid commands, otherwising outputting an error
        // Step 3: For /quit, use the break function to exit the while loop and end the program
        // Step 4: For /greet, output an error if there is not exactly 2 values in the array, "/greet" and "<name>"
        // Step 5: Output the greeting followed by the value for the name input
        // Step 6: For /roll, create a for loop that iterates the num rolls
        // Step 7: Generate a random int between 1 and num sides
        // Step 8: Add each integer to a sum value and print out the final message
        // Step 9: For /echo, repeat steps for /greet, but allow for more than 2 values
        // Step 10: Join each value after the /echo command and output it as a single string

        while (true) {
            System.out.print("Enter command: ");
            // get entered text

            // check if greet
            //// process greet

            // check if roll
            //// process roll
            //// handle invalid formats

            // check if echo
            //// process echo

            // check if quit
            //// process quit

            // handle invalid commnads

            // delete this condition/block, it's just here so the sample runs without edits
            if (1 == 1) {
                System.out.println("Breaking loop");
                break;
            }
        }

        printFooter(ucid, 2);
        scanner.close();
    }
}