public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,1,1,1};
        int[] nums1 = {10,9,8,7,6,5,4,3,2,1,1,0};

        System.out.println(canJump(nums1));
    }

    public static int canJump(int[] nums) {
        if (nums.length == 1) return 0;
        int start = 0;
        int jumps = 1;
        while (start + nums[start] < nums.length - 1) {
            start = findMaxIdx(nums, start + 1, nums[start]);
            jumps++;
        }
        return jumps;
    }

    public static int findMaxIdx(int[] nums, int start, int jumpLength) {
        int max = 0;
        int maxIdx = start;
        for (int i = start; i <= start + jumpLength - 1; i++) {
            if (max <= nums[i] + i - maxIdx) {
                maxIdx = i;
                max = nums[i];
            }
        }
        return maxIdx;
    }
}