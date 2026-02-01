package minjae.discount;

import static minjae.validator.Validator.CHECK_NOT_MINUS;

public class FixedAmountDiscount implements DisCountPolicy {

    int discountPrice;

    public FixedAmountDiscount(int price) {
        this.discountPrice = CHECK_NOT_MINUS(price, "할인은 음수가 될 수 없습니다.");
    }

    @Override
    public int discount(int itemPrice) {
        int result = itemPrice - discountPrice;
        return Math.max(result, 0);
    }
}
