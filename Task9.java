import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        
        // Generate random 6 digits number
        Random random = new Random();

        int min = 111111, max = 999999;
        int randNum = random.nextInt(max - min + 1) + min;
        
        List<Integer> guessNum = new ArrayList<>();
        

        // Prompt user to input a 6 digit number guesses
        String userInput;
        Scanner scanner = new Scanner(System.in);

        int minBound = 0;
        int maxBound = 999999;

        boolean userWin = false;

        System.out.println("\nYour guess: ");

        while (true) {

            userInput = scanner.nextLine();
            if (userInput.toLowerCase().equals("quit")) {
                System.out.println("Exiting program");
                break;
            }

            // assuming no incorrect input
            int guessValue = Integer.parseInt(userInput);
            guessNum.add(guessValue);
            Collections.sort(guessNum);

            if (guessValue > minBound) {
                if (guessValue != randNum)
                    if (guessValue < randNum)
                        minBound = guessValue;

                if (guessValue > randNum)
                    if (guessValue < maxBound)
                        maxBound = guessValue;

                if (guessValue < randNum) {
                    System.out.println("Number guessed is lower. " + minBound + " and " + maxBound);
                } 
                else if (guessValue > randNum) {
                    System.out.println("Number guessed is higher. " + minBound + " and " + maxBound);
                } 
                else {
                    System.out.println("You guessed it correctly. ");
                    userWin = true;
                    System.out.println("The number is " + randNum);
                }
            }
        }
    }
}