package lld.designpatterns.decorator.pizza;

public class CheeseDecorator extends PizzaDecorator{
    protected CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getPrice() {
        return 20 + pizza.getPrice();
    }

    @Override
    public String type() {
        return pizza.type() + ", cheese topping";
    }
}
