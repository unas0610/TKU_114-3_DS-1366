import java.util.Arrays;

public class ArrayCopyDemo {
    public static void main(String[] args) {
        int[] original = {10, 20, 30};
        int[] copy = Arrays.copyOf(original, original.length);
        copy[0] = 99;
        System.out.println("原陣列：" + Arrays.toString(original));
        System.out.println("副本：" + Arrays.toString(copy));
    }
}