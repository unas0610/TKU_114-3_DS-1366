public class TaskLinkedList {
    private TaskNode head;

    public void addEmergencyTask(String code, String description) {
        TaskNode newNode = new TaskNode(code, description);
        newNode.next = head;
        head = newNode;
    }

    public void addNormalTask(String code, String description) {
        TaskNode newNode = new TaskNode(code, description);
        if (head == null) {
            head = newNode;
            return;
        }
        TaskNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public boolean completeTask(String code) {
        TaskNode task = findByCode(code);
        if (task != null) {
            task.isCompleted = true;
            return true;
        }
        return false;
    }

    public TaskNode findByCode(String code) {
        TaskNode current = head;
        while (current != null) {
            if (current.code.equalsIgnoreCase(code)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteCompletedTasks() {
        while (head != null && head.isCompleted) {
            head = head.next;
        }

        if (head == null) return;

        TaskNode current = head;
        while (current.next != null) {
            if (current.next.isCompleted) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void listUncompletedTasks() {
        if (head == null) {
            System.out.println("目前無任何工作。");
            return;
        }
        TaskNode current = head;
        boolean found = false;
        System.out.println("=== 未完成工作清單 ===");
        while (current != null) {
            if (!current.isCompleted) {
                System.out.println(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("所有工作皆已完成！");
        }
    }

    public int getTotalCount() {
        int count = 0;
        TaskNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public int getUncompletedCount() {
        int count = 0;
        TaskNode current = head;
        while (current != null) {
            if (!current.isCompleted) {
                count++;
            }
            current = current.next;
        }
        return count;
    }
}