package lld.designpatterns.observer;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer1 = new Observer1(subject);
        Observer observer2 = new Observer2(subject);
        subject.updateState(1);
    }
}
