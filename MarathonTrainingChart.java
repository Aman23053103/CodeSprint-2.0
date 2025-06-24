import java.util.Scanner;

public class MarathonTrainingChart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // Print motivational message if n > 10
        if (n > 10) {
            System.out.println("Abhik's marathon journey intensifies! Let's see his detailed zig-zag wave chart:");
        }

        // Calculate the maximum row length for center alignment
        int maxRowLength = calculateMaxRowLength(n);
        int totalValues = 0;

        // Generate and print each day's pattern
        for (int day = 1; day <= n; day++) {
            String row = generateDayRow(day);
            totalValues += day; // Each day has 'day' numbers

            // Center-align the row
            int padding = (maxRowLength - row.length()) / 2;
            String centeredRow = " ".repeat(padding) + row;

            System.out.println(centeredRow);
        }

        // Print the total count
        System.out.println("\nTotal values printed: " + totalValues);
    }
    private static int calculateMaxRowLength(int n) {
        int numberWidth = String.valueOf(n).length();
        return n * numberWidth + (n - 1) * 3;
    }
    private static String generateDayRow(int day) {
        StringBuilder row = new StringBuilder();

        if (day % 2 == 1) {
            for (int i = 1; i <= day; i++) {
                if (i > 1)
                    row.append("   ");
                row.append(i);
            }
        } else {
            for (int i = day; i >= 1; i--) {
                if (i < day)
                    row.append("   ");
                row.append(i);
            }
        }

        return row.toString();
    }
}