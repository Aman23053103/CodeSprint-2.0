import java.util.*;

public class Clubtheme {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer, Integer> freq = new HashMap<>();
        int[] themes = new int[n];
        for (int i = 0; i < n; i++) {
            themes[i] = sc.nextInt();
            freq.put(themes[i], freq.getOrDefault(themes[i], 0) + 1);
        }
        List<Integer> reusablethemes = new ArrayList<>();
        List<Integer> singleusethemes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() >= 2) {
                reusablethemes.add(entry.getKey());
            } else {
                singleusethemes.add(entry.getKey());
            }
        }
        int totalunique = freq.size();
        int maxpossible = reusablethemes.size() * 2 + singleusethemes.size();
        if (maxpossible < 2 * k) {
            System.out.println("NO");
            return;
        }
        int cluba = 0, clubb = 0;
        for (int theme : reusablethemes) {
            if (cluba < k)
                cluba++;
            if (clubb < k)
                clubb++;
        }
        for (int theme : singleusethemes) {
            if (cluba < k)
                cluba++;
            else if (clubb < k)
                clubb++;
        }
        if (cluba == k && clubb == k) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}