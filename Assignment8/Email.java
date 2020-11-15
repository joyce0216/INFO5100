import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Email {
    private static final String PASSWORD_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
    private static final int PASSWORD_SET_SIZE = PASSWORD_SET.length();
    private static final Random RANDOM = new Random();
    private static final Map<Integer, String> departmentCode = new HashMap<Integer, String>() {{
        put(0, null);
        put(1, "sales");
        put(2, "development");
        put(3, "accounting");
    }};

    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "joyce.com";
    private String department;
    private String address;
    private String alternateAddress;
    private String password = "";
    private String firstName;
    private String lastName;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println(String.format("New Worker: %s", this.getName()));
            System.out.println("Department Codes:\n" +
                                       "1 for Sales\n" +
                                       "2 for Development\n" +
                                       "3 for Accounting\n" +
                                       "0 for none\n" +
                                       "Enter department code: ");

            this.department = departmentCode.get(scanner.nextInt());
        }

        this.generateAddress();
        this.generatePassword(8);
    }

    private void generateAddress() {
        String domain = department == null ? companySuffix :  String.join(".", department, companySuffix);
        this.address = String.format("%s.%s@%s", firstName, lastName, domain);
    }

    private void generatePassword(int length) {
        for (int i = 0; i < length; i++) {
            password += PASSWORD_SET.charAt(RANDOM.nextInt(PASSWORD_SET_SIZE));
        }
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateAddress(String alternateAddress) {
        this.alternateAddress = alternateAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String showInfo() {
        return String.format("DISPLAY NAME: %s\n" +
                                     "DEPARTMENT: %s\n" +
                                     "COMPANY EMAIL: %s\n" +
                                     "PASSWORD: %s\n" +
                                     "MAILBOX CAPACITY: %dmb",
                             getName(), this.department, getAddress(), password, getMailboxCapacity());
    }
}