package lld.fooddelivery.commands;

import lld.fooddelivery.datastore.OrderData;
import lld.fooddelivery.model.Order;
import lld.fooddelivery.model.OrderCommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CancelOrderCommandExecutor extends OrderCommandExecutor {
    private OrderData orderData;

    @Autowired
    public CancelOrderCommandExecutor(OrderData orderData) {
        this.orderData = orderData;
    }

    @Override
    public boolean isValid(Order order) {
        if (!orderData.getOrderById().containsKey(order.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public void executeCommand(Order order) {
        order.markOrderCancelled();
    }

    @Override
    public boolean isApplicable(OrderCommandType orderCommandType) {
        return orderCommandType == OrderCommandType.CANCEL;
    }
}
