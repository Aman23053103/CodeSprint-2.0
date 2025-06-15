import java.util.*;

public class Bennyslip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the movement string(L,R,U,D): ");
        String steps = sc.nextLine();
        int x = 0, y = 0;
        int slips = 0;
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        for (char step : steps.toCharArray()) {
            switch (step) {
                case 'L' -> x--;
                case 'R' -> x++;
                case 'U' -> y++;
                case 'D' -> y--;
            }
            String position = x + "," + y;
            if (visited.contains(position)) {
                slips++;
            } else {
                visited.add(position);
            }
        }
        System.out.println("Benny slipped " + slips + " times");
    }
}