public class project5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Previous Water Usage (units): ");
        double previousUsage = sc.nextDouble();

        System.out.print("Enter Current Water Usage (units): ");
        double currentUsage = sc.nextDouble();

        System.out.print("Enter Water Usage Limit (units): ");
        double limit = sc.nextDouble();

        if (previousUsage < 0 || currentUsage < 0 || limit < 0) {
            System.out.println("Invalid input! Values cannot be negative.");
        } else {
            System.out.println("\n--- Water Usage Monitoring Report ---");
            System.out.println("Previous Usage: " + previousUsage + " units");
            System.out.println("Current Usage: " + currentUsage + " units");

            if (currentUsage > previousUsage) {
                System.out.println("Usage has increased by "
                        + (currentUsage - previousUsage) + " units.");
            } else if (currentUsage < previousUsage) {
                System.out.println("Usage has decreased by "
                        + (previousUsage - currentUsage) + " units.");
            } else {
                System.out.println("Water usage remains unchanged.");
            }

            if (currentUsage > limit) {
                System.out.println("ALERT: High water consumption!");
                System.out.println("Please check your water usage.");
            } else {
                System.out.println("Water usage is within the limit.");
            }

            System.out.println("Conserve water and avoid wastage!");
        }

        sc.close();
    }
}