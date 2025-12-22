package max.vanach.lesson_1;

import java.util.Scanner;
import java.util.Random;

public class GameVersus {
    private Game playerGame;
    private GameReverse computerGame;
    private int tries;
  

    public GameVersus(int level) {
        playerGame = new Game(level);
        computerGame = new GameReverse(level);
        this.tries = 0;
    }

    public void play(Scanner scan) {
        Random random = new Random();
        boolean playerWon = false;
        boolean computerWon = false;
        int coinToss = random.nextInt(0, 2); // 0 for player first, 1 for computer first
        
        switch (coinToss) {
            case 0:
                System.out.println("Player goes first!");
                while (!playerWon && !computerWon)
                {
                    tries++;
                    // Player's turn
                    System.out.print("Player, enter your guess: ");
                    int playerGuess = Integer.parseInt(scan.nextLine());
                    playerWon = playerGame.makeGuess(playerGuess);

                    if (playerWon) {
                        System.out.println("Player wins!");
                        break;
                    }

                    // Computer's turn
                    int computerGuess = computerGame.guessNumber();
                    System.out.print("Enter hint for computer (1 - Too low, 2 - Too high, 3 - Correct): ");
                    int hint = Integer.parseInt(scan.nextLine());
                    computerWon = computerGame.playerHint(hint);

                    if (computerWon) {
                        System.out.println("Computer wins!");
                        break;
                    }
                }
               
            case 1:
                System.out.println("Computer goes first!");
                while (!playerWon && !computerWon)
                {
                    tries++;
                    // Computer's turn
                    int computerGuess = computerGame.guessNumber();
                    System.out.print("Enter hint for computer (1 - Too low, 2 - Too high, 3 - Correct): ");
                    int hint = Integer.parseInt(scan.nextLine());
                    computerWon = computerGame.playerHint(hint);

                    if (computerWon) {
                        System.out.println("Computer wins!");
                        break;
                    }

                    // Player's turn
                    System.out.print("Player, enter your guess: ");
                    int playerGuess = Integer.parseInt(scan.nextLine());
                    playerWon = playerGame.makeGuess(playerGuess);

                    if (playerWon) {
                        System.out.println("Player wins!");
                        break;
                    }

                }

            default:
                break;
        }
    }

    public int getTries()
        {
            return this.tries;
        }

}