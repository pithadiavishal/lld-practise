package lld.designpatterns.decorator.pizza;

public class PizzaDecoratorApplication {
    public static void main(String[] args) {
        Pizza pizza = new TomatoDecorator(new CheeseDecorator(new FarmHousePizza()));
        System.out.println(pizza.getPrice());
        System.out.println(pizza.type());
    }
}
