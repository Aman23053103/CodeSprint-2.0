import java.util.*;

public class Ciphervalidator {
    public static boolean isvaliddecoding(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> mapst = new HashMap<>();
        HashMap<Character, Character> mapts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (mapst.containsKey(cs)) {
                if (mapst.get(cs) != ct)
                    return false;
            } else {
                mapst.put(cs, ct);
            }
            if (mapts.containsKey(ct)) {
                if (mapts.get(ct) != cs)
                    return false;
            } else {
                mapts.put(ct, cs);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the original message: ");
        String s = sc.nextLine();
        System.out.println("Enter the coded message: ");
        String t = sc.nextLine();
        boolean result = isvaliddecoding(s, t);
        System.out.println(result ? "True" : "False");
    }
}