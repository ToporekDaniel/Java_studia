//zmienione nazwy plików na PascalCase

package max.vanach.lesson_1;

import java.util.Scanner;
import java.io.*;

public class Lesson2Mine {
       
    public static void main(String[] args) throws FileNotFoundException {
       
        Scanner scan = new Scanner(System.in);
        
        System.out.print("What is your player name: ");
        String name = scan.nextLine();
        
        // Wczytaj lub stwórz gracza przez PlayerManager
        Player player = PlayerManager.loadPlayer(name);
       
        if(player.getBestScore(1) == 999 && player.getBestScore(2) == 999 && player.getBestScore(3) == 999) {
            System.out.println("This is your first game, good luck!");
        }
        else {
            System.out.print("Your best scores - ");
            if(player.getBestScore(1) != 999) System.out.print("Easy: " + player.getBestScore(1) + " ");
            if(player.getBestScore(2) != 999) System.out.print("Medium: " + player.getBestScore(2) + " ");
            if(player.getBestScore(3) != 999) System.out.print("Hard: " + player.getBestScore(3));
            System.out.println();
        }   

        // Gra
        int gameMode = GameModeSelector.selectGameMode();
        int level = LevelSelector.selectLevel();
        boolean hasWon = false;
        switch (gameMode) {
            case 1:
                // Player vs Number
                Game game = new Game(level);
                while (!hasWon) {
                    System.out.print("Enter your guess: ");
                    int guess = Integer.parseInt(scan.nextLine());
                    hasWon = game.makeGuess(guess);
                }
                player.setBestScore(level, game.getTries());
                System.out.println("Your current best score: " + player.getBestScore(level));
                break;
            case 2:
                // Computer vs Number
                GameReverse gameReverse = new GameReverse(level);
                System.out.print("Enter hint (1 - Too low, 2 - Too high, 3 - Correct): ");
                 while (!hasWon) {
                    System.out.print("My guess is: ");
                    int guess = gameReverse.guessNumber(level);
                    int hint = Integer.parseInt(scan.nextLine());
                    hasWon = gameReverse.playerHint(hint);
                }
                //tutaj będzie zapis wyniku komputera, jeśli zaimplementujesz taką funkcjonalność
                 System.out.println("Computer guessed your number in " + gameReverse.getTries() + " tries.");
                break;
            case 3:
                // Player vs Computer
                break;
            default:
                break;
        }
        
        

        // Zapisz gracza przez PlayerManager
        PlayerManager.savePlayer(player);
        
        scan.close();
    }
}