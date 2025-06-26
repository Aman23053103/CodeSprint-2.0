import java.util.*;

public class ZigZagappointment {
    public static List<Integer> zigzagrecorder(List<Integer> appointments) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = appointments.size() - 1;
        while (left <= right) {
            if (left == right) {
                result.add(appointments.get(left));
            } else {
                result.add(appointments.get(left));
                result.add(appointments.get(right));
            }
            left++;
            right--;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of appointments: ");
        int n = sc.nextInt();
        List<Integer> appointments = new ArrayList<>();
        System.out.println("Enter appointment IDs:");
        for (int i = 0; i < n; i++) {
            appointments.add(sc.nextInt());
        }
        List<Integer> reordered = zigzagrecorder(appointments);
        System.out.println("Zig-Zag Reordered appointment: ");
        for (int id : reordered) {
            System.out.print(id + " ");
        }

    }
}