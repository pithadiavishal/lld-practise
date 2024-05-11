package lld.stockbrokerage;

import java.util.List;

public class StockInventory {
    private StockExchange stockExchange;

    public List<Stock> getStocks(){
        return stockExchange.fetchStockDetails();
    }
}
