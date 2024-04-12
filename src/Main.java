import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 6, 4, 3, 10};

        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int profit = 0;
        int min = prices[0];
        int maxIdx = 0;
        for (int start = 0; start < length - 1; start++) {
            if (prices[start] > min) {
                continue;
            }
            if (start < maxIdx) {
                profit = profit + min - prices[start];
                min = prices[start];
                continue;
            }
            for (int end = start + 1; end < length; end++) {
                if (prices[start] < prices[end]) {
                    if (prices[end] - prices[start] > profit) {
                        profit = prices[end] - prices[start];
                        min = prices[start];
                        maxIdx = end;
                    }
                }
            }
        }
        return profit;
    }
}