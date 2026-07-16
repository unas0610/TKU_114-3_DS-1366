public class ProductBasicsDemo {
    public static void main(String[] args) {
        ProductBasics keyboard = new ProductBasics();
        keyboard.name = "Keyboard";
        keyboard.price = 890;
        keyboard.stock = 12;

        ProductBasics mouse = new ProductBasics();
        mouse.name = "Mouse";
        mouse.price = 490;
        mouse.stock = 20;

        System.out.println(keyboard.name + "，價格：" + keyboard.price);
        System.out.println(mouse.name + "，庫存：" + mouse.stock);
    }
}