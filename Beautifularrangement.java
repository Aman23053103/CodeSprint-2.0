import java.util.*;

public class Beautifularrangement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of cards(N): ");
        int n = sc.nextInt();
        int[] cards = new int[n];
        System.out.print("Enter the card no: ");
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }
        Set<Integer> unique = new HashSet<>();
        for (int card : cards) {
            unique.add(card);
        }
        List<Integer> list = new ArrayList<>(unique);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    count++;
                }
            }
        }
        System.out.println("Number of beautiful arrangements: " + count);
    }
}