package lld.VendingMachine;

public class Ready implements State {
    private VendingMachine vendingMachine;

    public Ready(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override

    public void collectCash(int cash) {
        this.vendingMachine.addCollectedCash(cash);

    }

    @Override

    public void dispenseChange(String productCode) {
        this.vendingMachine.setState(new DispenseChange(this.vendingMachine));
        this.vendingMachine.dispenseChange(productCode);

    }

    @Override
    public void dispenseItem(String productCode) {
        throw new RuntimeException("Txn not initiated.Unable to dispense item");
    }

    @Override

    public void cancelTransaction() {
        this.vendingMachine.setState(new TransactionCancelled(vendingMachine));
        this.vendingMachine.cancelTransaction();
    }
}