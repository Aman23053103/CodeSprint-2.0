import java.util.*;

public class Goodstring {
    static final int[] evendig = { 0, 2, 4, 6, 8 };
    static final int[] primedig = { 2, 3, 5, 7 };

    public static int countgoodstring(int n) {
        return countrecur(n, 0);
    }

    public static int countrecur(int n, int index) {
        if (index == n) {
            return 1;
        }
        int count = 0;
        if (index % 2 == 0) {
            for (int digit : evendig) {
                count += countrecur(n, index + 1);
            }
        } else {
            for (int digit : primedig) {
                count += countrecur(n, index + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the digit string: ");
        int n = sc.nextInt();
        int result = countgoodstring(n);
        System.out.println("Total no of good digits: " + result);
    }
}