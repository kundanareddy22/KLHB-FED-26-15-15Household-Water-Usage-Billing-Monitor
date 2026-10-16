import java.util.Scanner;

public class project7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Water Consumption (L): ");
        double consumption = scanner.nextDouble();

        if (consumption < 0) {
            System.out.println("Invalid water consumption!");
        } else {
            double rate;
            double bill;

            if (consumption <= 100) {
                rate = 2;
            } else if (consumption <= 200) {
                rate = 3;
            } else if (consumption <= 300) {
                rate = 4;
            } else {
                rate = 5;
            }

            bill = consumption * rate;

            System.out.println("\n--- Water Billing Summary ---");
            System.out.println("Household: ABC Residence");
            System.out.println("Water Consumed: " + consumption + " L");
            System.out.println("Applicable Rate: Rs." + rate + "/L");
            System.out.println("Total Bill: Rs." + bill);
        }

        scanner.close();
    }
}