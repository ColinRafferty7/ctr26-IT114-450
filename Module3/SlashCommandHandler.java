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

        wl: while (true) {
            System.out.print("Enter command: ");
            String[] cmd = scanner.nextLine().split(" ");  

            try 
            {
                switch (cmd[0].toLowerCase())
                {
                    case "/greet":
                    {
                        if (cmd.length == 2)
                        {
                            System.out.println(cmd[1]);
                        }
                        else 
                        {
                            throw new Exception();
                        }
                        break;
                    }
                    case "/roll":
                    {
                        if (cmd.length == 2)
                        {
                            int num = Integer.parseInt(cmd[1].substring(0, cmd[1].indexOf("d")));
                            int sides = Integer.parseInt(cmd[1].substring(cmd[1].indexOf("d") + 1, cmd[1].length()));
                            int sum = 0;

                            for (int i = 0; i < num; i++)
                            {
                                sum += (int) (Math.random() * sides) + 1;
                            }
                            
                            System.out.println("Rolled " + num + "d" + sides + " and got " + sum + "!");
                        }
                        else
                        {
                            throw new Exception();
                        }
                        break;
                    }
                    case "/echo":
                    {
                        for (int i = 1; i < cmd.length; i++)
                        {
                            System.out.print(cmd[i] + " ");
                        }
                        System.out.println();
                        break;
                    }
                    case "/quit":
                    {
                        System.out.println("Exiting program...");
                        break wl;
                    }
                    default:
                    {
                        System.out.println("Invalid command.");
                        break;
                    }
                }   
            } 
            catch (Exception e)
            {
                System.out.println("Invalid command format.");
            }
        }

        printFooter(ucid, 2);
        scanner.close();
    }
}