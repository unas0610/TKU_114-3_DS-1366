class SearchNode {
    int data;
    SearchNode next;

    public SearchNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListSearchRemove {
    private SearchNode head;
    public static void main(String[] args) {
        LinkedListSearchRemove list = new LinkedListSearchRemove();
        
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("初始串列：");
        list.printList();

        System.out.println("\n--- 搜尋測試 ---");
        System.out.println("包含 20: " + list.contains(20));
        System.out.println("包含 99: " + list.contains(99));

        System.out.println("\n--- 刪除測試 ---");
        list.removeValue(10);
        System.out.print("刪除 Head (10) 後：");
        list.printList();

        list.removeValue(30);
        System.out.print("刪除 中間 (30) 後：");
        list.printList();

        list.removeValue(40);
        System.out.print("刪除 尾端 (40) 後：");
        list.printList();

        list.removeValue(99);
        System.out.print("刪除 找不到的資料 (99) 後：");
        list.printList();
    }

    public void add(int data) {
        SearchNode newNode = new SearchNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        SearchNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public boolean contains(int value) {
        SearchNode current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean removeValue(int value) {
        if (head == null) {
            return false;
        }

        if (head.data == value) {
            head = head.next;
            return true;
        }

        SearchNode current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printList() {
        if (head == null) {
            System.out.println("串列為空。");
            return;
        }
        SearchNode current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }
}