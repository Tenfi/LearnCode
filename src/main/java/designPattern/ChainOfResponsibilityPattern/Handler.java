package designPattern.ChainOfResponsibilityPattern;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/26 14:53
 */

//抽象处理者角色
abstract class Handler {
    private Handler next;
    public void setNext(Handler next) {
        this.next = next;
    }
    public Handler getNext() {
        return next;
    }
    //处理请求的方法
    public abstract void handleRequest(String request);
}