import java.util.*;

public class VowelPatient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Set<String> seen = new HashSet<>();
        List<String> result = new ArrayList<>();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            if (vowels.contains(name.charAt(0)) && !seen.contains(name)) {
                seen.add(name);
                result.add(name);
            }
        }
        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}