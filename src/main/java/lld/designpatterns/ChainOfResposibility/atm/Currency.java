package lld.designpatterns.ChainOfResposibility.atm;

public class Currency {

    private final int amount;

    public Currency(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
