import java.util.HashSet;
import java.util.Scanner;

public class JewelsAndStones {
    public static int countJewelsinstones(String jewels, String stones) {
        HashSet<Character> js = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            js.add(c);
        }
        int count = 0;
        for (char c : stones.toCharArray()) {
            if (js.contains(c)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter jewels:");
        String jewels = sc.nextLine();
        System.out.println("enter stones:");
        String stones = sc.nextLine();
        int result = countJewelsinstones(jewels, stones);
        System.out.println("No. of jewels in stones:" + result);
    }
}