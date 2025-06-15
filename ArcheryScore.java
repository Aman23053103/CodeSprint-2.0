import java.util.*;

public class ArcheryScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1 || n > 100) {
            System.out.print("Invalid Shots");
            return;
        }
        int goodshots = 0;
        int badshots = 0;
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            if (score < 0 || score > 10) {
                System.out.println("Invalid Score");
                return;
            }
            if (score >= 7) {
                goodshots++;
            } else {
                badshots++;
            }
        }
        System.out.println(goodshots + " " + badshots);
    }
}