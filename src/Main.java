import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5,6,4,3,10};

        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        for (int price : prices) {
            buy = Math.min(buy, price);
            sell = Math.max(sell, price - buy);
        }
        return sell;
    }
}