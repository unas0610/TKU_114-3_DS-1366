import java.util.Scanner;

public class SalesMatrix {
    public static void inputSales(Scanner sc, int[][] sales) {
        for (int row = 0; row < sales.length; row++) {
            for (int col = 0; col < sales[row].length; col++) {
                int value;
                do {
                    System.out.print("請輸入商品 " + (row + 1) + " 第 " + (col + 1) + " 天的銷售量 (>= 0)：");
                    value = sc.nextInt();
                } while (value < 0);
                sales[row][col] = value;
            }
        }
    }

    public static void printMatrix(int[][] sales) {
        System.out.println("\n--- 銷售矩陣報表 ---");
        System.out.printf("%-8s %-5s %-5s %-5s %-5s%n", "商品\\天數", "Day1", "Day2", "Day3", "Day4");
        for (int row = 0; row < sales.length; row++) {
            System.out.printf("商品 %-5d", (row + 1));
            for (int col = 0; col < sales[row].length; col++) {
                System.out.printf("%-6d", sales[row][col]);
            }
            System.out.println();
        }
    }

    public static int[] calculateProductTotals(int[][] sales) {
        int[] totals = new int[sales.length];
        for (int row = 0; row < sales.length; row++) {
            int rowSum = 0;
            for (int col = 0; col < sales[row].length; col++) {
                rowSum += sales[row][col];
            }
            totals[row] = rowSum;
        }
        return totals;
    }

    public static int[] calculateDayTotals(int[][] sales) {
        int[] totals = new int[sales[0].length];
        for (int col = 0; col < sales[0].length; col++) {
            int colSum = 0;
            for (int row = 0; row < sales.length; row++) {
                colSum += sales[row][col];
            }
            totals[col] = colSum;
        }
        return totals;
    }

    public static int findBestProduct(int[] productTotals) {
        int bestIdx = 0;
        for (int i = 1; i < productTotals.length; i++) {
            if (productTotals[i] > productTotals[bestIdx]) {
                bestIdx = i;
            }
        }
        return bestIdx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] sales = new int[3][4];

        inputSales(sc, sales);
        printMatrix(sales);

        int[] productTotals = calculateProductTotals(sales);
        int[] dayTotals = calculateDayTotals(sales);

        System.out.println("\n--- 商品銷售總量 ---");
        for (int i = 0; i < productTotals.length; i++) {
            System.out.println("商品 " + (i + 1) + " 銷售總量：" + productTotals[i]);
        }
        System.out.println("\n--- 每日銷售總量 ---");
        for (int j = 0; j < dayTotals.length; j++) {
            System.out.println("第 " + (j + 1) + " 天銷售總量：" + dayTotals[j]);
        }
        int bestIdx = findBestProduct(productTotals);
        System.out.println("\n總銷售量最高的商品是：商品 " + (bestIdx + 1) + " (銷售量：" + productTotals[bestIdx] + ")");
        sc.close();
    }
}