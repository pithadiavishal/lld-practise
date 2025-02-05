package lld.designpatterns.ChainOfResposibility.atm;

public class Dollar20Dispenser implements DispenseChain{
    private DispenseChain dispenseChain;

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 20) {
            int num20Denominations = currency.getAmount() / 20;
            int remainderAmount = currency.getAmount() % 20;
            System.out.println("Dispensing " + num20Denominations + " 20$ note");
            if(remainderAmount!=0) this.dispenseChain.dispense(new Currency(remainderAmount));
        } else
            this.dispenseChain.dispense(currency);
    }

    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.dispenseChain = dispenseChain;
    }
}
