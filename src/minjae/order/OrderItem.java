package minjae.order;

import minjae.product.Product;

public class OrderItem {

    private Product product;

    private int quantity;

    private int price; // 주문 당시 Price 가격


    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice();
    }

    public int totalOrderItemPrice() {
        return quantity * price;
    }

    // 구매 시, Product 재고 감소
    public void decreaseProductStock() {
        product.decreaseStock(quantity);
    }
}
