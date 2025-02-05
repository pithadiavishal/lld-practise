package lld.designpatterns.ChainOfResposibility.atm;

public class Dollar10Dispenser implements DispenseChain {

    private DispenseChain dispenseChain;

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 10) {
            int num10Denominations = currency.getAmount() / 10;
            int remainderAmount = currency.getAmount() % 10;
            System.out.println("Dispensing " + num10Denominations + " 10$ note");
            if(remainderAmount!=0) this.dispenseChain.dispense(new Currency(remainderAmount));
        } else
            this.dispenseChain.dispense(currency);
    }

    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.dispenseChain = dispenseChain;
    }
}
