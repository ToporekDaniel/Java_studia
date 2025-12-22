package max.vanach.lesson_1;


public class GameVersus {
    private Game playerGame;
    private GameReverse computerGame;

    public GameVersus(int level) {
        playerGame = new Game(level);
        computerGame = new GameReverse(level);
    }



}