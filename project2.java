import java.util.Scanner;

public class project2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Previous Reading: ");
            double previous = scanner.nextDouble();

            System.out.print("Enter Current Reading: ");
            double current = scanner.nextDouble();

            if (previous < 0 || current < 0) {
                System.out.println("Invalid: Readings cannot be negative.");
            } else if (current < previous) {
                System.out.println("Invalid: Current reading cannot be less than previous reading.");
            } else {
                MeterReading meter = new MeterReading(previous, current);

                System.out.println("Water Consumed: "
                        + meter.calculateConsumption() + " L");
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Enter numeric readings.");
        } finally {
            scanner.close();
        }
    }
}

class MeterReading {
    private double previousReading;
    private double currentReading;

    public MeterReading(double previousReading, double currentReading) {
        this.previousReading = previousReading;
        this.currentReading = currentReading;
    }

    public double calculateConsumption() {
        return currentReading - previousReading;
    }
}