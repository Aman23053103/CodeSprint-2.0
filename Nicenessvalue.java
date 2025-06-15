import java.util.*;

public class Nicenessvalue {
    public static void main(String[] ars) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of words: ");
        int n = Integer.parseInt(sc.nextLine());
        String[] words = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }
        List<String> seewords = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int niceness = 0;
            for (int j = 0; j < i; j++) {
                if (seewords.get(j).compareTo(words[i]) < 0) {
                    niceness++;
                }
            }
            seewords.add(words[i]);
            System.out.println(niceness);
        }
    }
}