import java.util.Scanner;

public class SecureLoginSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String correctUser = "admin";
        String correctPass = "java123";

        int attempts = 0;

        System.out.println("=== Secure Login Portal ===");

        while(attempts < 3) {

            System.out.print("Enter Username: ");
            String user = sc.nextLine();

            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            if(user.equals(correctUser) && pass.equals(correctPass)) {

                System.out.println("\n Access Granted!");
                System.out.println("Welcome to the system, " + user + "!");
                break;

            } else {

                attempts++;

                System.out.println("\n Invalid credentials!");

                if(attempts < 3) {
                    System.out.println("Attempts remaining: " + (3 - attempts));
                }
            }
        }

        if(attempts == 3) {
            System.out.println("\n System Locked!");
            System.out.println("Too many failed attempts.");
        }

        sc.close();
    }
}