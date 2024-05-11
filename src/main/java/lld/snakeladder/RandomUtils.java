package lld.snakeladder;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();
    public static int getRandom(int max){
        return 1+random.nextInt(max);
    }
}
