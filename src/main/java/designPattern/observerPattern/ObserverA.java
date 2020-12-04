package designPattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtengfei
 * @description
 * @time 2020/11/12 14:23
 */
public class ObserverA extends ObserverModel{

    @Override
    public void display() {
        System.out.println("A订阅了：温度="+this.getDataBody().getTemperture()+",时间="+this.getDataBody().getTime());
    }
}
