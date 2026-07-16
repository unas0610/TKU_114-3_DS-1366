public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (!setWidth(width)) {
            this.width = 1.0;
        }
        if (!setHeight(height)) {
            this.height = 1.0;
        }
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean setWidth(double width) {
        if (width <= 0) {
            return false;
        }
        this.width = width;
        return true;
    }

    public boolean setHeight(double height) {
        if (height <= 0) {
            return false;
        }
        this.height = height;
        return true;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    public boolean isSquare() {
        return Double.compare(width, height) == 0;
    }

    @Override
    public String toString() {
        return "長方形 [寬：" + width + "，高：" + height + "]";
    }
}