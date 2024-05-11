package lld.snakeladder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String playerName;
    private boolean isWinner;
    private int currPosition;
    public Player(String playerName){
        this.playerName = playerName;
        this.isWinner = false;
        this.currPosition = 0;
    }
}
