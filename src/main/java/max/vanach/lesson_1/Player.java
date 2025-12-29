package max.vanach.lesson_1;

public class Player 
{
    private String nickname;
    
    // [0]=Easy, [1]=Medium, [2]=Hard
    private int[] singleBestScores;
    private int[] versusBestScores;
    
    private int versusWins;
    private int versusLosses;
    
    public Player(String nickname)
    {
        this.nickname = nickname;
        this.singleBestScores = new int[]{999, 999, 999};
        this.versusBestScores = new int[]{999, 999, 999};
        this.versusWins = 0;
        this.versusLosses = 0;
    }
    
    // level: 1, 2, 3 -> index: 0, 1, 2
    public int getSingleBestScore(int level)
    {
        return this.singleBestScores[level - 1];
    }
    
    public int getVersusBestScore(int level)
    {
        return this.versusBestScores[level - 1];
    }
    
    public void setSingleBestScore(int level, int tries)
    {
        int index = level - 1;
        if (tries < this.singleBestScores[index])
        {
            printNewRecord(this.singleBestScores[index], tries);
            this.singleBestScores[index] = tries;
        }
    }
    
    public void setVersusBestScore(int level, int tries)
    {
        int index = level - 1;
        if (tries < this.versusBestScores[index])
        {
            printNewRecord(this.versusBestScores[index], tries);
            this.versusBestScores[index] = tries;
        }
    }
    
    private void printNewRecord(int oldScore, int newScore)
    {
        if (oldScore == 999) {
            System.out.println("New record! " + newScore + " tries. Congratulations!");
        } else {
            System.out.println("New record! Previous: " + oldScore + ", New: " + newScore);
        }
    }
    
    public void printScores() {

        // Single scores
        System.out.print("Single best scores - ");
        for (int level = 1; level <= 3; level++) {
            if (getSingleBestScore(level) != 999) {
                String levelName = LevelSelector.getLevelName(level);
                System.out.print(levelName + ": " + getSingleBestScore(level) + " ");
            }
        }
        System.out.println();

        // Versus scores
        System.out.print("Versus best scores - ");
        for (int level = 1; level <= 3; level++) {
            if (getVersusBestScore(level) != 999) {
                String levelName = LevelSelector.getLevelName(level);
                System.out.print(levelName + ": " + getVersusBestScore(level) + " ");
            }
        }
        System.out.println();

        // Versus wins/losses
        System.out.println(
                "Versus record: " + getVersusWins() + " wins / " + getVersusLosses() + " losses");
    }
    
    public void addVersusWin() { this.versusWins++; }
    public void addVersusLoss() { this.versusLosses++; }
    
    public int getVersusWins() { return this.versusWins; }
    public int getVersusLosses() { return this.versusLosses; }
    public String getNickname() { return this.nickname; }
    
    // Do odczytu z pliku
    public void setVersusWins(int wins) { this.versusWins = wins; }
    public void setVersusLosses(int losses) { this.versusLosses = losses; }
    public void setSingleScore(int level, int score) { this.singleBestScores[level - 1] = score; }
    public void setVersusScore(int level, int score) { this.versusBestScores[level - 1] = score; }
}