import java.util.*;

public class Firstnonrepeating {
    public static String firstnon(String stream) {
        int[] charcount = new int[26];
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        for (char ch : stream.toCharArray()) {
            charcount[ch - 'a']++;
            queue.add(ch);
            while (!queue.isEmpty() && charcount[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
            result.append(queue.isEmpty() ? '#' : queue.peek());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stream:");
        String input = sc.nextLine();
        String output = firstnon(input);
        System.out.println("Output: " + output);
    }
}