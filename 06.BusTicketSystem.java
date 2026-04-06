import java.util.Scanner;

public class BusTicketSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int seats[] = new int[10]; // 0 = available, 1 = booked
        int choice = 0;

        while(choice != 4) {

            System.out.println("\n===== BUS TICKET BOOKING SYSTEM =====");
            System.out.println("1. Show Seat Layout");
            System.out.println("2. Book a Seat");
            System.out.println("3. Show Booked Seats");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // Show seat layout
            if(choice == 1) {

                System.out.println("\nSeat Layout (O = Available, X = Booked)");

                for(int i = 0; i < seats.length; i++) {

                    if(seats[i] == 0)
                        System.out.print("[ " + (i+1) + " O ] ");
                    else
                        System.out.print("[ " + (i+1) + " X ] ");

                    if((i+1) % 2 == 0)
                        System.out.println();
                }
            }

            // Book seat
            else if(choice == 2) {

                System.out.print("Enter seat number (1-10): ");
                int seat = sc.nextInt();

                if(seat < 1 || seat > 10) {

                    System.out.println("Invalid seat number!");

                }
                else if(seats[seat-1] == 1) {

                    System.out.println("Seat already booked!");

                }
                else {

                    seats[seat-1] = 1;
                    System.out.println("Seat " + seat + " successfully booked.");
                }
            }

            // Show booked seats
            else if(choice == 3) {

                System.out.println("\nBooked Seats:");

                boolean found = false;

                for(int i = 0; i < seats.length; i++) {

                    if(seats[i] == 1) {

                        System.out.println("Seat " + (i+1));
                        found = true;
                    }
                }

                if(!found)
                    System.out.println("No seats booked yet.");
            }

            else if(choice == 4) {

                System.out.println("Thank you for using Bus Booking System!");

            }

            else {

                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}