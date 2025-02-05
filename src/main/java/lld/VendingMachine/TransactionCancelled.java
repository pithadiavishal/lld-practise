package lld.VendingMachine;

public class TransactionCancelled implements State {

    private VendingMachine vendingMachine;

    public TransactionCancelled(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {

        throw new RuntimeException("Unable to collect cash in a cancelled transaction");
    }

    @Override
    public void dispenseChange(String productCode) {

        throw new RuntimeException("Unable to dispense change in a cancelled transaction");
    }

    @Override
    public void dispenseItem(String productCode) {

        throw new RuntimeException("Unable to dispense item in a cancelled transaction");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Returning collected cash" + vendingMachine.getCollectedCash());
        vendingMachine.setCollectedCash(0);
        vendingMachine.setState(new Ready(vendingMachine));
    }
}

