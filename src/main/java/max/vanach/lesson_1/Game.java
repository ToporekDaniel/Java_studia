package max.vanach.lesson_1;

import java.util.Random;
import java.util.Scanner;


public class Game {
    
    private int secretNumber;
    private int tries;
    private Random random;
    private int level;
  

    public Game(int level)
    {
        this.random = new Random();
        this.level = level;

        System.out.print("A new game has started! Guess the number between 1 and 100");
        switch(this.level)
        {
            case 1:
                this.secretNumber = random.nextInt(1, 101); 
                System.out.println(".");
                break;
            case 2:
                this.secretNumber = random.nextInt(1, 10001); 
                System.out.println("00.");
                break;
            case 3:
                this.secretNumber = random.nextInt(1, 1000001); 
                System.out.println("0000.");
                break;
        }
        this.tries = 0;
    }

   
    public boolean makeGuess(int guess) {
        this.tries++;
        if (guess < secretNumber) {
            System.out.println("Too low! Try again.");
            return false;
        } else if (guess > secretNumber) {
            System.out.println("Too high! Try again.");
            return false;
        } else {
            System.out.println("Congratulations! You've guessed the number " + secretNumber + " in " + tries + " tries.");
            return true;
        }
    }

    public void play(Scanner scan) {
    boolean hasWon = false;
    while (!hasWon) {
        System.out.print("Enter your guess: ");
        int guess = Integer.parseInt(scan.nextLine());
        hasWon = makeGuess(guess);
    }
}



    public int getTries()
        {
            return this.tries;
        }

   
}