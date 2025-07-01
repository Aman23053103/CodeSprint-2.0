import java.util.*;

class Listnode {
    int val;
    Listnode next;

    Listnode(int val) {
        this.val = val;
    }
}

public class Paradeleader {
    public static List<Integer> getmiddletoend(Listnode head) {
        if (head == null)
            return new ArrayList<>();
        Listnode slow = head;
        Listnode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        List<Integer> result = new ArrayList<>();
        while (slow != null) {
            result.add(slow.val);
            slow = slow.next;
        }
        return result;
    }

    public static Listnode createlinkedlist(int[] values) {
        if (values.length == 0)
            return null;
        Listnode head = new Listnode(values[0]);
        Listnode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Listnode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of children");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Invalid no of children");
            return;
        }
        int[] input = new int[n];
        System.out.println("Enter the badge:");
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        Listnode head = createlinkedlist(input);
        List<Integer> result = getmiddletoend(head);
        System.out.println("Output: " + result);
    }
}