import java.util.*;
import java.util.function.IntUnaryOperator;

public class PatternGenerator {

    public static void main(String[] args) {

        Map<String, IntUnaryOperator> patterns = new HashMap<>();

        patterns.put("square", n -> n * n);
        patterns.put("cube", n -> n * n * n);
        patterns.put("weird", n -> (n * n) + (2 * n));

        String selected = "weird";

        for (int i = 1; i <= 5; i++) {
            System.out.print(patterns.get(selected).applyAsInt(i) + " ");
        }
    }
}
