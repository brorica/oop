package discount;

import static validator.Validator.CHECK_NOT_MINUS;

public class ConditionalDiscount implements DisCountable {

    int discountPrice;
    int minimumPrice;

    public ConditionalDiscount(int discountPrice, int minimumPrice) {
        this.discountPrice = CHECK_NOT_MINUS(discountPrice);
        this.minimumPrice = CHECK_NOT_MINUS(minimumPrice);
    }

    @Override
    public int discount(int itemPrice) {
        if (itemPrice < minimumPrice) {
            throw new IllegalArgumentException("할인 조건을 만족하지 못합니다. 최소 금액: " + minimumPrice);
        }
        return Math.max(itemPrice - discountPrice, 0);
    }
}
