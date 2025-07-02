import java.util.*;

public class Magiciancard {
    public static int[] deckreveal(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deque = new LinkedList<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast());
            }
            deque.addFirst(deck[i]);
        }
        int[] result = new int[deck.length];
        int i = 0;
        for (int val : deque) {
            result[i++] = val;
        }
        return result;
    }

    public static List<Integer> simulatereveal(int[] initialdeck) {
        Queue<Integer> queue = new LinkedList<>();
        for (int card : initialdeck) {
            queue.offer(card);
        }
        List<Integer> revealed = new ArrayList<>();
        while (!queue.isEmpty()) {
            revealed.add(queue.poll());
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }
        return revealed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of cards: ");
        int n = sc.nextInt();
        int[] deck = new int[n];
        System.out.print("Enter card values: ");
        for (int i = 0; i < n; i++) {
            deck[i] = sc.nextInt();
        }
        int[] initialorder = deckreveal(deck);
        List<Integer> revealedorder = simulatereveal(initialorder);
        System.out.print("Initial deck order:");
        System.out.println("Initial dark order: " + Arrays.toString(initialorder));
        System.out.println("Revealed order: " + revealedorder);
    }
}