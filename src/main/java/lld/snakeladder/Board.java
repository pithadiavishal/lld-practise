package lld.snakeladder;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Board {
    private int start;
    private int end;
    public Board(int size){
        this.start=1;
        this.end=this.start+size-1;
    }
}
