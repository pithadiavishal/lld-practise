package lld.snakeladder;

public class SnakeLadderApplication {
    public static void main(String[] args) {
        Game game = new Game(100, 5, 5);
        Player firstPlayer = new Player("first player");
        Player secondPlayer = new Player("second player");
        game.addPlayer(firstPlayer);
        game.addPlayer(secondPlayer);
        game.play();
    }
}
