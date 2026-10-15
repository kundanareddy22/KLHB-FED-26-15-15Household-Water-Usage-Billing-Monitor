import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Previous Water Usage: ");
        double previous = sc.nextDouble();

        System.out.print("Enter Current Water Usage: ");
        double current = sc.nextDouble();

        System.out.print("Enter Water Usage Limit: ");
        double limit = sc.nextDouble();

        if (previous < 0 || current < 0 || limit < 0) {
            System.out.println("Invalid input! Values cannot be negative.");
        } else {
            System.out.println("\n--- Water Monitoring Report ---");
            System.out.println("Previous Usage: " + previous + " units");
            System.out.println("Current Usage: " + current + " units");

            if (current > previous) {
                System.out.println("Usage increased by "
                        + (current - previous) + " units.");
            } else if (current < previous) {
                System.out.println("Usage decreased by "
                        + (previous - current) + " units.");
            } else {
                System.out.println("Usage remains unchanged.");
            }

            if (current > limit) {
                System.out.println("ALERT: High water consumption!");
                System.out.println("Please check your water usage.");
            } else {
                System.out.println("Water usage is within the limit.");
            }

            System.out.println("Please conserve water!");
        }

        sc.close();
    }
}