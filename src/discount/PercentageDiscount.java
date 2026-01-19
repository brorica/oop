package discount;

import static validator.Validator.CHECK_NOT_MINUS;

public class PercentageDiscount implements DisCountable {

    int disCountPercent;

    public PercentageDiscount(int percent) {
        if (percent > 100) {
            throw new IllegalArgumentException("할인률은 100%을 넘을 수 없습니다.");
        }
        this.disCountPercent = CHECK_NOT_MINUS(percent, "할인률은 음수가 될 수 없습니다.");

    }

    // 소숫점은 버린다.
    @Override
    public int discount(int itemPrice) {
        return itemPrice * disCountPercent / 100;
    }
}
