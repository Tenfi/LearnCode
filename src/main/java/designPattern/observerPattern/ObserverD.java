package designPattern.observerPattern;

/**
 * @author huangtengfei
 * @description
 * @time 2020/11/12 14:23
 */
public class ObserverD extends ObserverModel{
    @Override
    public void display() {
        System.out.println("D订阅了：温度="+this.getDataBody().getTemperture()+"，湿度="+this.getDataBody().getHumidity()+",时间="+this.getDataBody().getTime());
    }
}
