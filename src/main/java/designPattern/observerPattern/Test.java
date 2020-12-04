package designPattern.observerPattern;


/**
 * @author huangtengfei
 * @description
 * @time 2020/11/12 14:06
 */
public class Test {
    public static void main(String[] args) {
        // 初始化
        DataBody dataBody=new DataBody(12,15,24);
        Subjector weatherSubject=new Subjector(dataBody);
        ObserverA observerA=new ObserverA();
        observerA.addSubject(weatherSubject);
        Observer observerB=new ObserverB();
        Observer observerC=new ObserverC();
        // 初始订阅
        System.out.println("======初始订阅=======");
        weatherSubject.addObserver(observerA);
        weatherSubject.addObserver(observerB);
        weatherSubject.addObserver(observerC);
        // 变更信息
        System.out.println("======变更信息=======");
        weatherSubject.setDataBody(new DataBody(22,25,34));
        // 删除订阅
        System.out.println("======删除订阅=======");
        weatherSubject.deleteObserver(observerB);
        weatherSubject.setDataBody(new DataBody(22,25,19));
        weatherSubject.setDataBody(new DataBody(22,25,36));
        weatherSubject.deleteObserver(new ObserverD());
        System.out.println("======取消主题=======");
        observerA.cancelSubject(weatherSubject);
        weatherSubject.setDataBody(new DataBody(42,45,46));
    }
}
