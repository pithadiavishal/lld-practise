package lld.designpatterns.decorator.pizza;

public class TomatoDecorator extends PizzaDecorator{

    protected TomatoDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getPrice() {
        return 10 + pizza.getPrice();
    }

    @Override
    public String type() {
        return pizza.type() + ", tomato topping";
    }
}
