package max.vanach.lesson_1;

import java.io.*;
import java.util.Scanner;

public class PlayerManager {

    // Metoda tworząca lub wczytująca gracza
    public static Player loadPlayer(String nickname) {
        Player player = new Player(nickname);

        String filename = "./" + nickname + ".txt";
        File file = new File(filename);

        if (file.exists()) {
            System.out.println("Found existing player file!"); // niepotrzebne mam welcomeback
            loadPlayerData(player, file);
        } else {
            System.out.println("Welcome new player, " + nickname + "!");
        }

        return player;
    }

    // Metoda wczytująca dane z pliku
    private static void loadPlayerData(Player player, File file) {
        try {
            Scanner fileReader = new Scanner(file);

            // Linia 1: nickname (pomijamy)
            if (fileReader.hasNextLine()) {
                fileReader.nextLine();
            }

            // Linie 2-4: Single best scores (Easy, Medium, Hard)
            for (int level = 1; level <= 3; level++) {
                if (fileReader.hasNextLine()) {
                    int score = Integer.parseInt(fileReader.nextLine());
                    player.setSingleScore(level, score);
                }
            }

            // Linie 5-7: Versus best scores (Easy, Medium, Hard)
            for (int level = 1; level <= 3; level++) {
                if (fileReader.hasNextLine()) {
                    int score = Integer.parseInt(fileReader.nextLine());
                    player.setVersusScore(level, score);
                }
            }

            // Linia 8: Versus wins
            if (fileReader.hasNextLine()) {
                int wins = Integer.parseInt(fileReader.nextLine());
                player.setVersusWins(wins);
            }

            // Linia 9: Versus losses
            if (fileReader.hasNextLine()) {
                int losses = Integer.parseInt(fileReader.nextLine());
                player.setVersusLosses(losses);
            }

            // Linia 10: Multiplayer wins
            if (fileReader.hasNextLine()) {
                int multiWins = Integer.parseInt(fileReader.nextLine());
                player.setMultiWins(multiWins);
            }

            // Linia 11: Multiplayer losses
            if (fileReader.hasNextLine()) {
                int multiLosses = Integer.parseInt(fileReader.nextLine());
                player.setMultiLosses(multiLosses);
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: corrupted save file!");
        }
    }

    // Metoda zapisująca gracza do pliku
    public static void savePlayer(Player player) {
        String filename = "./" + player.getNickname() + ".txt";
        File file = new File(filename);

        try {
            PrintWriter fileWriter = new PrintWriter(file);

            // Linia 1: nick
            fileWriter.println(player.getNickname());

            // Linie 2-4: Single best scores
            for (int level = 1; level <= 3; level++) {
                fileWriter.println(player.getSingleBestScore(level));
            }

            // Linie 5-7: Versus best scores
            for (int level = 1; level <= 3; level++) {
                fileWriter.println(player.getVersusBestScore(level));
            }

            // Linia 8-9: Versus wins/losses
            fileWriter.println(player.getVersusWins());
            fileWriter.println(player.getVersusLosses());
            // Linia 10-11: Multiplayer wins/losses
            fileWriter.println(player.getMultiWins());
            fileWriter.println(player.getMultiLosses());

            fileWriter.close();
            System.out.println("Data saved for player: " + player.getNickname());
        } catch (FileNotFoundException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }

}