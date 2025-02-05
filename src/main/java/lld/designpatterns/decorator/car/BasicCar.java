package lld.designpatterns.decorator.car;

public class BasicCar implements Car{
    @Override
    public void assemble() {
        System.out.println("Basic car");
    }
}
