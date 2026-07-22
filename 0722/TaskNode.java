public class TaskNode {
    String code;
    String description;
    boolean isCompleted;
    TaskNode next;

    public TaskNode(String code, String description) {
        this.code = code;
        this.description = description;
        this.isCompleted = false;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.format("[%s] %-15s | 狀態: %s", 
                code, description, isCompleted ? "已完成" : "未完成");
    }
}