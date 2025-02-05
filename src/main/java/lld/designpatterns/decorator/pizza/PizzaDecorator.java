package lld.designpatterns.decorator.pizza;

public abstract class PizzaDecorator implements Pizza{
    final Pizza pizza;

    protected PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}
