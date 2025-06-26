import java.util.*;

public class Cratesorter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of crates: ");
        int n = sc.nextInt();
        int[] crates = new int[n];
        System.out.print("Enter crate labels: ");
        for (int i = 0; i < n; i++) {
            crates[i] = sc.nextInt();
        }
        Map<Integer, Integer> fm = new HashMap<>();
        for (int num : crates) {
            fm.put(num, fm.getOrDefault(num, 0) + 1);
        }
        List<Integer> sortedlist = new ArrayList<>();
        for (int num : crates) {
            sortedlist.add(num);
        }
        sortedlist.sort((a, b) -> {
            int freqcomp = fm.get(b).compareTo(fm.get(a));
            if (freqcomp == 0) {
                return Integer.compare(a, b);
            }
            return freqcomp;
        });
        for (int num : sortedlist) {
            System.out.print(num + " ");
        }
    }
}