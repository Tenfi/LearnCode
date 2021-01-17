package designPattern.decoratorPattern;

public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component=component;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
