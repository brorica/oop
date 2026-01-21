package minjae.discount;

import static minjae.validator.Validator.CHECK_NOT_MINUS;

public class PercentageDiscount implements DisCountable {

    int discountRate;

    public PercentageDiscount(int percent) {
        if (percent > 100) {
            throw new IllegalArgumentException("할인률은 100%을 넘을 수 없습니다.");
        }
        this.discountRate = CHECK_NOT_MINUS(percent, "할인률은 음수가 될 수 없습니다.");

    }

    // 소숫점은 버린다.
    @Override
    public int discount(int itemPrice) {
        return (int) ((long) itemPrice * discountRate / 100);
    }
}
