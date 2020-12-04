package designPattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

abstract class ObserverModel implements Observer{
    private DataBody dataBody;
    private List<Subjector> subjectors=new ArrayList<>();

    @Override
    public void addSubject(Subjector subjector) {
        subjectors.add(subjector);
        System.out.println("添加了主题:"+subjector.getClass().getName());
    }

    @Override
    public void updateInfo(DataBody dataBody) {
        this.dataBody=dataBody;
        display();
    }

    @Override
    public void Observer(Subjector subjector) {
        subjectors.add(subjector);
    }

    @Override
    public void cancelSubject(Subjector subjector) {
        int index=subjectors.indexOf(subjector);
        // 当subjectors中没有时，index=-1
        if(index>=0){
            subjectors.remove(subjector);
            subjector.deleteObserver(this);
            System.out.println("删除了主题:"+subjector.getClass().getName());
        }
    }

    @Override
    public void display() {
    }

    public DataBody getDataBody() {
        return dataBody;
    }

    public void setDataBody(DataBody dataBody) {
        this.dataBody = dataBody;
    }

    public List<Subjector> getSubjectors() {
        return subjectors;
    }

    public void setSubjectors(List<Subjector> subjectors) {
        this.subjectors = subjectors;
    }
}
