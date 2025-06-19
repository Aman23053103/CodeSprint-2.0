import java.util.*;

public class Packetnesting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of packets: ");
        int n = sc.nextInt();
        System.out.println("Enter highness values of packets:");
        Map<Integer, Integer> fm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            fm.put(x, fm.getOrDefault(x, 0) + 1);
        }
        int maxfreq = 0;
        for (int freq : fm.values()) {
            maxfreq = Math.max(maxfreq, freq);
        }
        System.out.println("Minimum packets to smuggle: " + maxfreq);
    }
}