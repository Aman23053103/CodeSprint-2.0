import java.util.*;

public class Sandwichqueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> students = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            students.offer(sc.nextInt());
        }
        int[] sandwiches = new int[n];
        for (int i = 0; i < n; i++) {
            sandwiches[i] = sc.nextInt();
        }
        int sandwichindex = 0;
        int rotations = 0;
        while (!students.isEmpty() && rotations < students.size()) {
            if (students.peek() == sandwiches[sandwichindex]) {
                students.poll();
                sandwichindex++;
                rotations = 0;
            } else {
                students.offer(students.poll());
                rotations++;
            }
        }
        System.out.println("ans:" + students.size());
    }
}