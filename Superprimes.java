import java.util.*;

public class Superprimes {
    public static List<Integer> generateprimes(int n) {
        boolean[] isprime = new boolean[n + 1];
        Arrays.fill(isprime, true);
        isprime[0] = isprime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isprime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isprime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isprime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static List<Integer> findsuperprimes(int n) {
        List<Integer> primes = generateprimes(n);
        List<Integer> superprimes = new ArrayList<>();
        List<Integer> primeindices = generateprimes(primes.size());
        Set<Integer> primeindexset = new HashSet<>(primeindices);
        for (int i = 0; i < primes.size(); i++) {
            int position = i + 1;
            if (primeindexset.contains(position)) {
                superprimes.add(primes.get(i));
            }
        }
        return superprimes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a no n: ");
        int n = sc.nextInt();
        List<Integer> superprimes = findsuperprimes(n);
        for (int sp : superprimes) {
            System.out.print(sp + " ");
        }
        System.out.println();
    }
}