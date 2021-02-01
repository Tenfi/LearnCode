package designPattern.ChainOfResponsibilityPattern;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/26 14:45
 */
public class ChainOfResponsibilityPatternTest {
    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        //提交请求
        handler1.handleRequest("two");



    }
}
