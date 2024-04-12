import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 6, 4, 3, 10};
        int[] nums1 = {7,1,5,3,6,4};

        System.out.println(maxProfit(nums1));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int length = prices.length;
        int maxIdx = 0;
        int minIdx;
        int start = 0;
        while (start < length) {
            maxIdx = findIdxOfMax(prices, start, length);
            minIdx = findIdxOfMin(prices, start, maxIdx);
            profit = Math.max(profit, prices[maxIdx] - prices[minIdx]);
            start = maxIdx + 1;
        }
        return profit;
    }

    public static int findIdxOfMax(int[] prices, int start, int end) {
        int maxIdx = start;
        for (int i = start; i < end; i++) {
            if (prices[i] >= prices[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public static int findIdxOfMin(int[] prices, int start, int end) {
        int minIdx = 0;
        for (int i = start; i < end; i++) {
            if (prices[i] < prices[minIdx]) {
                minIdx = i;
            }
        }
        return minIdx;
    }
}