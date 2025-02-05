package lld.designpatterns.decorator.pizza;

public class CornPizza implements Pizza{
    @Override
    public int getPrice() {
        return 110;
    }

    @Override
    public String type() {
        return "corm";
    }
}
