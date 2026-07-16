public class SalesMatrixDemo {
    public static void main(String[] args) {
        int[][] sales = {
            {5, 8, 6, 7},
            {3, 4, 5, 6},
            {10, 12, 9, 11}
        };

        for (int product = 0; product < sales.length; product++) {
            int productTotal = 0;
            for (int day = 0; day < sales[product].length; day++) {
                productTotal += sales[product][day];
            }
            System.out.println("商品 " + (product + 1) + " 總銷售量：" + productTotal);
        }

        for (int day = 0; day < sales[0].length; day++) {
            int dayTotal = 0;
            for (int product = 0; product < sales.length; product++) {
                dayTotal += sales[product][day];
            }
            System.out.println("第 " + (day + 1) + " 天總銷售量：" + dayTotal);
        }
    }
}