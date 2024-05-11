package lld.stockbrokerage;

import java.util.Date;
import java.util.List;

public class Order {
    String id;
    Stock stock;
    OrderStatus orderStatus;
    boolean isBuyOrder;
    Date createdAt;
    Date enforcementTime;
    StockLot stockLot;
    List<OrderPart> orderPartList;
}
