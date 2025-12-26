import java.util.HashSet;
import java.util.Set;

public class Cart {

    private Customer customer;

    private Set<CartItem> cartItemSet;

    public void addCartItem(Product product) {
        if (cartItemSet.contains(product)) {
            throw new RuntimeException("이미 존재하는 Product 입니다.");
        }
        CartItem cartItem = new CartItem(product);
        cartItemSet.add(cartItem);
    }

    public void removeCartItem(Product product) {
        if (cartItemSet.contains(product)) {
            throw new RuntimeException("해당 Product는 Cart에 없습니다.");
        }
        cartItemSet.remove(product);
    }

    public void clearAll() {
        cartItemSet.clear();
    }

    public int totalCost() {
        long sum = 0;
        for (CartItem cartItem : cartItemSet) {
            sum += cartItem.totalCost();
        }
        if (sum > Integer.MAX_VALUE) {
            throw new RuntimeException("금액 초과 = " + sum + "원");
        }
        return (int)sum;
    }

    public Cart(Customer customer) {
        this.customer = customer;
        this.cartItemSet = new HashSet<>(16);
    }
}
