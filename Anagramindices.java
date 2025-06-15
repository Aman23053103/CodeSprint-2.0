import java.util.*;

public class Anagramindices {
    public static List<Integer> findAnagram(String logstream, String pattern) {
        List<Integer> result = new ArrayList<>();
        if (logstream == null || pattern == null || logstream.length() < pattern.length())
            return result;
        int[] patterncount = new int[26];
        int[] windowcount = new int[26];
        int patternlength = pattern.length();
        for (char c : pattern.toCharArray()) {
            patterncount[c - 'a']++;
        }
        for (int i = 0; i < logstream.length(); i++) {
            windowcount[logstream.charAt(i) - 'a']++;
            if (i >= patternlength) {
                windowcount[logstream.charAt(i - patternlength) - 'a']--;
            }
            if (Arrays.equals(patterncount, windowcount)) {
                result.add(i - patternlength + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the logstream:");
        String logstream = sc.nextLine();
        System.out.print("Enter the pattern:");
        String pattern = sc.nextLine();
        List<Integer> result = findAnagram(logstream, pattern);
        System.out.println("Anagram starting indices:" + result);
    }
}