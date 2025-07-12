import java.util.*;

public class LongestIncreasingSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println(0);
            return;
        }
        int[] temps = new int[n];
        for (int i = 0; i < n; i++) {
            temps[i] = sc.nextInt();
        }
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < n; i++) {
            if (temps[i] > temps[i - 1]) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }
        System.out.println(maxLength);
    }
}