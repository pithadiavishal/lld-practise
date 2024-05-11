package lld.stockbrokerage;

import java.util.List;

public class Account {
    String id;
    String name;
    String password;
    String phone;
    String email;
    Address address;
    AccountStatus status;

    List<WatchList> watchLists;

    List<Order> orderLists;

    List<StockPosition> stockPositions;

    Statement statement;
}
