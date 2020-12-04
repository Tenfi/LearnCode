package designPattern.observerPattern;

public interface Subject {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void updateObservers();
}
