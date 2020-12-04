package designPattern.observerPattern;

/**
 * @author huangtengfei
 * @description
 * @time 2020/11/12 14:23
 */
public class ObserverB extends ObserverModel{
    @Override
    public void display() {
        System.out.println("B订阅了：湿度="+this.getDataBody().getHumidity()+",时间="+this.getDataBody().getTime());
    }
}
