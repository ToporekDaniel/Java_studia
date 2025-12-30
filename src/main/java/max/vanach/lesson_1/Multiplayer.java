package max.vanach.lesson_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Multiplayer {

    private int secretNumber;
    private int tries;
    private Random random;
    private int min;
    private int max;

    public Multiplayer(int level, Scanner scan) { // dodaj Scanner
        random = new Random();

        switch (level) {
            case 1:
                this.min = 1;
                this.max = 100;
                this.secretNumber = random.nextInt(1, 101);
                System.out.println("A new game has started! Guess the number between 1 and 100.");
                break;
            case 2:
                this.min = 1;
                this.max = 10000;
                this.secretNumber = random.nextInt(1, 10001);
                System.out.println("A new game has started! Guess the number between 1 and 10000.");
                break;
            case 3:
                this.min = 1;
                this.max = 1000000;
                this.secretNumber = random.nextInt(1, 1000001);
                System.out.println("A new game has started! Guess the number between 1 and 1000000.");
                break;
            case 4:
                System.out.print("Enter the minimum number: ");
                this.min = Integer.parseInt(scan.nextLine()); // this.min, nie int min
                System.out.print("Enter the maximum number: ");
                this.max = Integer.parseInt(scan.nextLine()); // this.max, nie int max
                this.secretNumber = random.nextInt(this.min, this.max + 1);
                System.out.println(
                        "A new game has started! Guess the number between " + this.min + " and " + this.max + ".");
                break;
        }
        this.tries = 0;
    }

    public boolean makeGuess(int guess) {
        this.tries++;
        if (guess < min) {
            System.out.println("Your guess is below the minimum limit of " + min + ". Try again.");
            return false;
        } else if (guess > max) {
            System.out.println("Your guess is above the maximum limit of " + max + ". Try again.");
            return false;
        } else if (guess < secretNumber) {
            System.out.println("Too low! Try again.");
            return false;
        } else if (guess > secretNumber) {
            System.out.println("Too high! Try again.");
            return false;
        } else {
            System.out
                    .println("Congratulations! You've guessed the number " + secretNumber + " in " + tries + " tries.");
            return true;
        }
    }

    public void play(Scanner scan, ArrayList<Player> players) {
        int currentPlayer = 0;

        boolean hasWon = false;
        while (!hasWon) {
            Player player = players.get(currentPlayer);
            System.out.print(player.getNickname() + " your guess is: ");
            int guess = Integer.parseInt(scan.nextLine());
            hasWon = makeGuess(guess);

            if (hasWon) {
                System.out.println(player.getNickname() + " wins!");

                // Zwycięzca dostaje win
                player.addMultiWin();

                // Reszta dostaje loss
                for (Player p : players) {
                    if (p != player) {
                        p.addMultiLoss();
                    }
                }

                // Zapisz wszystkich graczy
                for (Player p : players) {
                    PlayerManager.savePlayer(p);
                }
            } else {
                currentPlayer = (currentPlayer + 1) % players.size();
            }
        }
    }

    public static ArrayList<Player> setupPlayers(Scanner scan) {
        System.out.print("Enter number of players: ");
        int numOfPlayers = Integer.parseInt(scan.nextLine());
        ArrayList<Player> players = new ArrayList<>();

        for (int i = 1; i <= numOfPlayers; i++) {
            System.out.print("Enter nickname for Player " + i + ": ");
            String nickname = scan.nextLine();
            players.add(PlayerManager.loadPlayer(nickname));
        }

        return players;
    }

}