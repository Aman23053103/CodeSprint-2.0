import java.util.*;

class Listnode {
    int val;
    Listnode next;

    Listnode(int val) {
        this.val = val;
    }
}

public class Ticketmachine {
    public static Listnode doublenumber(Listnode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int carry = 0;
        Listnode result = null;
        while (!stack.isEmpty()) {
            int sum = stack.pop() * 2 + carry;
            carry = sum / 10;
            Listnode newnode = new Listnode(sum % 10);
            newnode.next = result;
            result = newnode;
        }
        if (carry > 0) {
            Listnode newnode = new Listnode(carry);
            newnode.next = result;
            result = newnode;
        }
        return result;
    }

    public static Listnode createlinkedlist(int[] digits) {
        Listnode dummy = new Listnode(0);
        Listnode current = dummy;
        for (int digit : digits) {
            current.next = new Listnode(digit);
            current = current.next;
        }
        return dummy.next;
    }

    public static void printList(Listnode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of digits:");
        int n = sc.nextInt();
        int[] digits = new int[n];
        System.out.print("enter digits of the ticket most significant to least:");
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }
        Listnode ticket = createlinkedlist(digits);
        Listnode doubleticket = doublenumber(ticket);
        System.out.print("Doubled ticket:");
        printList(doubleticket);
    }
}