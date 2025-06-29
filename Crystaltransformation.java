import java.util.*;

public class Crystaltransformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] crystals = new int[n];
        for (int i = 0; i < n; i++) {
            crystals[i] = sc.nextInt();
        }
        int[] result = new int[n];
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * crystals[i - 1];
        }
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * crystals[i + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = (int) (prefix[i] * suffix[i]);
        }
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}