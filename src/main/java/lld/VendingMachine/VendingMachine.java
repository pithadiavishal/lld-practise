package lld.VendingMachine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VendingMachine {
    private int collectedCash;
    private State state;
    private Map<String, Set<String>> productCodeItemMap;
    private Map<String, Integer> productCodePriceMap;

    public VendingMachine() {
        productCodePriceMap = new HashMap<>();
        productCodePriceMap.put("101", 10);
        productCodePriceMap.put("102", 20);
        productCodePriceMap.put("103", 30);
        Set<String> set = new HashSet<>();
        // unique id of item
        set.add("1");
        set.add("1");
        set.add("1");
        productCodeItemMap = new HashMap<>();
        productCodeItemMap.put("101", set);
        productCodeItemMap.put("102", set);
        productCodeItemMap.put("103", set);
    }

    public void addCollectedCash(int collectedCash) {
        this.collectedCash += collectedCash;
    }

    public VendingMachine setCollectedCash(int collectedCash) {
        this.collectedCash = collectedCash;
        return this;
    }

    public State getState() {
        return state;
    }

    public VendingMachine setState(State state) {
        this.state = state;
        return this;
    }

    public void removeProduct(String productCode) {
        productCodeItemMap.get(productCode).remove(productCodeItemMap.get(productCode).iterator().next());
    }

    public void dispenseChange(String productCode) {
        this.state.dispenseChange(productCode);
    }

    public void cancelTransaction() {
        this.state.cancelTransaction();
    }

    public int calculateChange(String productCode) {
        return collectedCash - productCodePriceMap.get(productCode);
    }

    public void dispenseItem(String productCode) {
        this.state.dispenseItem(productCode);
    }

    public int getCollectedCash() {
        return collectedCash;
    }
}