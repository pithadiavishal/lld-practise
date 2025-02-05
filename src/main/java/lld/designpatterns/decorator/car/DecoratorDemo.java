package lld.designpatterns.decorator.car;

public class DecoratorDemo {

    public static void main(String[] args) {
        Car sportCar = new SportsCar(new BasicCar());
        sportCar.assemble();

        Car luxuryCar = new LuxuryCar(new SportsCar(new BasicCar()));
        luxuryCar.assemble();
    }
}
