import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        
        // Random generated 10 different numbers 
        Random random = new Random();
        List<Integer> numList = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            numList.add(random.nextInt(1, 100));
        }

        // 
        Scanner scanner = new Scanner(System.in);
        String userInput;

        int currentPos = 1;
        List<String> guessList = new ArrayList<>();
        System.out.println("First number: " + numList.get(0));

        while(true) {
            System.out.println("Guess the next number if it is higher(h) or lower(l) than the previous number: ");
            userInput = scanner.nextLine();
            
            String ans = "";
            String correct = "0";

            if (numList.get(currentPos - 1) < numList.get(currentPos) ) {
                ans = "h";
            }
            else {
                ans = "l";
            }

            if (userInput.trim().toLowerCase().equals(ans)) {
                correct = "1";
            }
            else {
                correct = "0";
                guessList.add(correct);
            }

            for(int a = 0; a <= currentPos; a++) {
                if (a == 0) {
                    System.out.printf("%d", numList.get(a));
                }
                else {
                    System.out.printf("%d : %s", numList.get(a), guessList.get(a));
                }
            }
        }

    }
}
