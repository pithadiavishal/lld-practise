package lld.designpatterns.strategy;

public class StrategyMain {

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println(context.executeStrategy(1.0,2.0));

        context = new Context(new OperationMultiply());
        System.out.println(context.executeStrategy(1.0,2.0));
    }
}
