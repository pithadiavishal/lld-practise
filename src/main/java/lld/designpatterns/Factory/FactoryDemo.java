package lld.designpatterns.Factory;

public class FactoryDemo {
    public static void main(String[] args) {

        ShapeFactory shapeFactory = new RectangleFactory();
        Shape shape = shapeFactory.createShape();
        shape.draw();

        shapeFactory = new SquareFactory();
        shape = shapeFactory.createShape();
        shape.draw();
    }
}
