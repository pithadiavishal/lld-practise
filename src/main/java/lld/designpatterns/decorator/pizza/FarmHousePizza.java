package lld.designpatterns.decorator.pizza;

public class FarmHousePizza implements Pizza{

    @Override
    public int getPrice() {
        return 120;
    }

    @Override
    public String type() {
        return "farmhouse";
    }
}
