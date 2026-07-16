import java.util.Scanner;

public class ArrayStatistics {
    public static int readCount(Scanner sc) {
        int count;
        do {
            System.out.print("請輸入資料筆數 (1~50)：");
            count = sc.nextInt();
        } while (count < 1 || count > 50);
        return count;
    }

    public static void inputScores(Scanner sc, int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            int score;
            do {
                System.out.print("請輸入第 " + (i + 1) + " 筆成績 (0~100)：");
                score = sc.nextInt();
            } while (score < 0 || score > 100);
            scores[i] = score;
        }
    }

    public static int calculateTotal(int[] scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    public static int findMin(int[] scores) {
        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }

    public static int countPass(int[] scores) {
        int count = 0;
        for (int score : scores) {
            if (score >= 60) {
                count++;
            }
        }
        return count;
    }

    public static int findIndex(int[] scores, int target) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void printScores(int[] scores) {
        System.out.print("全部成績：");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = readCount(sc);
        int[] scores = new int[count];
        inputScores(sc, scores);

        System.out.println("\n--- 統計結果 ---");
        printScores(scores);

        int total = calculateTotal(scores);
        double average = (double) total / scores.length;
        int max = findMax(scores);
        int min = findMin(scores);
        int pass = countPass(scores);
        int fail = scores.length - pass;

        System.out.println("總分：" + total);
        System.out.printf("平均：%.2f%n", average);
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("及格人數：" + pass);
        System.out.println("不及格人數：" + fail);

        System.out.print("\n請輸入欲搜尋的目標成績：");
        int target = sc.nextInt();
        int index = findIndex(scores, target);

        if (index != -1) {
            System.out.println("成績 " + target + " 第一次出現在索引 " + index + " (第 " + (index + 1) + " 筆)");
        } else {
            System.out.println("找不到成績 " + target);
        }

        sc.close();
    }
}