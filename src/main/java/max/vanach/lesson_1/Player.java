package max.vanach.lesson_1;

// Tylko dane gracza, BEZ logiki plików
public class Player 
{
    private String nickname;
    private int bestScoreEasy;
    private int bestScoreMedium;
    private int bestScoreHard;

    public Player(String nickname)
    {
        this.nickname = nickname;
        this.bestScoreEasy = 999;
        this.bestScoreMedium = 999;
        this.bestScoreHard = 999;
    }
    
    public String getNickname()
    {
        return this.nickname;
    }

    public int getBestScore(int level)
    {
        switch (level) {
            case 1:
                return this.bestScoreEasy;
            case 2:
                return this.bestScoreMedium;
            case 3:
                return this.bestScoreHard;
            default:
                return 999;
        }
    }

    public void setBestScore(int level, int tries)
    {
        switch (level) {
            case 1:
                setBestScoreEasy(tries);
                break;
            case 2:
                setBestScoreMedium(tries);
                break;
            case 3:
                setBestScoreHard(tries);
                break;
        }
    }

    public void setBestScoreEasy(int tries)
    {
        if (tries < this.bestScoreEasy) {
            if(this.bestScoreEasy == 999)
            {
                System.out.println("New record! " + tries + " tries. Congratulations!");
            }
            else
            {
                System.out.println("New record! Previous: " + this.bestScoreEasy + ", New: " + tries);
            }
            this.bestScoreEasy = tries;
        }
    }

    public void setBestScoreMedium(int tries)
    {
        if (tries < this.bestScoreMedium) {
            if(this.bestScoreMedium == 999)
            {
                System.out.println("New record! " + tries + " tries. Congratulations!");
            }
            else
            {
                System.out.println("New record! Previous: " + this.bestScoreMedium + ", New: " + tries);
            }
            this.bestScoreMedium = tries;
        }
    }

    public void setBestScoreHard(int tries)
    {
        if (tries < this.bestScoreHard) {
            if(this.bestScoreHard == 999)
            {
                System.out.println("New record! " + tries + " tries. Congratulations!");
            }
            else
            {
                System.out.println("New record! Previous: " + this.bestScoreHard + ", New: " + tries);
            }
            this.bestScoreHard = tries;
        }
    }

    public void setScore(int level, int score)
{
    switch (level) {
        case 1:
            this.bestScoreEasy = score;
            break;
        case 2:
            this.bestScoreMedium = score;
            break;
        case 3:
            this.bestScoreHard = score;
            break;
    }
}
   
}