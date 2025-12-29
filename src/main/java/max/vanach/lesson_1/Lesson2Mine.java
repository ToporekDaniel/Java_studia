package max.vanach.lesson_1;

import java.util.Scanner;
import java.io.*;

public class Lesson2Mine {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);

        System.out.print("What is your player name: ");
        String name = scan.nextLine();

        boolean isNewPlayer = true;
        // Wczytaj lub stwórz gracza przez PlayerManager
        Player player = PlayerManager.loadPlayer(name);

        // Wczytaj lub stwórz komputer
        Player computer = PlayerManager.loadPlayer("_COMPUTER");

        // Sprawdź czy to nowy gracz (wszystkie wyniki domyślne)
        for (int level = 1; level <= 3; level++) {
            if (player.getSingleBestScore(level) != 999 || player.getVersusBestScore(level) != 999) {
                isNewPlayer = false;
                break;
            }
        }
        if (player.getVersusWins() > 0 || player.getVersusLosses() > 0) {
            isNewPlayer = false;
        }

        // TODO albo całość przeniść PlayerManager i tam zrobić metodę
        // isNewPlayer(Player player) na podstawie czy plik istnieje

        if (isNewPlayer) {
            System.out.println("This is your first game, good luck!");
        } else {
            player.printScores();
        }

        while (true) {
            // Gra
            int gameMode = GameModeSelector.selectGameMode(scan);
            if (gameMode == 0) {
                break;
            }
            int level = LevelSelector.selectLevel(scan);
            GameModeSelector.playSelectedMode(gameMode, level, player, computer, scan);

            // Zapisz gracza i komputer przez PlayerManager
            PlayerManager.savePlayer(player);
            PlayerManager.savePlayer(computer);
        }
        scan.close();
    }
}