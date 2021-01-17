package designPattern.decoratorPattern;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Component component = new ComponentBody();
        component.operation();

        Decorator decorator =new DecoratorBody(component);
        decorator.operation();
    }
}
