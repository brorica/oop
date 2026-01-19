package discount;

import static validator.Validator.CHECK_NOT_MINUS;

public class NoDiscount {

    public NoDiscount() {

    }

    public int discount(int itemPrice) {
        return CHECK_NOT_MINUS(itemPrice);
    }
}
