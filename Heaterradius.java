import java.util.*;

public class Heaterradius {
    public static int findradius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;
        for (int house : houses) {
            int closestheater = findclosestheater(house, heaters);
            radius = Math.max(radius, closestheater);
        }
        return radius;
    }

    private static int findclosestheater(int house, int[] heaters) {
        int left = 0, right = heaters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] < house) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int dist1 = (left < heaters.length) ? Math.abs(heaters[left] - house) : Integer.MAX_VALUE;
        int dist2 = (right >= 0) ? Math.abs(heaters[right] - house) : Integer.MAX_VALUE;
        return Math.min(dist1, dist2);
    }

    public static int[] parseInput(String line) {
        int start = line.indexOf('[');
        int end = line.indexOf(']');
        String[] parts = line.substring(start + 1, end).split(",");
        return Arrays.stream(parts).map(String::trim).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter houses:");
        String houseline = sc.nextLine();
        System.out.println("Enter heaters:");
        String heaterline = sc.nextLine();
        int[] houses = parseInput(houseline);
        int[] heaters = parseInput(heaterline);
        int result = findradius(houses, heaters);
        System.out.println("Output: " + result);
    }
}