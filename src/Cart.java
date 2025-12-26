import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Customer customer;

    private Map<Product, CartItem> cartItemMap;

    /**
     * cartItem 추가
     * @param product Cart에 담길 Product
     */
    public void addCartItem(Product product) {
        if (cartItemMap.containsKey(product)) {
            throw new RuntimeException("이미 존재하는 Product 입니다.");
        }
        CartItem cartItem = new CartItem(product);
        cartItemMap.put(product, cartItem);
    }

    /**
     * cartItem 제거
     */
    public void removeCartItem(Product product) {
        CartItem cartItem = cartItemMap.get(product);
        if (cartItem == null) {
            throw new RuntimeException("해당 Product는 Cart에 없습니다.");
        }
        cartItemMap.remove(product);
    }

    /**
     * 수량 더하기
     */
    public void addItemQuantity(Product product, int count) {
        CartItem cartItem = cartItemMap.get(product);
        if (cartItem == null) {
            throw new RuntimeException("해당 Product는 Cart에 없습니다.");
        }
        cartItem.addQuantity(count);
    }

    /**
     * CartItem 수량 감소
     * 감소한 수량이 0이면 Cart에서 해당 CartItem 제거
     */
    public void decreaseItemQuantity(Product product, int count) {
        CartItem cartItem = cartItemMap.get(product);
        if (cartItem == null) {
            throw new RuntimeException("해당 Product는 Cart에 없습니다.");
        }

        // 재고가 0이면 CartItem 없앰
        if (cartItem.decreaseQuantity(count) <= 0) {
            cartItemMap.remove(product);
        }
    }


    public void clearAll() {
        cartItemMap.clear();
    }

    public int getTotalCost() {
        long sum = 0;
        for (CartItem cartItem : cartItemMap.values()) {
            sum += cartItem.getTotalPrice();
        }
        if (sum > Integer.MAX_VALUE) {
            throw new RuntimeException("금액 초과 = " + sum + "원");
        }
        return (int)sum;
    }

    public Cart(Customer customer) {
        this.customer = customer;
        this.cartItemMap = new HashMap<>(16);
    }
}
