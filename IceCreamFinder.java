import java.util.*;

public class IceCreamFinder {
    public static boolean can_buyIceCream(int budget, int[] IceCreamPrices) {
        if (budget < 0 || IceCreamPrices == null)
            return false;
        for (int price : IceCreamPrices) {
            if (price == budget) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your budget:");
        int budget = sc.nextInt();
        System.out.println("Enter the no. of IceCream:");
        int n = sc.nextInt();
        int[] IceCreamPrices = new int[n];
        System.out.println("Enter the price:");
        for (int i = 0; i < n; i++) {
            IceCreamPrices[i] = sc.nextInt();
        }
        boolean result = can_buyIceCream(budget, IceCreamPrices);
        System.out.println(result);
    }
}
