package designPattern.observerPattern;

public interface Observer {
    void updateInfo(DataBody dataBody);
    void Observer(Subjector subjector);
    void addSubject(Subjector subjector);
    void cancelSubject(Subjector subjector);
    void display();
}
