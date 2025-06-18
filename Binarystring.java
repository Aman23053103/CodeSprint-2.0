import java.util.*;

public class Binarystring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int leftones = 0;
        int rightones = 0;
        char[] chars = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < j && chars[i] == '0') {
                i++;
            }
            while (i < j && chars[j] == '1') {
                j--;
            }
            if (i < j) {
                leftones++;
                i++;
                j--;
            }
        }
        System.out.println(leftones);
    }
}