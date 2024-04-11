import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2};
//        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1) return;
        int j = 0;
        int replacementsDone = 0;
        while (replacementsDone < nums.length) {
            replacementsDone = replacementsDone + replaceRound(nums, k, j);
            j++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static int replaceRound(int[] nums, int k, int initialIndex) {
        int count = 1;
        int i = initialIndex + k >= nums.length ? (initialIndex + k) % nums.length : initialIndex + k;
        int swapLeftElement = nums[initialIndex];
        int swapRightElement;
        do {
            swapRightElement = nums[i];
            nums[i] = swapLeftElement;
            count++;
            i = i + k >= nums.length ? (i + k) % nums.length : i + k;
            swapLeftElement = swapRightElement;
        } while (i != initialIndex);
        nums[i] = swapLeftElement;
        return count;
    }
}