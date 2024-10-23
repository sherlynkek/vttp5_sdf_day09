import java.util.Random;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        
        // Generate random 6 digits number
        Random random = new Random();

        int min = 111111, max = 999999;
        int randNum = random.nextInt(max - min + 1) + min;
        

        // Prompt user to input a 6 digit number guesses
        String userInput;
        Scanner scanner = new Scanner(System.in);

        int minBound = 0;
        int maxBound = 999999;

         while (!userInput.toLowerCase().equals("quit")) {

            System.out.println("\nYour guess: ");
            userInput = scanner.nextLine();

            if (userInput.toLowerCase().equals("quit")) {
                System.out.println("Exiting program");
                break;
            }


            
/*            if (!userInput.equals(String.valueOf(randNum))) {
                System.out.println("Invalid numbers of digit");
            }

            for (int i = 0; i < 6; i++) {
                if (!((userInput.charAt(i) >= 49) && (userInput.charAt(i) <= 57))) {
                    System.err.println("Invalid character detected");
                    break;
                }
            }

            
            if (Integer.parseInt(userInput) > Integer.parseInt(total)) {
                System.out.println("Guess lower");
            } 
            else if (Integer.parseInt(userInput) < Integer.parseInt(total)) {
                System.out.println("Guess higher");
            }
            else {
                System.out.println("You guessed it");
            } */

        }

        System.out.println("The number is " + randNum);
    }
}