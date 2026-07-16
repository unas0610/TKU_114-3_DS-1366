public class RectangleDemo {
    public static void printRectangleDetails(Rectangle r) {
        System.out.println(r);
        System.out.printf("面積：%.2f%n", r.calculateArea());
        System.out.printf("周長：%.2f%n", r.calculatePerimeter());
        System.out.println("是否為正方形：" + r.isSquare());
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5.0, 3.0);
        Rectangle r2 = new Rectangle(4.0, 4.0);
        Rectangle r3 = new Rectangle(8.5, 2.0);

        System.out.println("=== 長方形測試結果 ===");
        printRectangleDetails(r1);
        printRectangleDetails(r2);
        printRectangleDetails(r3);
    }
}