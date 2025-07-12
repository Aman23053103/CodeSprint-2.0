import java.util.*;

public class Lettergame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder("a");
        while (sb.length() < k) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                char nextchar = (char) ((c - 'a' + 1) % 26 + 'a');
                next.append(nextchar);
            }
            sb.append(next);
        }
        char result = sb.charAt(k - 1);
        System.out.println(Character.toUpperCase(result));
    }
}