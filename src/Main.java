import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {2,2,1,1,1,2,2};
        int[] nums2 = {0,0,1,1,1,1,2,2,3,3,4};

        System.out.println(majorityElement(nums1));
    }

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count++;
                }
            }
        }

        return candidate;
    }
}