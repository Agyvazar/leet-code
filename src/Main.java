import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,1,6,1,5};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int product = 1;
        for (int i = 0; i < n; i++) {
            result[i] = product;
            product = product * nums[i];
        }

        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * product;
            product = product * nums[i];
        }

        return result;
    }
}