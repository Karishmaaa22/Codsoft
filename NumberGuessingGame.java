import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 5;
            boolean guessedCorrectly = false;
            
            System.out.println("I have selected a number between 1 and 100. Can you guess it?");
            
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedCorrectly = true;
                    totalScore += attemptsLeft; // Score based on remaining attempts
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
                
                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry! You've run out of attempts. The number was " + numberToGuess);
            }
            
            System.out.println("Your total score: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }
        
        System.out.println("Thanks for playing! Your final score: " + totalScore);
        scanner.close();
    }
}
