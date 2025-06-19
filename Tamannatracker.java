import java.util.*;

public class Tamannatracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (line.startsWith("PUSH")) {
                int x = Integer.parseInt(line.split(" ")[1]);
                mainStack.push(x);
                if (minStack.isEmpty() || x <= minStack.peek()) {
                    minStack.push(x);
                } else {
                    minStack.push(minStack.peek());
                }
            } else if (line.equals("POP")) {
                if (!mainStack.isEmpty()) {
                    mainStack.pop();
                    minStack.pop();
                }
            } else if (line.equals("MIN")) {
                if (minStack.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(minStack.peek());
                }
            }
        }
    }
}