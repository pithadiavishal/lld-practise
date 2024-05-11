package lld.fooddelivery.strategy;

import lld.fooddelivery.model.Bill;
import lld.fooddelivery.model.CouponCode;
import lld.fooddelivery.model.MenuItem;

import java.util.List;


public interface PricingStrategy {
    Bill generateBill(List<MenuItem> menuItemList);

    boolean isApplicable(CouponCode couponCode);
}
