package lld.designpatterns.ChainOfResposibility.atm;

import java.util.Scanner;

public class ATMDispense {

    private final DispenseChain dispenseChain;

    public ATMDispense() {
        this.dispenseChain = new Dollar50Dispenser();
        DispenseChain d20 = new Dollar20Dispenser();
        DispenseChain d10 = new Dollar10Dispenser();

        this.dispenseChain.setNextChain(d20);
        d20.setNextChain(d10);
    }

    public static void main(String[] args) {
        ATMDispense atmDispense = new ATMDispense();

        while (true){
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if(amount % 10 != 0) {
                System.out.println("amount must in multiple of 10");
                return;
            }
            atmDispense.dispenseChain.dispense(new Currency(amount));
        }
    }
}
