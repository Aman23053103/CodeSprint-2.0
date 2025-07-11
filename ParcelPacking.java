import java.util.*;

public class ParcelPacking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of parcels and max no of boxes: ");
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] weights = new int[n];
        System.out.print("Enter weights of parcels: ");
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        int result = findminmaxboxweight(weights, k);
        System.out.println("Minimum possible weight of the heaviest box: " + result);
    }

    private static int findminmaxboxweight(int[] weights, int k) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        int answer = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (candivide(weights, k, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private static boolean candivide(int[] weights, int k, int maxweight) {
        int currentsum = 0;
        int boxcount = 1;
        for (int weight : weights) {
            if (currentsum + weight > maxweight) {
                boxcount++;
                currentsum = weight;
                if (boxcount > k)
                    return false;
            } else {
                currentsum += weight;
            }
        }
        return true;
    }
}