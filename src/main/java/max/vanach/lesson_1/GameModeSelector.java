package max.vanach.lesson_1;

import java.util.Scanner;
import java.util.ArrayList;

public class GameModeSelector {
    private static ArrayList<Player> players;

    public static int selectGameMode(Scanner scan) {

        System.out.println("Select game mode:");
        System.out.println("1 - Player vs Number");
        System.out.println("2 - Computer vs Number");
        System.out.println("3 - Player vs Computer");
        System.out.println("4 - Multiplayer");
        System.out.println("0 - Exit");

        int gameMode = Integer.parseInt(scan.nextLine());
        switch (gameMode) {
            case 1:
                System.out.println("You selected Player vs Number mode.");
                break;
            case 2:
                System.out.println("You selected Computer vs Number mode.");
                break;
            case 3:
                System.out.println("You selected Player vs Computer mode.");
                break;
            case 4:
                System.out.println("You selected Multiplayer mode.");
                break;
            case 0:
                System.out.println("Exiting the game. Goodbye!");
                return 0;
            default:
                System.out.println("Invalid level. Please choose 1, 2, or 3.");
                return selectGameMode(scan);
        }
        return gameMode;
    }

    public static void playSelectedMode(int gameMode, int level, Player player, Player computer, Scanner scan) {
        switch (gameMode) {
            case 1:
                // Player vs Number (single)
                Game game = new Game(level);
                game.play(scan);
                player.setSingleBestScore(level, game.getTries());
                System.out.println("Your current best score: " + player.getSingleBestScore(level));
                PlayerManager.savePlayer(player);
                break;

            case 2:
                // Computer vs Number
                GameReverse gameReverse = new GameReverse(level);
                gameReverse.play(scan);
                computer.setSingleBestScore(level, gameReverse.getTries());
                System.out.println("Computer guessed your number in " + gameReverse.getTries() + " tries.");
                System.out.println("Computer's best score: " + computer.getSingleBestScore(level));
                PlayerManager.savePlayer(computer);
                break;

            case 3:
                // Player vs Computer (versus)
                GameVersus gameVersus = new GameVersus(level, player, computer);
                boolean playerWon = gameVersus.play(scan);

                if (playerWon) {
                    player.setVersusBestScore(level, gameVersus.getTries()); // <- zapisujesz tries z gry
                    System.out.println("Your current versus best score: " + player.getVersusBestScore(level));
                }
                System.out.println("Game over! Thanks for playing.");
                PlayerManager.savePlayer(player);
                PlayerManager.savePlayer(computer);
                break;

            case 4:
                // Multiplayer
                players = Multiplayer.setupPlayers(scan);
                while (true) {
                    Multiplayer multiplayer = new Multiplayer(level, scan);
                    multiplayer.multiPlay(scan, players);
                    System.out.print("Do you want to play another round? (1 - yes, 2 - no): ");
                    int choice = Integer.parseInt(scan.nextLine());
                    if (choice != 1) {
                        break;
                    }
                    System.out.println("Starting a new round! Winner pick the next numbers.");
                    level = LevelSelector.selectLevel(scan, 4);
                }
                break;
        }
    }
}