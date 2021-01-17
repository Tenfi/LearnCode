package designPattern.decoratorPattern;

public class ComponentBody implements Component {
    public ComponentBody() {
        System.out.println("实例化主体！");
    }

    @Override
    public void operation() {
        System.out.println("主体执行操作！");
    }
}
