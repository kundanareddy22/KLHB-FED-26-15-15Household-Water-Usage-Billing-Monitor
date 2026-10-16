import java.sql.*;
import java.util.Scanner;

public class project9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/water_billing";
        String user = "root";
        String password = "your_password";

        try (Connection con =
                 DriverManager.getConnection(url, user, password)) {

            System.out.println("Database connected successfully!");

            System.out.print("Enter Customer ID: ");
            int customerId = sc.nextInt();

            System.out.print("Enter Previous Reading: ");
            double previous = sc.nextDouble();

            System.out.print("Enter Current Reading: ");
            double current = sc.nextDouble();

            if (customerId <= 0 || previous < 0 || current < previous) {
                System.out.println("Invalid customer ID or meter readings.");
                return;
            }

            double usage = current - previous;
            double rate;

            if (usage <= 100) {
                rate = 2;
            } else if (usage <= 200) {
                rate = 3;
            } else if (usage <= 300) {
                rate = 4;
            } else {
                rate = 5;
            }

            double bill = usage * rate;

            String sql = "INSERT INTO bills " +
                "(customer_id, previous_reading, current_reading, " +
                "usage, amount, payment_status) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, customerId);
                ps.setDouble(2, previous);
                ps.setDouble(3, current);
                ps.setDouble(4, usage);
                ps.setDouble(5, bill);
                ps.setString(6, "UNPAID");
                ps.executeUpdate();
            }

            System.out.println("\n--- Billing Record ---");
            System.out.println("Customer ID: " + customerId);
            System.out.println("Previous Reading: " + previous + " L");
            System.out.println("Current Reading: " + current + " L");
            System.out.println("Water Usage: " + usage + " L");
            System.out.println("Total Bill: Rs." + bill);

            System.out.println("\n--- Previous Billing Records ---");

            String query = "SELECT * FROM bills WHERE customer_id = ?";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, customerId);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(
                            "Bill ID: " + rs.getInt("bill_id") +
                            ", Usage: " + rs.getDouble("usage") +
                            " L, Amount: Rs." + rs.getDouble("amount") +
                            ", Status: " + rs.getString("payment_status")
                        );
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}