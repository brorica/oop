package discount;

import static validator.Validator.CHECK_NOT_MINUS;

public class FixedAmountDiscount {

    int discountPrice;

    public FixedAmountDiscount(int price) {
        this.discountPrice = CHECK_NOT_MINUS(price, "할인은 음수가 될 수 없습니다.");
    }

    public int discount(int itemPrice) {
        int result = itemPrice - discountPrice;
        return CHECK_NOT_MINUS(result);
    }
}
