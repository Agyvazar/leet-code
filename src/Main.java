public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums2));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int currentNumber = nums[0];
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != currentNumber) {
                currentNumber = nums[i];
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}