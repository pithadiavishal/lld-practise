package lld.tictactoe;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("first", new PlayingPieceO());
        Player player2 = new Player("second", new PlayingPieceX());
        Deque<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        TicTacToe ticTacToe = new TicTacToe(3, players);
        System.out.println(ticTacToe.startGame());
    }
}
