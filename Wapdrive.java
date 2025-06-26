import java.util.*;

public class Wapdrive {
    public static int closesttriplet(int[] energies, int target) {
        Arrays.sort(energies);
        int closestsum = Integer.MIN_VALUE;
        int mindiff = Integer.MAX_VALUE;
        for (int i = 0; i < energies.length - 2; i++) {
            int left = i + 1;
            int right = energies.length - 1;
            while (left < right) {
                int sum = energies[i] + energies[left] + energies[right];
                int diff = Math.abs(sum - target);
                if (diff < mindiff || (diff == mindiff && sum > closestsum)) {
                    mindiff = diff;
                    closestsum = sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestsum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of crystals: ");
        int n = sc.nextInt();
        int[] energies = new int[n];
        System.out.print("Enter the energy values: ");
        for (int i = 0; i < n; i++) {
            energies[i] = sc.nextInt();
        }
        System.out.print("Enter the req wrap energy: ");
        int target = sc.nextInt();
        int result = closesttriplet(energies, target);
        System.out.println("Optimal total energy: " + result);
    }
}