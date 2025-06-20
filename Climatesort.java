import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Climatesort {
    public ListNode sortbyat(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head.next;
        ListNode prev = head;
        while (curr != null) {
            if (curr.val < 0) {
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public ListNode createListFromArray(int[] arr) {
        if (arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 0; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Climatesort sorter = new Climatesort();
        System.out.print("Enter no. of elements: ");
        int n = sc.nextInt();
        int[] temp = new int[n];
        System.out.println("Enter " + n + " integers: ");
        for (int i = 0; i < n; i++) {
            temp[i] = sc.nextInt();
        }
        ListNode head = sorter.createListFromArray(temp);
        System.out.print("Before Sorting: ");
        sorter.printList(head);
        head = sorter.sortbyat(head);
        System.out.print("After Sorting: ");
        sorter.printList(head);
    }
}