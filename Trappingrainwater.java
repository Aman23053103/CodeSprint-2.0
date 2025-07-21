import java.util.*;

public class Trappingrainwater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        int trappedwater = calculatetrappedwater(height, n);
        System.out.println(trappedwater);
    }

    private static int calculatetrappedwater(int[] height, int n) {
        if (n == 0)
            return 0;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        int water = 0;
        leftmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);
        }
        rightmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            water += Math.min(leftmax[i], rightmax[i]) - height[i];
        }
        return water;
    }
}