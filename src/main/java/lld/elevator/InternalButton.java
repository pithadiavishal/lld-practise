package lld.elevator;

public class InternalButton {
    InternalButtonDispatcher internalButtonDispatcher;
    ElevatorCar elevatorCar;
    public void pressButton(int destinationFloor, Direction direction){
        internalButtonDispatcher.acceptRequest(elevatorCar.id, destinationFloor,  direction);
    }
}
