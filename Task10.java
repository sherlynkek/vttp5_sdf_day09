import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task10 {
    public static void main(String[] args) {
        
        // Random generated 10 different numbers 
        Random random = new Random();
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numberList.add(random.nextInt(1, 100));
        }

        Console console = System.console();
        Boolean userInput = true;
        String guess = "";
        int currentPos = 1;
        List<String> correctList = new ArrayList<>();

        System.out.printf("\r\nFirst Number: %d\r\n", numberList.get(0));
        correctList.add("-");
        while (userInput) {
            guess = console.readLine("\r\nGuess the next number is higher 'H' or lower 'L':");

            int higher = 0;
            int lower = 0;
            for(int x = currentPos; x < (numberList.size() - 1); x++) {
                if (numberList.get(x) < numberList.get(x - 1)) {
                    lower++;
                } else {
                    higher++;
                }
            }

            String answer = "";
            String correct = "0";
            if (numberList.get(currentPos - 1) < numberList.get(currentPos)) 
                answer = "h";
            else 
                answer = "l";

            if (guess.trim().toLowerCase().equals(answer))
                correct = "1";
            else 
                correct = "0";
            correctList.add(correct);

            // print out the results
            for(int a = 0; a <= currentPos; a++) {
                if (a == 0){ 
                    System.out.printf("\r\n%d", numberList.get(a));
                }
                else {
                    System.out.printf("    %d:%s", numberList.get(a), correctList.get(a));
                }
            }
            System.out.printf("    h:%d    l:%d", higher, lower);

            // program terminates/ends
            if (currentPos == 9) {
                userInput = false;
            }

            currentPos++;
        }
        System.out.println("\r\n");
    }
}
