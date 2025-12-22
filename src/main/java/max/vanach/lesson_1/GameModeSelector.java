package max.vanach.lesson_1;

import java.util.Scanner;

public class GameModeSelector {
    public static int selectGameMode(Scanner scan) 
    {
       
        System.out.println("Select game mode:");
        System.out.println("1 - Player vs Number");
        System.out.println("2 - Computer vs Number");
        System.out.println("3 - Player vs Computer");

        int gameMode = Integer.parseInt(scan.nextLine());
        switch(gameMode)
        {
            case 1:
                System.out.println("You selected Player vs Number mode.");
                break;
            case 2:
                System.out.println("You selected Computer vs Number mode.");
                break;
            case 3:
                System.out.println("You selected Player vs Computer mode.");
                break;
            default:
                System.out.println("Invalid level. Please choose 1, 2, or 3.");
                return selectGameMode(scan);
        }
        return gameMode;
    }

    public static void playSelectedMode(int gameMode, int level, Player player , Scanner scan)
    {
        
        
        switch (gameMode) {
            case 1:
                // Player vs Number
                Game game = new Game(level);
                game.play(scan);
                player.setBestScore(level, game.getTries());
                System.out.println("Your current best score: " + player.getBestScore(level));
                break;
            case 2:
                // Computer vs Number
                GameReverse gameReverse = new GameReverse(level);
                System.out.print("Enter hint (1 - Too low, 2 - Too high, 3 - Correct): ");
                gameReverse.play(scan);
                //tutaj będzie zapis wyniku komputera, jeśli zaimplementujesz taką funkcjonalność
                 System.out.println("Computer guessed your number in " + gameReverse.getTries() + " tries.");
                break;
            case 3:
                // Player vs Computer
                GameVersus gameVersus = new GameVersus(level);
                gameVersus.play(scan);
                 System.out.println("Game over! Thanks for playing.");
                break;
            default:
                break;
        }
    }

}
