package max.vanach.lesson_1;

import java.util.Scanner;

public class GameModeSelector {
      public static int selectGameMode() 
    {
        Scanner scan = new Scanner(System.in);
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
                return selectGameMode();
        }
        return gameMode;
    }
}
