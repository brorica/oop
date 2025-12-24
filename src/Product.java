public class Product {

    private final String id;
    private final String name;
    private final int price;
    private int stock;

    public Product(String id, String name, int price, int stock) {
        this.id = id;
        this.name = nameMin1AndMax100(name);
        this.price = priceCantMinus(price);
        this.stock = stock;
    }

    public int priceCantMinus(int price) {
        if (price < 0) {
            throw new RuntimeException("price 값은 음수가 될 수 없습니다.");
        }
        return price;
    }

    public String nameMin1AndMax100(String name) {
        if (name.length() > 100) {
            throw new RuntimeException("name 값은 1 ~ 100 사이의 글자여야 합니다.");
        }
        return name;
    }

    public int stockCantMinus(int stock) {
        if (stock < 0) {
            throw new RuntimeException("stock 값은 음수가 될 수 없습니다.");
        }
        return stock;
    }


    /**
     * 재고 감소
     * @param count 감소할 개수
     */
    public void decreaseStock(int count) {
        if (stock - count < 0) {
            throw new RuntimeException("재고가 부족합니다.");
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
