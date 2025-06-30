import java.util.*;

public class MovementSegmentCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String log = sc.nextLine();
        int segments = 0;
        boolean insegment = false;
        for (int i = 0; i < log.length(); i++) {
            char ch = log.charAt(i);
            if (ch == '1') {
                if (!insegment) {
                    segments++;
                    insegment = true;
                }
            } else {
                insegment = false;
            }
        }
        System.out.println(segments);
    }
}