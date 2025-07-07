import java.util.*;

public class Merlinvictory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] merlin = new int[n];
        for (int i = 0; i < n; i++) {
            merlin[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] morgana = new int[m];
        for (int i = 0; i < m; i++) {
            morgana[i] = sc.nextInt();
        }
        int maxmorgana = Arrays.stream(morgana).max().getAsInt();
        int manareq = 0;
        for (int power : merlin) {
            if (power <= maxmorgana) {
                manareq += (maxmorgana - power + 1);
            }
        }
        System.out.println(manareq);
    }
}
