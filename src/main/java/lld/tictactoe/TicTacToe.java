package lld.tictactoe;

import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    Deque<Player> players;
    Board board;

    public TicTacToe(int size, Deque<Player> players){
        board = new Board(size);
        this.players = players;
    }
    public String startGame(){
        boolean noWinner=true;
        while(noWinner){
            board.printBoard();
            Player currentPlayer = players.remove();
            if(board.isBoardFull()){
                noWinner=false;
                continue;
            }
            Scanner sc = new Scanner(System.in);
            String[] input = sc.nextLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            boolean res = board.set(r, c, currentPlayer.playingPiece);
            if(res){
                players.addLast(currentPlayer);
            }else{
                System.out.println("invalid position pls try again");
                players.addFirst(currentPlayer);
                continue;
            }
            if(board.isWinner(currentPlayer.playingPiece)){
                return currentPlayer.name;
            }
        }
        return "tie";
    }

}
