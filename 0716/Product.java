public class Product {
    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unnamed";
        } else {
            this.name = name.trim();
        }
        this.price = Math.max(price, 1);
        this.stock = Math.max(stock, 0);
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

    public boolean setPrice(int price) {
        if (price <= 0) {
            return false;
        }
        this.price = price;
        return true;
    }

    public boolean restock(int quantity) {
        if (quantity <= 0) {
            return false;
        }
        stock += quantity;
        return true;
    }

    public boolean sell(int quantity) {
        if (quantity <= 0 || quantity > stock) {
            return false;
        }
        stock -= quantity;
        return true;
    }

    public boolean isLowStock() {
        return stock < 10;
    }

    public long getInventoryValue() {
        return (long) price * stock;
    }

    @Override
    public String toString() {
        return "商品名稱：%-15s | 價格：%-6d | 庫存：%-5d | 總價值：%-8d".formatted(
                name, price, stock, getInventoryValue()
        );
    }
}