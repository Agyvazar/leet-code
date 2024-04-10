public class Main {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3};
        int[] nums2 = {3, 2, 2, 3, 3};
        int[] nums3 = {3};
        int[] nums4 = {0,1,2,2,3,0,4,2};
        int[] nums5 = {2,3,3};
        int val = 3;
        System.out.println(removeElement(nums5, val));
    }

    public static int removeElement(int[] nums, int val) {
        int occurrences = 0;
        int left_idx = 0;
        int right_idx = nums.length - 1;

        if (right_idx == -1) return 0;

        while (!indexesAreCloseEnough(left_idx, right_idx)) {
            if (nums[left_idx] == val && nums[right_idx] == val) {
                right_idx--;
            } else if (nums[left_idx] == val && nums[right_idx] != val) {
                nums[left_idx] = nums[right_idx];
                nums[right_idx] = val;
                right_idx--;
                left_idx++;
                occurrences++;
            } else if (nums[left_idx] != val) {
                left_idx++;
                occurrences++;
            }
        }

        if (right_idx == left_idx) {
            if (nums[left_idx] != val) {
                occurrences++;
            }
        } else {
            if (nums[left_idx] == val && nums[right_idx] != val) {
                nums[left_idx] = nums[right_idx];
                nums[right_idx] = val;
                occurrences++;
            } else {
                occurrences = nums[right_idx] != val ? occurrences + 2 : nums[left_idx] != val ? occurrences + 1 : occurrences;
            }
        }

        return occurrences;
    }

    public static boolean indexesAreCloseEnough(int left, int right) {
        int difference = right - left;
        return difference == 0 || difference == 1;
    }
}