public class SequentialSearch {
    public static int findIndex(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] values = {12, 25, 18, 30, 25};
        int target = 25;
        int index = findIndex(values, target);

        if (index >= 0) {
            System.out.println(target + " 第一次出現在索引 " + index);
        } else {
            System.out.println("找不到 " + target);
        }
    }
}