import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] customerId = new int[100];
        double[] usage = new double[100];
        double[] bill = new double[100];
        int count = 0;

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Previous Reading: ");
        double previous = sc.nextDouble();

        System.out.print("Enter Current Reading: ");
        double current = sc.nextDouble();

        if (id <= 0 || previous < 0 || current < previous) {
            System.out.println("Invalid customer ID or meter readings.");
        } else {
            double consumption = current - previous;
            double rate;

            if (consumption <= 100) {
                rate = 2;
            } else if (consumption <= 200) {
                rate = 3;
            } else if (consumption <= 300) {
                rate = 4;
            } else {
                rate = 5;
            }

            double amount = consumption * rate;

            customerId[count] = id;
            usage[count] = consumption;
            bill[count] = amount;
            count++;

            System.out.println("\n--- Billing Record ---");
            System.out.println("Customer ID: " + id);
            System.out.println("Water Usage: " + consumption + " L");
            System.out.println("Total Bill: Rs." + amount);

            System.out.println("\n--- Usage Report ---");
            for (int i = 0; i < count; i++) {
                System.out.println("Customer ID: " + customerId[i]);
                System.out.println("Usage: " + usage[i] + " L");
                System.out.println("Bill: Rs." + bill[i]);
            }
        }

        sc.close();
    }
}