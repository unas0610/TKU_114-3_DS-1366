public class ArrayStatisticsDemo {
    public static void main(String[] args) {
        int[] scores = {80, 75, 92, 68, 88};
        int total = 0;
        int max = scores[0];
        int min = scores[0];
        int passCount = 0;

        for (int score : scores) {
            total += score;

            if (score > max) {
                max = score;
            }
            if (score < min) {
                min = score;
            }
            if (score >= 60) {
                passCount++;
            }
        }

        double average = (double) total / scores.length;

        System.out.println("總分：" + total);
        System.out.printf("平均：%.2f%n", average);
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("及格人數：" + passCount);
    }
}