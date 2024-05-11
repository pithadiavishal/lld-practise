package lld.snakeladder;

import java.util.Random;

public class Dice {
    private int max;
    public Dice(int max){
        this.max = max;
    }

    public int roll(){
        return RandomUtils.getRandom(max);
    }
}
