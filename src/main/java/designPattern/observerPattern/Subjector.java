package designPattern.observerPattern;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtengfei
 * @description
 * @time 2020/11/12 14:14
 */
public class Subjector implements Subject{
    private List<Observer> observers=new ArrayList<>();
    private DataBody dataBody;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        System.out.println("新增了订阅者:"+observer.getClass().getName());
        observer.updateInfo(dataBody);
    }

    @Override
    public void deleteObserver(Observer observer) {
        int index=observers.indexOf(observer);
        // 当observers中没有时，index=-1
        if(index>=0){
            observers.remove(observer);
            System.out.println("删除了订阅者:"+observer.getClass().getName());
        }
    }

    @Override
    public void updateObservers() {
        if (dataBody.getTime()>20){
            for (Observer observer:observers){
                observer.updateInfo(dataBody);
            }
        }
    }

    public Subjector(DataBody dataBody) {
        this.dataBody = dataBody;
    }

    public void setDataBody(DataBody dataBody){
        this.dataBody=dataBody;
        updateObservers();
    }
}
