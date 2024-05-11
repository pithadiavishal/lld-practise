package lld.snakeladder;

import java.util.*;

public class Game {
    private Board board;
    private Dice dice;
    private Map<Integer, Snake> snakes;
    private Map<Integer, Ladder> ladders;
    private Queue<Player> players;


    public Game(int boardSize, int noOfLadders, int noOfSnakes){
        this.board = new Board(boardSize);
        this.dice = new Dice(6);
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        this.players = new LinkedList<>();
        init(boardSize, noOfLadders, noOfSnakes);
    }
    public void addPlayer(Player player){
        players.offer(player);
    }
    public void play(){
        while (true){
            Player curPlayer = players.remove();
            int steps = dice.roll();
            System.out.println("player name: " + curPlayer.getPlayerName() + " steps: " + steps);
            if(curPlayer.getCurrPosition()+steps>board.getEnd()){
                // the player will win only if currPos+steps=board.end
                System.out.println("player name: " + curPlayer.getPlayerName() + " curr position exceeds boars size " + (curPlayer.getCurrPosition()+steps));
                players.offer(curPlayer);
            }else{
                int position = getPosition(curPlayer.getCurrPosition()+steps);
                curPlayer.setCurrPosition(position);
                System.out.println("player name: " + curPlayer.getPlayerName() + " curr position: " + curPlayer.getCurrPosition());
                if(position==board.getEnd()){
                    curPlayer.setWinner(true);
                    System.out.println("player won " + curPlayer.getPlayerName());
                }else{
                    players.offer(curPlayer);
                }
            }
            if(players.size()<2){
                break;
            }
        }
    }

    private void init(int boardSize, int noOfLadders, int noOfSnakes) {
        createLadders(boardSize, noOfLadders);
        createsSnakes(boardSize, noOfSnakes);
    }

    private void createsSnakes(int boardSize, int noOfSnakes) {
        for(int i=0;i<noOfSnakes;i++){
            while(true){
                int start = RandomUtils.getRandom(boardSize);
                int end = RandomUtils.getRandom(boardSize);
                if(end>start){
                    continue;
                }
                if(!snakes.containsKey(start)){
                    Snake snake = new Snake(start, end);
                    snakes.put(start, snake);
                    break;
                }
            }
        }
    }

    private void createLadders(int boardSize, int noOfLadders) {
        for(int i=0;i<noOfLadders;i++){
            while(true){
                int start = RandomUtils.getRandom(boardSize);
                int end = RandomUtils.getRandom(boardSize);
                if(start>end){
                    continue;
                }
                if(!snakes.containsKey(start)&&!ladders.containsKey(start)){
                    Ladder ladder = new Ladder(start, end);
                    ladders.put(start, ladder);
                    break;
                }
            }
        }
    }

    private int getPosition(int newPosition){
        if(snakes.containsKey(newPosition)){
            return snakes.get(newPosition).getTail();
        }
        if(ladders.containsKey(newPosition)){
            return ladders.get(newPosition).getEnd();
        }
        return newPosition;
    }
}
