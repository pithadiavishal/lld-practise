package lld.stockbrokerage;

import java.util.List;

public class WatchList {
    private StockInventory stockInventory;
    String name;
    List<Stock> stocks;


    //belongs to account
    Account account;

    public void addStock(Stock stock){
        stocks.add(stock);
    }
    public void removeStock(Stock stock){
        stocks.remove(stock);
    }
    public List<Stock> view(){
        return stockInventory.getStocks();
    }
}
