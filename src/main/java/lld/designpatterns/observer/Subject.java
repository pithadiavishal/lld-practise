package lld.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;
    public void attach(Observer observer){
        observers.add(observer);
    }
    private void notifyAllObserver(){
        for(Observer observer: observers){
            observer.update();
        }
    }
    public void updateState(int state){
        this.state = state;
        this.notifyAllObserver();
    }
    public int getState(){
        return this.state;
    }
}
