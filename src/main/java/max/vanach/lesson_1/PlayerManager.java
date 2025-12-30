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
            Scanner filereader = new Scanner(file);

            // Linia 1: nickname (pomijamy)
            if (filereader.hasNextLine()) {
                filereader.nextLine();
            }

            // Linie 2-4: Single best scores (Easy, Medium, Hard)
            for (int level = 1; level <= 3; level++) {
                if (filereader.hasNextLine()) {
                    int score = Integer.parseInt(filereader.nextLine());
                    player.setSingleScore(level, score);
                }
            }

            // Linie 5-7: Versus best scores (Easy, Medium, Hard)
            for (int level = 1; level <= 3; level++) {
                if (filereader.hasNextLine()) {
                    int score = Integer.parseInt(filereader.nextLine());
                    player.setVersusScore(level, score);
                }
            }

            // Linia 8: Versus wins
            if (filereader.hasNextLine()) {
                int wins = Integer.parseInt(filereader.nextLine());
                player.setVersusWins(wins);
            }

            // Linia 9: Versus losses
            if (filereader.hasNextLine()) {
                int losses = Integer.parseInt(filereader.nextLine());
                player.setVersusLosses(losses);
            }

            // Linia 10: Multiplayer wins
            if (filereader.hasNextLine()) {
                int multiWins = Integer.parseInt(filereader.nextLine());
                player.setMultiWins(multiWins);
            }

            // Linia 11: Multiplayer losses
            if (filereader.hasNextLine()) {
                int multiLosses = Integer.parseInt(filereader.nextLine());
                player.setMultiLosses(multiLosses);
            }

            filereader.close();
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
            PrintWriter filewriter = new PrintWriter(file);

            // Linia 1: nick
            filewriter.println(player.getNickname());

            // Linie 2-4: Single best scores
            for (int level = 1; level <= 3; level++) {
                filewriter.println(player.getSingleBestScore(level));
            }

            // Linie 5-7: Versus best scores
            for (int level = 1; level <= 3; level++) {
                filewriter.println(player.getVersusBestScore(level));
            }

            // Linia 8-9: Versus wins/losses
            filewriter.println(player.getVersusWins());
            filewriter.println(player.getVersusLosses());
            // Linia 10-11: Multiplayer wins/losses
            filewriter.println(player.getMultiWins());
            filewriter.println(player.getMultiLosses());

            filewriter.close();
            System.out.println("Data saved for player: " + player.getNickname());
        } catch (FileNotFoundException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }

}