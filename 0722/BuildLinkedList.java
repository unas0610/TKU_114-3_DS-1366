class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class BuildLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        printList(head);
        
        System.out.println("節點數：" + countNodes(head));
        System.out.println("總和：" + sumNodes(head));

        System.out.println("\n--- 空串列測試 ---");
        Node emptyHead = null;
        printList(emptyHead);
        System.out.println("節點數：" + countNodes(emptyHead));
        System.out.println("總和：" + sumNodes(emptyHead));
        }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("鏈結串列為空。");
            return;
        }
        Node current = head;
        System.out.print("鏈結串列內容：");
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }
    public static int countNodes(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    public static int sumNodes(Node head) {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
}