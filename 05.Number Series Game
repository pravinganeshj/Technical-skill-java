import java.util.*;

public class NumberGameAI {

    static Random rand = new Random();

    static int level = 1;

    static int generateNext(int base) {
        return base + (level * 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        int current = rand.nextInt(5) + 1;

        for (int i = 0; i < 5; i++) {

            int next = generateNext(current);

            System.out.println("Current: " + current);
            System.out.print("Guess next: ");
            int guess = sc.nextInt();

            if (guess == next) {
                System.out.println("Correct!");
                score++;
                level++; // increase difficulty
            } else {
                System.out.println("Wrong! Correct was " + next);
                level = Math.max(1, level - 1);
            }

            current = next;
        }

        System.out.println("Final Score: " + score);
    }
}
