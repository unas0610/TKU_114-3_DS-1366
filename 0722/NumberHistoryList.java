class NumNode {
    int data;
    NumNode next;

    public NumNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class NumberHistoryList {
    private NumNode head;

    public static void main(String[] args) {
        NumberHistoryList history = new NumberHistoryList();

        System.out.println("=== 測試 1: 空串列狀態 ===");
        history.printStats();

        System.out.println("\n=== 測試 2: 前端新增 20 ===");
        history.addFirst(20);
        history.printList();

        System.out.println("\n=== 測試 3: 前端新增 10 ===");
        history.addFirst(10);
        history.printList();

        System.out.println("\n=== 測試 4: 尾端新增 30 ===");
        history.addLast(30);
        history.printList();

        System.out.println("\n=== 測試 5: 搜尋 20 與 99 ===");
        System.out.println("搜尋 20: " + history.search(20));
        System.out.println("搜尋 99: " + history.search(99));

        System.out.println("\n=== 測試 6: 刪除 10 (Head) ===");
        history.remove(10);
        history.printList();

        System.out.println("\n=== 測試 7: 刪除不存在的 100 ===");
        System.out.println("刪除 100 成功: " + history.remove(100));

        System.out.println("\n=== 測試 8: 印出最終統計報告 ===");
        history.printStats();
    }

    public void addFirst(int data) {
        NumNode newNode = new NumNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        NumNode newNode = new NumNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        NumNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public boolean search(int value) {
        NumNode current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean remove(int value) {
        if (head == null) {
            return false;
        }

        if (head.data == value) {
            head = head.next;
            return true;
        }

        NumNode current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int getSize() {
        int size = 0;
        NumNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public int getSum() {
        int sum = 0;
        NumNode current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    public Integer getHeadValue() {
        return head != null ? head.data : null;
    }

    public Integer getTailValue() {
        if (head == null) return null;
        NumNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public void printList() {
        if (head == null) {
            System.out.println("串列目前為空。");
            return;
        }
        NumNode current = head;
        System.out.print("歷史紀錄：");
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public void printStats() {
        System.out.println("--- 串列統計摘要 ---");
        int size = getSize();
        if (size == 0) {
            System.out.println("⚠️ 串列為空，無統計數據。");
        } else {
            System.out.println("串列大小：" + size);
            System.out.println("數值總和：" + getSum());
            System.out.println("頂部 (Head) 數值：" + getHeadValue());
            System.out.println("尾部 (Tail) 數值：" + getTailValue());
        }
    }
}