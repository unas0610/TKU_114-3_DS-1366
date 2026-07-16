public class SimpleProductObjectSystem {
    public static Product findProduct(Product[] products, String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name.trim())) {
                return product;
            }
        }
        return null;
    }

    public static long calculateTotalValue(Product[] products) {
        long total = 0;
        for (Product product : products) {
            total += product.getInventoryValue();
        }
        return total;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("Keyboard", 890, 12),
            new Product("Mouse", 490, 20),
            new Product("Monitor", 5200, 5)
        };

        System.out.println("全部商品：");
        for (Product product : products) {
            System.out.println(product);
        }

        Product found = findProduct(products, "monitor");
        if (found != null && found.sell(2)) {
            System.out.println("出售成功：" + found);
        }

        System.out.println("庫存總價值：" + calculateTotalValue(products));
    }
}