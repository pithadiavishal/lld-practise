package lld.designpatterns.observer;

public class Observer1 extends Observer {
    public Observer1(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("observer1 - updated state of the subject is: " + subject.getState());
    }
}
