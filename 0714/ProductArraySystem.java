import java.util.Scanner;

public class ProductArraySystem {
    public static void showProducts(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n--- 商品清單 ---");
        System.out.printf("%-4s %-15s %-8s %-5s%n", "編號", "商品名稱", "價格", "庫存");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-6d %-17s %-10d %-5d%n", (i + 1), names[i], prices[i], stocks[i]);
        }
    }

    public static void searchProduct(Scanner sc, String[] names, int[] prices, int[] stocks) {
        System.out.print("請輸入欲查詢的商品編號 (1~" + names.length + ")：");
        int id = sc.nextInt();
        if (id < 1 || id > names.length) {
            System.out.println("錯誤：無此商品編號！");
            return;
        }
        int index = id - 1;
        System.out.println("查詢結果：[" + names[index] + "] 價格: " + prices[index] + " | 剩餘庫存: " + stocks[index]);
    }

    public static void purchaseProduct(Scanner sc, String[] names, int[] stocks, int[] summary) {
        System.out.print("請輸入欲購買的商品編號 (1~" + names.length + ")：");
        int id = sc.nextInt();
        if (id < 1 || id > names.length) {
            System.out.println("錯誤：無此商品編號！");
            return;
        }
        int index = id - 1;
        System.out.print("請輸入購買數量 (現有庫存：" + stocks[index] + ")：");
        int qty = sc.nextInt();
        if (qty <= 0) {
            System.out.println("錯誤：購買數量必須大於 0！");
            return;
        }
        if (qty > stocks[index]) {
            System.out.println("錯誤：庫存不足，無法購買！");
            return;
        }
        stocks[index] -= qty;
        summary[index] += qty;
        System.out.println("購買成功！已扣除庫存。");
    }

    public static void restockProduct(Scanner sc, String[] names, int[] stocks) {
        System.out.print("請輸入欲補貨的商品編號 (1~" + names.length + ")：");
        int id = sc.nextInt();
        if (id < 1 || id > names.length) {
            System.out.println("錯誤：無此商品編號！");
            return;
        }
        int index = id - 1;
        System.out.print("請輸入補貨數量：");
        int qty = sc.nextInt();
        if (qty <= 0) {
            System.out.println("錯誤：補貨數量必須大於 0！");
            return;
        }
        stocks[index] += qty;
        System.out.println("補貨成功！目前庫存：" + stocks[index]);
    }

    public static void showLowStocks(String[] names, int[] stocks) {
        System.out.println("\n--- 低庫存商品警告 (庫存 < 10) ---");
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (stocks[i] < 10) {
                System.out.println("編號 " + (i + 1) + ". " + names[i] + " (當前庫存：" + stocks[i] + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("目前無低庫存商品。");
        }
    }

    public static int calculateTotalValue(int[] prices, int[] stocks) {
        int totalValue = 0;
        for (int i = 0; i < prices.length; i++) {
            totalValue += prices[i] * stocks[i];
        }
        return totalValue;
    }

    public static void printSummary(String[] names, int[] prices, int[] summary) {
        System.out.println("\n================ 操作摘要 ================");
        int totalSales = 0;
        for (int i = 0; i < names.length; i++) {
            if (summary[i] > 0) {
                int cost = summary[i] * prices[i];
                System.out.println(names[i] + " 共售出：" + summary[i] + " 個，銷售金額：" + cost);
                totalSales += cost;
            }
        }
        System.out.println("本次系統運行總銷售營業額：" + totalSales + " 元");
        System.out.println("=========================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
        int[] prices = {890, 490, 5200, 250, 1290};
        int[] stocks = {12, 20, 5, 30, 8};
        int[] purchaseSummary = new int[names.length];

        int choice;
        do {
            System.out.println("\n===== 商品管理系統選單 =====");
            System.out.println("1. 顯示全部商品");
            System.out.println("2. 依商品編號查詢");
            System.out.println("3. 購買商品並扣除庫存");
            System.out.println("4. 補充商品庫存");
            System.out.println("5. 顯示低庫存商品");
            System.out.println("6. 顯示全部庫存總價值");
            System.out.println("7. 結束程式並顯示操作摘要");
            System.out.print("請輸入選擇 (1~7)：");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showProducts(names, prices, stocks);
                    break;
                case 2:
                    searchProduct(sc, names, prices, stocks);
                    break;
                case 3:
                    purchaseProduct(sc, names, stocks, purchaseSummary);
                    break;
                case 4:
                    restockProduct(sc, names, stocks);
                    break;
                case 5:
                    showLowStocks(names, stocks);
                    break;
                case 6:
                    int totalVal = calculateTotalValue(prices, stocks);
                    System.out.println("\n目前倉庫內全部庫存總價值為：" + totalVal + " 元");
                    break;
                case 7:
                    printSummary(names, prices, purchaseSummary);
                    System.out.println("系統已成功結束。");
                    break;
                default:
                    System.out.println("無效的選擇，請重新輸入！");
            }
        } while (choice != 7);

        sc.close();
    }
}