package lld.fooddelivery.commands;

import lld.fooddelivery.datastore.OrderData;
import lld.fooddelivery.model.Order;
import lld.fooddelivery.model.OrderCommandType;
import lld.fooddelivery.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaceOrderCommandExecutor extends OrderCommandExecutor {
    private OrderData orderData;

    @Autowired
    public PlaceOrderCommandExecutor(OrderData orderData) {
        this.orderData = orderData;
    }

    @Override
    public boolean isValid(Order order) {
        if (!(order.getOrderStatus() == OrderStatus.PENDING)) {
            return false;
        }
        return true;
    }

    @Override
    public void executeCommand(Order order) {
        orderData.getOrderById().put(order.getId(), order);
        List<String> orderIds = orderData.getOrderIdsByUserId().getOrDefault(order.getUserId(), new ArrayList<>());
        orderIds.add(order.getId());
        orderData.getOrderIdsByUserId().put(order.getUserId(), orderIds);
        order.markOrderWaitingForPayment();
    }

    @Override
    public boolean isApplicable(OrderCommandType orderCommandType) {
        return orderCommandType == OrderCommandType.PLACE;
    }
}
