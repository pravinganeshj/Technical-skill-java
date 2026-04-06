import java.util.Scanner;

public class RestaurantOrder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;
        int total = 0;

        do {

            System.out.println("\n----- Restaurant Menu -----");
            System.out.println("1. Burger - ₹150");
            System.out.println("2. Pizza - ₹300");
            System.out.println("3. Pasta - ₹200");
            System.out.println("4. Sandwich - ₹120");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    total += 150;
                    System.out.println("Burger added to order");
                    break;

                case 2:
                    total += 300;
                    System.out.println("Pizza added to order");
                    break;

                case 3:
                    total += 200;
                    System.out.println("Pasta added to order");
                    break;

                case 4:
                    total += 120;
                    System.out.println("Sandwich added to order");
                    break;

                case 5:
                    System.out.println("Order completed.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while(choice != 5);

        System.out.println("Total Bill: ₹" + total);

        sc.close();
    }
}