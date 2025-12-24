import exception.InsufficientStockException;

public class Product {

    private final String id;
    private final String name;
    private final int price;
    private int stock;

    public Product(String id, String name, int price, int stock) {
        this.id = id;
        this.name = validateName(name);
        this.price = validatePrice(price);
        this.stock = validateStock(stock);
    }

    public int validatePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("가격은 0 이상이어야 합니다.");
        }
        return price;
    }

    public String validateName(String name) {
        if (name.length() > 100) {
            throw new RuntimeException("name 값은 1 ~ 100 사이의 글자여야 합니다.");
        }
        return name;
    }

    public int validateStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("재고는 0 이상이어야 합니다.");
        }
        return stock;
    }

    /**
     * 재고 감소
     * @param count 감소할 개수
     */
    public void decreaseStock(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count 값은 음수가 될 수 없습니다. count = " + count);
        }
        if (stock < count) {
            throw new InsufficientStockException("재고 부족: 현재 = " + stock + " 요청 = " + count);
        }
        this.stock -= count;
    }

    /**
     * 재고 증가
     * @param count 감소할 개수
     */
    public void increaseStock(int count) {
        long sum = (long)this.stock + count;
        if (sum > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("재고 수량 허용 범위 초과: 현재 = " + this.stock + "요청 = " + count);
        }
        this.stock += count;
    }

    public void setStock(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("재고는 0 이상이어야 합니다.");
        }
        this.stock = count;
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
