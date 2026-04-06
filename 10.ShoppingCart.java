import java.util.Scanner;

public class ShoppingCart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String products[] = {"Laptop", "Phone", "Headphones", "Keyboard"};
        int prices[] = {50000, 20000, 2000, 1500};

        int cartQty[] = new int[products.length];

        int choice;

        do {

            System.out.println("\n===== Shopping Cart Menu =====");
            System.out.println("1. Display Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.println("\n--- Product List ---");
                    for(int i = 0; i < products.length; i++) {
                        System.out.println((i+1) + ". " + products[i] + " - ₹" + prices[i]);
                    }
                    break;

                case 2:
                    System.out.print("Enter product number: ");
                    int add = sc.nextInt();

                    if(add >= 1 && add <= products.length) {

                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();

                        cartQty[add-1] += qty;

                        System.out.println(products[add-1] + " added to cart.");
                    } else {
                        System.out.println("Invalid product!");
                    }
                    break;

                case 3:
                    System.out.print("Enter product number to remove: ");
                    int remove = sc.nextInt();

                    if(remove >= 1 && remove <= products.length) {

                        cartQty[remove-1] = 0;

                        System.out.println(products[remove-1] + " removed from cart.");
                    } else {
                        System.out.println("Invalid product!");
                    }
                    break;

                case 4:

                    System.out.println("\n----- Cart Items -----");

                    int total = 0;

                    for(int i = 0; i < products.length; i++) {

                        if(cartQty[i] > 0) {

                            int cost = cartQty[i] * prices[i];
                            total += cost;

                            System.out.println(products[i] +
                                    " | Price: ₹" + prices[i] +
                                    " | Qty: " + cartQty[i] +
                                    " | Cost: ₹" + cost);
                        }
                    }

                    System.out.println("Total Bill: ₹" + total);
                    break;

                case 5:

                    System.out.println("\n===== FINAL BILL =====");

                    int finalTotal = 0;

                    for(int i = 0; i < products.length; i++) {

                        if(cartQty[i] > 0) {

                            int cost = cartQty[i] * prices[i];
                            finalTotal += cost;

                            System.out.println(products[i] +
                                    " | Qty: " + cartQty[i] +
                                    " | Cost: ₹" + cost);
                        }
                    }

                    System.out.println("----------------------");
                    System.out.println("Total Amount: ₹" + finalTotal);
                    System.out.println("Thank you for shopping!");

                    break;

                default:
                    System.out.println("Invalid choice!");

            }

        } while(choice != 5);

        sc.close();
    }
}