package lld.fooddelivery.datastore;

import lld.fooddelivery.model.Payment;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class PaymentData {
    private Map<String, Payment> paymentById = new HashMap<>();
    private Map<String, String> paymentIdByOrderId = new HashMap<>();
}
