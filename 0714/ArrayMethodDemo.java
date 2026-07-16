public class ArrayMethodDemo {
    public static int calculateTotal(int[] values) {
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }

    public static void addBonus(int[] values, int bonus) {
        for (int i = 0; i < values.length; i++) {
            values[i] += bonus;
        }
    }

    public static void printArray(int[] values) {
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] scores = {70, 75, 80};

        System.out.println("原始資料：");
        printArray(scores);
        System.out.println("總和：" + calculateTotal(scores));

        addBonus(scores, 5);
        System.out.println("加分後：");
        printArray(scores);
    }
}