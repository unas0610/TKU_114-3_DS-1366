import java.util.Scanner;

public class ArrayInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count;

        do {
            System.out.print("請輸入資料筆數（1～10）：");
            count = sc.nextInt();
        } while (count < 1 || count > 10);

        int[] values = new int[count];

        for (int i = 0; i < values.length; i++) {
            System.out.print("第 " + (i + 1) + " 筆：");
            values[i] = sc.nextInt();
        }

        System.out.print("輸入結果：");
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println();

        sc.close();
    }
}