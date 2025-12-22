package max.vanach.lesson_1;

import java.util.Scanner;

public class LevelSelector {
     public static int selectLevel() 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Select level (1-Easy, 2-Medium, 3-Hard): ");
        int level = Integer.parseInt(scan.nextLine());
        switch(level)
        {
            case 1:
                System.out.println("You selected Easy mode.");
                break;
            case 2:
                System.out.println("You selected Medium mode.");
                break;
            case 3:
                System.out.println("You selected Hard mode.");
                break;
            default:
                System.out.println("Invalid level. Please choose 1, 2, or 3.");
                return selectLevel();
        }
        return level;
    }
}
