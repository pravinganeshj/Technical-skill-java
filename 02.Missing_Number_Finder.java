public class MissingNumberAdvanced {

    public static void main(String[] args) {
        int[] arr = {10, 11, 13, 14, 15};

        int xorAll = 0;
        int xorArr = 0;

        int min = arr[0];
        int max = arr[arr.length - 1];

        for (int i = min; i <= max; i++) {
            xorAll ^= i;
        }

        for (int num : arr) {
            xorArr ^= num;
        }

        int missing = xorAll ^ xorArr;

        System.out.println("Missing number: " + missing);
    }
}
