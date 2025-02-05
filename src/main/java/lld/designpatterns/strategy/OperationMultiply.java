package lld.designpatterns.strategy;

public class OperationMultiply implements Strategy{
    @Override
    public double calculate(double d1, double d2) {
        return d1*d2;
    }
}
