package max.vanach.lesson_1;

import java.util.Scanner;

public class LevelSelector {
    public static int selectLevel(Scanner scan, int gameMode) {
        System.out.print("Select level (1-Easy, 2-Medium, 3-Hard");

        // Opcja 4 tylko dla versus (3) i multi (4)
        if (gameMode == 4) {
            System.out.print(", 4-Advanced");
        }
        System.out.println("): ");

        int level = Integer.parseInt(scan.nextLine());
        switch (level) {
            case 1:
                System.out.println("You selected Easy mode.");
                break;
            case 2:
                System.out.println("You selected Medium mode.");
                break;
            case 3:
                System.out.println("You selected Hard mode.");
                break;
            case 4:
                if (gameMode == 4) {
                    System.out.println("You selected Advanced mode.");
                    // Tu będzie pobieranie zakresu
                } else {
                    System.out.println("Invalid level.");
                    return selectLevel(scan, gameMode);
                }
                break;
            default:
                System.out.println("Invalid level.");
                return selectLevel(scan, gameMode);
        }
        return level;
    }

    public static String getLevelName(int level) {
        switch (level) {
            case 1:
                return "Easy";
            case 2:
                return "Medium";
            case 3:
                return "Hard";
            case 4:
                return "Advanced";
            default:
                return "Unknown";
        }
    }
}
