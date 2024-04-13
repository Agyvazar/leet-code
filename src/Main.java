public class Main {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};

        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int jumpRequired = 1;
        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i] < jumpRequired) {
                jumpRequired++;
            } else {
                jumpRequired = 1;
            }
        }
        return jumpRequired <= nums[0];
    }
}