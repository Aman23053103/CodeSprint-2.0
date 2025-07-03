import java.util.*;

public class NCR {
    public static int ncr(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }
        return ncr(n - 1, r) + ncr(n - 1, r - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N and r: ");
        int n = sc.nextInt();
        int r = sc.nextInt();
        if (r < 0 || r > n || n > 100) {
            System.out.println("Invalid input");
            return;
        }
        System.out.println("No of ways to choose " + r + " from " + n + " knights: " + ncr(n, r));
    }
}