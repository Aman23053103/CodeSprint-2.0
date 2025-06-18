import java.util.*;

public class Bookinsert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of books on the shelf: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the sorted book numbers: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the no of new book: ");
        int target = sc.nextInt();
        int index = searchinsert(nums, target);
        System.out.println("The correct index for the book is: " + index);
    }

    public static int searchinsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}
