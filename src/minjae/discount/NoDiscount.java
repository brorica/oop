package minjae.discount;

import static minjae.validator.Validator.CHECK_NOT_MINUS;

public class NoDiscount implements DisCountable{

    public NoDiscount() {

    }

    @Override
    public int discount(int itemPrice) {
        return CHECK_NOT_MINUS(itemPrice);
    }
}
