package Module3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Challenge 3: Mad Libs Generator (Randomized Stories)
-----------------------------------------------------
- Load a **random** story from the "stories" folder
- Extract **each line** into a collection (i.e., ArrayList)
- Prompts user for each placeholder (i.e., <adjective>) 
    - Any word the user types is acceptable, no need to verify if it matches the placeholder type
    - Any placeholder with underscores should display with spaces instead
- Replace placeholders with user input (assign back to original slot in collection)
*/

public class MadLibsGenerator extends BaseClass {
    private static final String STORIES_FOLDER = "Module3/stories";
    private static String ucid = "ctr26"; // <-- change to your ucid

    public static void main(String[] args) {
        printHeader(ucid, 3,
                "Objective: Implement a Mad Libs generator that replaces placeholders dynamically.");

        Scanner scanner = new Scanner(System.in);
        File folder = new File(STORIES_FOLDER);

        if (!folder.exists() || !folder.isDirectory() || folder.listFiles().length == 0) {
            System.out.println("Error: No stories found in the 'stories' folder.");
            printFooter(ucid, 3);
            scanner.close();
            return;
        }
        List<String> lines = new ArrayList<>();
        // Start edits

        // ctr26 06/15/2025

        // Step 1: Randomly generate an integer between 1-5 and create a story_.txt String with the integer
        // Step 2: Read the file that matches the created string and split it into a string array of each line
        // Step 3: Split the each line into an array of each word and iterate through it using a for loop
        // Step 4: Use an if statement to only output the placeholder with the <>
        // Step 5: Use the scanner class to read each input of the user
        // Steo 6: Replace the placeholder in the word array with the users input
        // Step 7: Join the new word array into sentences
        // Step 8: Print out the full file sentence by sentence

        // load a random story file
        int storyNum = (int) (Math.random() * 4) + 1;
        String storyFile = "story" + storyNum + ".txt";
        File story = new File(folder + "/" + storyFile);

        // parse the story lines
        try 
        {
            Scanner reader = new Scanner(story);
            while (reader.hasNextLine())
            {
                lines.add(reader.nextLine());
            } 
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        // iterate through the lines
        for (int i = 0; i < lines.size(); i++)
        {
            String[] words = lines.get(i).split(" ");
            for (String word : words)
            {
                // prompt the user for each placeholder (note: there may be more than one 
                // placeholder in a line)
                if (word.contains("<"))
                {
                    System.out.println("Please enter a(n): " + word.replaceAll("[^a-zA-Z]", " ").trim());
                    String input = scanner.nextLine();
                    
                    // apply the update to the same collection slot
                    lines.set(i, lines.get(i).replace(word.replaceAll("[^\\w<>]", ""), input));
                }
            }
        }
       
        

        // End edits
        System.out.println("\nYour Completed Mad Libs Story:\n");
        StringBuilder finalStory = new StringBuilder();
        for (String line : lines) {
            finalStory.append(line).append("\n");
        }
        System.out.println(finalStory.toString());

        printFooter(ucid, 3);
        scanner.close();
    }
}