package lld.VendingMachine;

public class MainClass {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        State currState;
        vendingMachine.setState(new Ready(vendingMachine));
        currState = vendingMachine.getState();
        currState.collectCash(25);
        currState.dispenseChange("101");

    }
}
