package lld.designpatterns.observer;

public class Observer2 extends Observer{
    public Observer2(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("observer2 - updated state of the subject is: " + subject.getState());
    }
}
