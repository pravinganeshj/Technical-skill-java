import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    String grade;
    Student next;

    Student(String name, int rollNo, String grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
        this.next = null;
    }
}
class StudentList {
    Student head = null;
    public void addStudent(String name, int rollNo, String grade) {
        Student newNode = new Student(name, rollNo, grade);

        if (head == null) {
            head = newNode;
        } else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Student added");
    }
    public void display() {
        if (head == null) {
            System.out.println("No records");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.name +
                               ", Roll: " + temp.rollNo +
                               ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
    public void search(int rollNo) {
        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Found: " + temp.name +
                                   ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
    }
    public void delete(int rollNo) {
        if (head == null) {
            System.out.println("List empty");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Deleted");
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            if (temp.next.rollNo == rollNo) {
                temp.next = temp.next.next;
                System.out.println("Deleted");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }
}
public class Student_managment_system {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();

        while (true) {
            System.out.println("\n1.Add 2.Display 3.Search 4.Delete 5.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter roll no: ");
                    int roll = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();

                    list.addStudent(name, roll, grade);
                    break;

                case 2:
                    list.display();
                    break;

                case 3:
                    System.out.print("Enter roll to search: ");
                    list.search(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter roll to delete: ");
                    list.delete(sc.nextInt());
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
                    sc.close();
            }
        }
    }
}