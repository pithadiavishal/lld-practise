package lld.designpatterns.strategy;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public double executeStrategy(double d1,double d2){
        return strategy.calculate(d1,d2);
    }
}
