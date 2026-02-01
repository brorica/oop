package minjae.order;

import minjae.cart.CartItemMap;

import java.util.ArrayList;
import java.util.List;

public class OrderItemList {

    private List<OrderItem> orderItemList = new ArrayList<>(16);

    public OrderItemList(CartItemMap cartItemMap) {
        cartItemMap.getCartItemMap().forEach((product, cartItem) -> {
            OrderItem orderItem = new OrderItem(product, cartItem.getQuantity());
            orderItemList.add(orderItem);
        });
    }

    public int getTotalPrice() {
        int sum = 0;
        for (OrderItem orderItem : orderItemList) {
            sum += orderItem.totalOrderItemPrice();
        }
        return sum;
    }

    // 구매 및 리스트 초기화
    public void buyItemList() {
        for (OrderItem orderItem : orderItemList) {
            orderItem.decreaseProductStock();
        }
        orderItemList.clear();
    }
}
