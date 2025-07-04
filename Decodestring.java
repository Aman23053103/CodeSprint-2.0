import java.util.*;

public class Decodestring {
  public static String decodestring(String s) {
    Stack<Integer> counts = new Stack<>();
    Stack<StringBuilder> result = new Stack<>();
    StringBuilder current = new StringBuilder();
    int index = 0;
    while (index < s.length()) {
      char ch = s.charAt(index);
      if (Character.isDigit(ch)) {
        int count = 0;
        while (Character.isDigit(s.charAt(index))) {
          count = count * 10 + (s.charAt(index) - '0');
          index++;
        }
        counts.push(count);
      } else if (ch == '[') {
        result.push(current);
        current = new StringBuilder();
        index++;
      } else if (ch == ']') {
        StringBuilder temp = current;
        current = result.pop();
        int repeattimes = counts.pop();
        while (repeattimes-- > 0) {
          current.append(temp);
        }
        index++;
      } else {
        current.append(ch);
        index++;
      }
    }
    return current.toString();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter encoded string: ");
    String input = sc.nextLine();
    String output = decodestring(input);
    System.out.println("Decoded string: " + output);
  }
}