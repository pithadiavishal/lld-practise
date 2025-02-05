package lld.VendingMachine;


public class DispenseItem implements State {

    private final VendingMachine vendingMachine;

    public DispenseItem(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        throw new RuntimeException("Dispensing item.Unable to collect cash");
    }

    @Override
    public void dispenseChange(String productCode) {

        throw new RuntimeException("Dispensing item.Unable to dispense change");
    }

    @Override

    public void dispenseItem(String productCode) {
        vendingMachine.removeProduct(productCode);
        System.out.println("Dispensing item " + productCode);
        vendingMachine.setState(new Ready(this.vendingMachine));
    }

    @Override
    public void cancelTransaction() {

        throw new RuntimeException("Dispensing item.Unable to cancel the Transaction");
    }
}
