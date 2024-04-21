import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;
        int[] toRightPeaks = new int[height.length];
        int[] toLeftPeaks = new int[height.length];

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(height[i], max);
            toRightPeaks[i] = max;
        }

        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            toLeftPeaks[i] = max;
        }

        int water = 0;

        for (int i = 1; i < height.length - 1; i++) {
            water = water + Math.max(Math.min(toRightPeaks[i - 1], toLeftPeaks[i + 1]) - height[i], 0);
        }
        return water;
    }
}