public class ProductArrayDemo {
    public static Product findProduct(Product[] products, String name) {
        for (Product product : products) {
            if (product != null && product.getName().equalsIgnoreCase(name.trim())) {
                return product;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Keyboard", 890, 12);
        products[1] = new Product("Mouse", 490, 20);
        products[2] = new Product("Monitor", 5200, 5);

        System.out.println("全部商品：");
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }

        Product found = findProduct(products, " mouse ");
        if (found != null) {
            System.out.println("搜尋結果：" + found);
        } else {
            System.out.println("找不到商品");
        }
    }
}