package max.vanach.lesson_1;

import java.io.*;
import java.util.Scanner;

public class PlayerManager {
    
    // Metoda tworząca lub wczytująca gracza
    public static Player loadPlayer(String nickname)
    {
        Player player = new Player(nickname);
        
        String filename = "./" + nickname + ".txt";
        File file = new File(filename);

        if (file.exists())  // gracz istnieje
        {
            System.out.println("Found existing player file!");
            loadPlayerData(player, file);
        }
        else  // nowy gracz
        {
            System.out.println("Welcome new player, " + nickname + "!");
        }
        
        return player;
    }
    
    // Metoda wczytująca dane z pliku
    private static void loadPlayerData(Player player, File file)
    {
        try
        {
            Scanner filereader = new Scanner(file);
            
            // Linia 1: nickname (pomijamy)
            if (filereader.hasNextLine()) 
            {
                filereader.nextLine();
            }
            
            // Linia 2: Easy
            if (filereader.hasNextLine()) 
            {
                int scoreEasy = Integer.parseInt(filereader.nextLine());
                player.setScore(1, scoreEasy);
            }

            // Linia 3: Medium
            if (filereader.hasNextLine()) 
            {
                int scoreMedium = Integer.parseInt(filereader.nextLine());
                player.setScore(2, scoreMedium);
            }

            // Linia 4: Hard
            if (filereader.hasNextLine()) 
            {
                int scoreHard = Integer.parseInt(filereader.nextLine());
                player.setScore(3, scoreHard);
            }
            
            System.out.println("Welcome back, " + player.getNickname() + "!");
            
            filereader.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error reading file: " + e.getMessage());
        }
        catch (NumberFormatException e)
        {
            System.err.println("Error: corrupted save file!");
        }
    }
    
    // Metoda zapisująca gracza do pliku
    public static void savePlayer(Player player)
    {
        String filename = "./" + player.getNickname() + ".txt";
        File file = new File(filename);

        try
        {
            PrintWriter filewriter = new PrintWriter(file);
            filewriter.println(player.getNickname());       // Linia 1: nick
            filewriter.println(player.getBestScore(1));     // Linia 2: wynik Easy
            filewriter.println(player.getBestScore(2));     // Linia 3: wynik Medium
            filewriter.println(player.getBestScore(3));     // Linia 4: wynik Hard
            filewriter.close();
            System.out.println("Data saved for player: " + player.getNickname());
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }
    
}