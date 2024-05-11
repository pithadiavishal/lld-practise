package lld.fooddelivery.services;

import lld.fooddelivery.datastore.FoodMenuData;
import lld.fooddelivery.exceptions.ExceptionType;
import lld.fooddelivery.exceptions.FoodDeliveryException;
import lld.fooddelivery.model.CuisineType;
import lld.fooddelivery.model.FoodMenu;
import lld.fooddelivery.model.MealType;
import lld.fooddelivery.model.MenuItem;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodMenuService {
    private FoodMenuData foodMenuData;

    @Autowired
    public FoodMenuService(FoodMenuData foodMenuData) {
        this.foodMenuData = foodMenuData;
    }

    public void addMenuByRestaurantId(@NonNull final String menuId, @NonNull final String restaurantId,
                                      @NonNull final List<MenuItem> menuItemList) {
        if (foodMenuData.getFoodMenuIdByRestaurantId().containsKey(restaurantId)) {
            throw new FoodDeliveryException(ExceptionType.MENU_ALREADY_EXISTS, "Menu Already exists for this " +
                    "restaurant");
        }
        FoodMenu foodMenu = foodMenuData.getFoodMenuById().getOrDefault(menuId,
                new FoodMenu(menuId, new ArrayList<>(), menuItemList));
        foodMenu.getRestaurantIds().add(restaurantId);
        foodMenuData.getFoodMenuById().put(menuId, foodMenu);
        foodMenuData.getFoodMenuIdByRestaurantId().put(restaurantId, menuId);
        for (MenuItem menuItem : menuItemList) {
            foodMenuData.getMenuItemById().put(menuItem.getId(), menuItem);
        }
    }

    public FoodMenu getMenuById(@NonNull final String menuId) {
        if (!foodMenuData.getFoodMenuById().containsKey(menuId)) {
            throw new FoodDeliveryException(ExceptionType.MENU_NOT_FOUND, "Food Menu not exists");
        }
        return foodMenuData.getFoodMenuById().get(menuId);
    }

    public FoodMenu getMenuByRestaurantId(@NonNull final String restaurantId) {
        if (!foodMenuData.getFoodMenuIdByRestaurantId().containsKey(restaurantId)) {
            throw new FoodDeliveryException(ExceptionType.MENU_NOT_FOUND, "Food Menu not exists");
        }
        return getMenuById(foodMenuData.getFoodMenuIdByRestaurantId().get(restaurantId));
    }

    public void addMenuItemsByMenuId(@NonNull final String menuId, @NonNull final List<MenuItem> menuItemList) {
        for (MenuItem menuItem : menuItemList) {
            foodMenuData.getMenuItemById().put(menuItem.getId(), menuItem);
        }
        getMenuById(menuId).getMenuItemList().addAll(menuItemList);
    }

    public void addMenuItemsByRestaurantId(@NonNull final String restaurantId,
                                           @NonNull final List<MenuItem> menuItemList) {
        for (MenuItem menuItem : menuItemList) {
            foodMenuData.getMenuItemById().put(menuItem.getId(), menuItem);
        }
        getMenuByRestaurantId(restaurantId).getMenuItemList().addAll(menuItemList);
    }

    public List<MenuItem> getMenuItemsByRestaurantIdAndCuisine(@NonNull final String restaurantId,
                                                               @NonNull final CuisineType cuisineType) {
        FoodMenu foodMenu = getMenuByRestaurantId(restaurantId);
        return foodMenu.getMenuItemList().stream().filter(menuItem -> menuItem.getCuisineType() == cuisineType)
                .collect(Collectors.toList());
    }

    public List<MenuItem> getMenuItemsByRestaurantIdAndMealType(@NonNull final String restaurantId,
                                                                @NonNull final MealType mealType) {
        FoodMenu foodMenu = getMenuByRestaurantId(restaurantId);
        return foodMenu.getMenuItemList().stream().filter(menuItem -> menuItem.getMealType() == mealType)
                .collect(Collectors.toList());
    }

    public MenuItem getMenuItemById(@NonNull final String itemId) {
        if (!foodMenuData.getMenuItemById().containsKey(itemId)) {
            throw new FoodDeliveryException(ExceptionType.MENU_ITEM_NOT_FOUND, "Menu Item not found");
        }
        return foodMenuData.getMenuItemById().get(itemId);
    }
}
