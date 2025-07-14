import java.util.*;

public class Vaccineassignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vaccines = new int[n];
        for (int i = 0; i < n; i++) {
            vaccines[i] = sc.nextInt();
        }
        int[] patients = new int[n];
        for (int i = 0; i < n; i++) {
            patients[i] = sc.nextInt();
        }
        Arrays.sort(vaccines);
        Arrays.sort(patients);
        boolean allcured = true;
        for (int i = 0; i < n; i++) {
            if (vaccines[i] <= patients[i]) {
                allcured = false;
                break;
            }
        }
        if (allcured) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}