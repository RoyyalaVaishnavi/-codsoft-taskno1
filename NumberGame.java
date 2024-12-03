import java.util.Random;
import java.util.Scanner;
public class NumberGame {
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int successfulRounds = 0;
        int totalRounds = 0;
        do { 
            totalRounds++;
            if(playRound(sc,r)) {
                successfulRounds++;
            }
        } while (askToPlayAgain(sc));
        System.out.println("\nGame Over! You Played " + totalRounds + " round(s).");
        System.out.println("Your total score (successful rounds): " + successfulRounds);
        System.out.println("Thank you for Playing!");
        sc.close();
    }
    private static boolean playRound(Scanner sc,Random r) {
        int randonNumber = r.nextInt(MAX) + 1;
        int attempts = 0;
        boolean guessedCorrectly = false;
        System.out.println("\nNew Round! Guess a number between 1 and " + MAX + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts. Good luck!");
        while(attempts < MAX_ATTEMPTS && !guessedCorrectly) {
            System.out.println("Attempt " + (attempts + 1) + ": ");
            int userGuess = sc.nextInt();
            attempts++;
            if(userGuess == randonNumber) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number " + randonNumber + " in " + attempts + " attempts.");
            }else if(userGuess > randonNumber) {
                System.out.println("Too high! Try Again.");
            }else {
                System.out.println("Too low! Try Again.");
            }
        }
        if(!guessedCorrectly) {
            System.out.println("You've run out of attempts. The correct number was " +randonNumber + ".");
        }
        return guessedCorrectly;
    }
    private  static  boolean  askToPlayAgain(Scanner sc) {
        System.out.println("Would you like to play another round ? (yes/no): ");
        return sc.next().equalsIgnoreCase("yes");
    }
}