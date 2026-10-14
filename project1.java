public class project1 {
    public static void main(String[] args) {
        UserProfile user1 = new UserProfile(
            "Rahul", "24A91", "9876543210"
        );

        System.out.println("Customer Name: " + user1.getName());
        System.out.println("Roll Number: " + user1.getRollNo());
        System.out.println("Contact Number: " + user1.getContact());
    }
}

class UserProfile {
    private String name;
    private String rollNo;
    private String contact;

    public UserProfile(String name, String rollNo, String contact) {
        this.name = name;
        this.rollNo = rollNo;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getContact() {
        return contact;
    }
}