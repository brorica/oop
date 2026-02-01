package minjae.cart;

import minjae.Customer;
import minjae.order.Order;

public class Cart {

    private Customer customer;

    private CartItemMap cartItemMap;


    public Cart(Customer customer) {
        this.customer = customer;
        this.cartItemMap = new CartItemMap();
    }

    public CartItemMap getCartItemMap() {
        return cartItemMap;
    }

    public Order buildOrder() {
        return new Order(customer, cartItemMap);
    }
}
