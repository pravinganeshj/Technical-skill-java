import java.util.Scanner;

public class StudentResultSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        String name[] = new String[n];
        int marks[][] = new int[n][3];
        int total[] = new int[n];
        double avg[] = new double[n];
        char grade[] = new char[n];

        for(int i = 0; i < n; i++) {

            System.out.print("\nEnter student name: ");
            name[i] = sc.nextLine();

            total[i] = 0;

            for(int j = 0; j < 3; j++) {
                System.out.print("Enter marks for subject " + (j+1) + ": ");
                marks[i][j] = sc.nextInt();
                total[i] += marks[i][j];
            }

            avg[i] = total[i] / 3.0;

            if(avg[i] >= 90)
                grade[i] = 'A';
            else if(avg[i] >= 75)
                grade[i] = 'B';
            else if(avg[i] >= 50)
                grade[i] = 'C';
            else
                grade[i] = 'F';

            sc.nextLine();
        }

        System.out.println("\n----- Student Result Table -----");
        System.out.println("Name\tTotal\tAverage\tGrade");

        for(int i = 0; i < n; i++) {
            System.out.println(name[i] + "\t" + total[i] + "\t" + avg[i] + "\t" + grade[i]);
        }

        sc.close();
    }
}