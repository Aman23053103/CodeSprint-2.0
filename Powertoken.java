import java.util.*;

public class Powertoken {
    public static int maxscore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0, maxscore = 0;
        int low = 0, high = tokens.length - 1;
        while (low <= high) {
            if (power >= tokens[low]) {
                power -= tokens[low++];
                score++;
                maxscore = Math.max(maxscore, score);
            } else if (score >= 1) {
                power += tokens[high--];
                score--;
            } else {
                break;
            }
        }
        return maxscore;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial power: ");
        int power = sc.nextInt();
        System.out.print("Enter token values: ");
        sc.nextLine();
        String[] tokenstrings = sc.nextLine().split(" ");
        int[] tokens = new int[tokenstrings.length];
        for (int i = 0; i < tokenstrings.length; i++) {
            tokens[i] = Integer.parseInt(tokenstrings[i]);
        }
        int result = maxscore(tokens, power);
        System.out.println("Maximum score: " + result);
    }
}