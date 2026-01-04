package max.vanach.lesson_1;

public class Player {
    private String nickname;

    // [0]=Easy, [1]=Medium, [2]=Hard
    private int[] singleBestScores;
    private int[] versusBestScores;

    private int versusWins;
    private int versusLosses;
    private int multiWins;
    private int multiLosses;
    private boolean isLeader;
    private boolean isChampion;

    public Player(String nickname) {
        this.nickname = nickname;
        this.singleBestScores = new int[] { 999, 999, 999 };
        this.versusBestScores = new int[] { 999, 999, 999 };
        this.versusWins = 0;
        this.versusLosses = 0;
        this.multiWins = 0;
        this.multiLosses = 0;
        this.isLeader = false;
        this.isChampion = false;
    }

    // level: 1, 2, 3 -> index: 0, 1, 2
    public int getSingleBestScore(int level) {
        return this.singleBestScores[level - 1];
    }

    public int getVersusBestScore(int level) {
        return this.versusBestScores[level - 1];
    }

    public void setSingleBestScore(int level, int tries) {
        int index = level - 1;
        if (tries < this.singleBestScores[index]) {
            printNewRecord(this.singleBestScores[index], tries);
            this.singleBestScores[index] = tries;
        }
    }

    public void setVersusBestScore(int level, int tries) {
        int index = level - 1;
        if (tries < this.versusBestScores[index]) {
            printNewRecord(this.versusBestScores[index], tries);
            this.versusBestScores[index] = tries;
        }
    }

    private void printNewRecord(int oldScore, int newScore) {
        if (oldScore == 999) {
            System.out.println("New record! " + newScore + " tries. Congratulations!");
        } else {
            System.out.println("New record! Previous: " + oldScore + ", New: " + newScore);
        }
    }

    public void printScores() {

        System.out.print("=== " + getNickname());
        if (getIsChampion() && getIsLeader()) System.out.print(" [MISTRZ LIDER]");
        else if (getIsLeader()) System.out.print(" [LIDER]");
        else if (getIsChampion()) System.out.print(" [MISTRZ]");
        System.out.println(" ===");

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

        // Multiplayer wins/losses
        System.out.println(
                "Multiplayer record: " + getMultiWins() + " wins / " + getMultiLosses() + " losses");
    }

    public void addVersusWin() {
        this.versusWins++;
    }

    public void addVersusLoss() {
        this.versusLosses++;
    }

    public void addMultiWin() {
        this.multiWins++;
    }

    public void addMultiLoss() {
        this.multiLosses++;
    }

    public int getVersusWins() {
        return this.versusWins;
    }

    public int getVersusLosses() {
        return this.versusLosses;
    }

    public int getMultiWins() {
        return this.multiWins;
    }

    public int getMultiLosses() {
        return this.multiLosses;
    }

    public boolean getIsLeader() {
        return this.isLeader;
    }

    public boolean getIsChampion() {
        return this.isChampion;
    }

    public int getMultiWinRatio() {
        if (getMultiWins() + getMultiLosses() == 0) {
            return 0;
        }
        // najpierw mnożymy, żeby uniknąć problemów z dzieleniem całkowitym integer division czy coś takiego
        return getMultiWins()*100 / (getMultiWins() + getMultiLosses());
    }

    public String getNickname() {
        return this.nickname;
    }

    // Do odczytu z pliku
    public void setVersusWins(int wins) {
        this.versusWins = wins;
    }

    public void setVersusLosses(int losses) {
        this.versusLosses = losses;
    }

    public void setSingleScore(int level, int score) {
        this.singleBestScores[level - 1] = score;
    }

    public void setVersusScore(int level, int score) {
        this.versusBestScores[level - 1] = score;
    }

    public void setMultiWins(int wins) {
        this.multiWins = wins;
    }

    public void setMultiLosses(int losses) {
        this.multiLosses = losses;
    }

    public void setIsLeader(boolean isLeader) {
        this.isLeader = isLeader;
    }

    public void setIsChampion(boolean isChampion) {
        this.isChampion = isChampion;
    }

}