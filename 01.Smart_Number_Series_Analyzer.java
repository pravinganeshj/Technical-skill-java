import java.util.*;

public class SmartSeriesAnalyzer {

    static int detectPattern(int[] arr) {
        int scoreArithmetic = 0;
        int scoreGeometric = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            int d1 = arr[i] - arr[i - 1];
            int d2 = arr[i + 1] - arr[i];

            if (d1 == d2) scoreArithmetic++;

            if (arr[i - 1] != 0 && arr[i] % arr[i - 1] == 0) {
                if ((arr[i] / arr[i - 1]) == (arr[i + 1] / arr[i]))
                    scoreGeometric++;
            }
        }

        if (scoreArithmetic > scoreGeometric) return 1;
        if (scoreGeometric > scoreArithmetic) return 2;
        return 0;
    }

    static int predictNext(int[] arr, int type) {
        if (type == 1) {
            int diff = arr[arr.length - 1] - arr[arr.length - 2];
            return arr[arr.length - 1] + diff;
        } else if (type == 2) {
            int ratio = arr[arr.length - 1] / arr[arr.length - 2];
            return arr[arr.length - 1] * ratio;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 12, 24};

        int type = detectPattern(arr);

        if (type == 1)
            System.out.println("Detected: Arithmetic");
        else if (type == 2)
            System.out.println("Detected: Geometric");
        else
            System.out.println("Pattern unclear");

        System.out.println("Next: " + predictNext(arr, type));
    }
}
