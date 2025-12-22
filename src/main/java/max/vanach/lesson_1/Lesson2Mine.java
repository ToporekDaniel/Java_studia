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
        int gameMode = GameModeSelector.selectGameMode(scan);
        int level = LevelSelector.selectLevel(scan);
        GameModeSelector.playSelectedMode(gameMode, level, player, scan);
      
        
        

        // Zapisz gracza przez PlayerManager
        PlayerManager.savePlayer(player);
        
        scan.close();
    }
}