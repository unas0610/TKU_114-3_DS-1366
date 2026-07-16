public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("9487-01", "Chun-Yu", 10000);
        BankAccount acc2 = new BankAccount("9487-02", "Xin-Yu", 2000);

        System.out.println("=== 初始帳戶狀態 ===");
        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println();

        System.out.println("=== 存款與提款測試 ===");
        System.out.println("acc1 存款 1500：" + (acc1.deposit(1500) ? "成功" : "失敗"));
        System.out.println("acc2 提款 500：" + (acc2.withdraw(500) ? "成功" : "失敗"));
        System.out.println("acc2 惡意提款 5000 (超額)：" + (acc2.withdraw(5000) ? "成功" : "失敗"));
        System.out.println();

        System.out.println("=== 轉帳測試 ===");
        System.out.println("acc1 轉帳 3000 給 acc2：" + (acc1.transferTo(acc2, 3000) ? "成功" : "失敗"));
        System.out.println("目前的帳戶狀態：");
        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println();

        System.out.println("acc2 轉帳 10000 (超額) 給 acc1：" + (acc2.transferTo(acc1, 10000) ? "成功" : "失敗"));
        System.out.println("目前的帳戶狀態 (應不受失敗操作影響)：");
        System.out.println(acc1);
        System.out.println(acc2);
    }
}