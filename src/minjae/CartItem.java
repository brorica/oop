package minjae;

import static minjae.validator.Validator.CHECK_NOT_MINUS;

public class CartItem {
    private Product product;

    private int quantity;

    public CartItem(Product product) {
        this(product, 1);
    }

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * 개수 더하기
     * @param quantity
     */
    public void addQuantity(int quantity) {
        CHECK_NOT_MINUS(quantity);
        long sum = (long)this.quantity + quantity;
        if (sum > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("수량 허용 범위 초과: 현재 = " + this.quantity + "요청 = " + quantity);
        }

        this.quantity += quantity;
    }

    /**
     * 개수 감소
     */
    public int decreaseQuantity(int quantity) {
        CHECK_NOT_MINUS(quantity);
        if (this.quantity < quantity) {
            throw new IllegalArgumentException("현재 수량보다 더 감소할 수 없습니다.");
        }
        this.quantity -= quantity;
        return this.quantity;
    }

    public int getTotalPrice() {
        long sum = (long) quantity * this.product.getPrice();
        if (sum > Integer.MAX_VALUE) {
            throw new RuntimeException("금액 초과 = " + sum + "원");
        }

        return (int)sum;
    }

    /**
     * 물건을 사는걸 확정하면 재고를 감소
     */
    public void buy() {
        this.product.decreaseStock(this.quantity);
        System.out.println(
            "ID = " + this.product.getId() +
            " Name = " + this.product.getName() +
            " " + this.product.getStock() + "개" +
            " " + this.quantity + "만큼 차감"
        );
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
