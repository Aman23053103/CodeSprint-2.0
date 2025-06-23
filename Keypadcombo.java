import java.util.*;

public class Keypadcombo {
    private static final Map<Character, String> keypadmap = new HashMap<>();
    static {
        keypadmap.put('2', "abc");
        keypadmap.put('3', "def");
        keypadmap.put('4', "ghi");
        keypadmap.put('5', "jkl");
        keypadmap.put('6', "mno");
        keypadmap.put('7', "pqrs");
        keypadmap.put('8', "tuv");
        keypadmap.put('9', "wxyz");
    }

    public static List<String> lettercombo(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder combination, String digits, int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }
        String letters = keypadmap.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            combination.append(c);
            backtrack(result, combination, digits, index + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter digits(2-9: ");
        String input = sc.nextLine();
        List<String> combination = lettercombo(input);
        System.out.println("Possible combination: " + combination);
    }
}
