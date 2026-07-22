public class TaskLinkedListSystem {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        System.out.println("=== 1. 新增工作 ===");
        taskList.addNormalTask("T01", "Write Report");
        taskList.addNormalTask("T02", "Study Java");
        taskList.addEmergencyTask("E01", "Fix Server Bug");

        taskList.listUncompletedTasks();
        printSummary(taskList);

        System.out.println("\n=== 2. 完成工作 E01 與 T01 ===");
        taskList.completeTask("E01");
        taskList.completeTask("T01");

        taskList.listUncompletedTasks();
        printSummary(taskList);

        System.out.println("\n=== 3. 批次刪除已完成工作 ===");
        taskList.deleteCompletedTasks();

        taskList.listUncompletedTasks();
        printSummary(taskList);
    }
    public static void printSummary(TaskLinkedList list) {
        System.out.println("------------------------------------");
        System.out.println("總工作數：" + list.getTotalCount());
        System.out.println("未完成數量：" + list.getUncompletedCount());
        System.out.println("------------------------------------");
    }
}