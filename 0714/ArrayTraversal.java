public class ArrayTraversal {
    public static void main(String[] args) {
        int[] scores = {80, 75, 92, 68, 88};

        System.out.println("使用一般 for：");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("索引 " + i + "：" + scores[i]);
        }

        System.out.println("使用 for-each：");
        for (int score : scores) {
            System.out.println(score);
        }
    }
}