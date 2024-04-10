import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {0,0,1,1,1,1,2,2,3,3,4};
        int[] nums3 = {1,1,1,2,2,3};
        int[] nums4 = {0,0,1,1,1,1,2,3,3};
        int[] nums5 = {1,2,2,2};
        int[] nums6 = {1,1};
        int[] nums7 = {-3,-3,-2,-1,-1,0,0,0,0,0};
        System.out.println(removeDuplicates(nums3));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k-1] || nums[i] != nums[k-2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }
}