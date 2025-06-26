import java.util.*;

public class Binarytable {
    public static int findsymbol(int n, int k) {
        if (n == 1)
            return 0;
        int mid = 1 << (n - 2);
        if (k <= mid) {
            return findsymbol(n - 1, k);
        } else {
            return 1 - findsymbol(n - 1, k - mid);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = findsymbol(n, k);
        System.out.println(result);
    }
}