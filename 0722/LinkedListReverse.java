class ReverseNode {
    int data;
    ReverseNode next;

    public ReverseNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListReverse {
    private ReverseNode head;

    public static void main(String[] args) {
        LinkedListReverse list = new LinkedListReverse();

        System.out.println("=== 1. 空串列測試 ===");
        list.reverse();
        list.printList();

        System.out.println("\n=== 2. 單一節點測試 ===");
        list.add(10);
        System.out.print("反轉前：");
        list.printList();
        list.reverse();
        System.out.print("反轉後：");
        list.printList();

        System.out.println("\n=== 3. 多節點測試 ===");
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.print("反轉前：");
        list.printList();
        list.reverse();
        System.out.print("反轉後：");
        list.printList();
    }

    public void add(int data) {
        ReverseNode newNode = new ReverseNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ReverseNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void reverse() {
        ReverseNode prev = null;
        ReverseNode current = head;
        ReverseNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void printList() {
        if (head == null) {
            System.out.println("串列為空。");
            return;
        }
        ReverseNode current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }
}