package minjae.order;

import minjae.Customer;
import minjae.cart.CartItemMap;
import minjae.discount.DisCountPolicy;

public class Order {

    private Customer customer;

    private OrderItemList orderItemList;

    public Order(Customer customer, CartItemMap cartItemMap) {
        this.customer = customer;
        this.orderItemList = new OrderItemList(cartItemMap);
    }

    // 할인 적용 후 최종 금액 계산
    public int totalOrderPrice(DisCountPolicy disCountPolicy) {
        int totalPrice = orderItemList.getTotalPrice();
        return disCountPolicy.discount(totalPrice);
    }

    // 주문 시, Product 재고 차감
    public void confirmOrder() {
        orderItemList.buyItemList();
    }


}
