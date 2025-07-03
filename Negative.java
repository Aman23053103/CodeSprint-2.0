import java.util.Scanner;
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}
public class Negative{
    public static void ProcessInput(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException("number should be +ve");
        } else {
            System.out.println("Double value: " + (number * 2));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a no: ");
        int no = sc.nextInt();

        try {
            ProcessInput(no);
        } catch (NegativeNumberException e) {
            System.out.println("Exception occurred: " + e);
        }
    }
}

