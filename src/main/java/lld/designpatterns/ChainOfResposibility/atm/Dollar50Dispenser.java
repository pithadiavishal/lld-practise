package lld.designpatterns.ChainOfResposibility.atm;

public class Dollar50Dispenser implements DispenseChain {

    private DispenseChain dispenseChain;

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 50) {
            int num50Denominations = currency.getAmount() / 50;
            int remainderAmount = currency.getAmount() % 50;
            System.out.println("Dispensing " + num50Denominations + " 50$ note");
            if(remainderAmount!=0) this.dispenseChain.dispense(new Currency(remainderAmount));
        } else
            this.dispenseChain.dispense(currency);
    }

    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.dispenseChain = dispenseChain;
    }
}
