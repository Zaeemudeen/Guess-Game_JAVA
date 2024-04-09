import java.util.*;

public class Main {
    public static void main(String[] args) {
        guessGame Game = new guessGame();
        Game.Start();
    }
}

class guessGame {
    private static final int MAX_GUESSES = 3;
    private static final int MAX_NUMBER = 10;
    Scanner k = new Scanner(System.in);
    Random rand = new Random();

    public void Start() {
        int randomNumber = rand.nextInt(MAX_NUMBER);

        for (int guesses = 1; guesses <= MAX_GUESSES; guesses++) {
            System.out.println("CHANCE " + guesses + ": " + "Input your guess between 0 - " + MAX_NUMBER);
            int Guess = k.nextInt();
            System.out.println();

            if (Guess == randomNumber) {
                Congratulate();
                startAgain();
                return;
            } else {
                guessWrong(Guess, randomNumber, MAX_GUESSES, guesses);
            }
        }

        gameOver(randomNumber);
        startAgain();
    }

    public void Congratulate() {
        System.out.println("          *******************************");
        System.out.println("          *  Congratulations! ");
        System.out.println("          *  Your Guess is correct");
        System.out.println("          *******************************");
    }

    public void guessWrong(int Guess, int randomNumber, int MAX_GUESSES, int guesses) {
        System.out.println("          *******************************");
        System.out.println("          *  Huh! Your guess is wrong");
        System.out.println("          *  Your guess is" + " " + (Guess > randomNumber ? "higher" : "lower"));
        System.out.println("          *  CHANCES LEFT: " + (MAX_GUESSES - guesses));
        System.out.println("          *******************************");
        System.out.println();
    }

    public void gameOver(int randomNumber) {
        System.out.println("          *******************************");
        System.out.println("          *  GUESS CHANCES OVER !");
        System.out.println("          *  THE NUMBER IS " + "\"" + randomNumber + "\"");
        System.out.println("          *******************************");
    }

    public void startAgain() {
        int choice;

        System.out.println();
        System.out.println("TO END GAME : PRESS 1");
        System.out.println("TO PLAY AGAIN : PRESS 2");
        choice = k.nextInt();
        System.out.println();

        if (choice != 2) {
            System.exit(0);
        } else {
            Start();
        }

        k.close();
    }
}
