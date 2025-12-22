package max.vanach.lesson_1;


public class GameReverse {
    private int tries;
    private int guess;
    private int min = 1;
    private int max;
  

    public GameReverse(int level)
    {
        
        switch(level)
        {
            case 1:
                max = 100;
                break;
            case 2:
                max = 10000;
                break;
            case 3:
                max = 1000000;
                break;
        }

        System.out.print("A new game has started! Think of a number between 1 and 100");
        switch(level)
        {
            case 1:
                System.out.println(".");
                break;
            case 2:
                System.out.println("00.");
                break;
            case 3:
                System.out.println("0000.");
                break;
        }
        this.tries = 0;
    }

    public int guessNumber(int level) 
    {
        this.tries++;
        guess = (min + max) / 2;
        System.out.print("My guess is: ");
        System.out.println(guess);       
        return guess;
    }

    public boolean playerHint(int hint) 
    {
        switch (hint) {
            case 1:
                min = guess + 1;
                return false;
                
            case 2:
                max = guess - 1;
                return false;
                
            case 3:
                System.out.println("Huray! I've guessed your number " + guess + " in " + tries + " tries.");
                return true;
                
            default:
                System.out.println("Invalid hint. Please enter 1 (Too low), 2 (Too high), or 3 (Correct).");
                return false;
        }



    
    }

    public int getTries()
        {
            return this.tries;
        }

}
