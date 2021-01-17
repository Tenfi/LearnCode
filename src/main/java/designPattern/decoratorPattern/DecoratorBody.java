package designPattern.decoratorPattern;

public class DecoratorBody extends Decorator {
    public DecoratorBody(Component component) {
        super(component);
    }

    public void addFunc(){
        System.out.println("装饰器添加的操作！");
    }

    @Override
    public void operation() {
        super.operation();
        addFunc();
    }
}
