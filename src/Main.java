public class Main {
    public static void main(String[] args) {
        int[] nums = {3,0,6,1,5};

        System.out.println(hIndex(nums));
    }

    public static int hIndex(int[] citations) {
        int[] distribution = new int[1001];

        for (int citation : citations) {
            distribution[citation]++;
        }

        int accumulator = 0;

        for (int i = distribution.length - 1; i > 0; i--) {
            accumulator = accumulator + distribution[i];
            if (accumulator >= i) return i;
        }
        return 0;
    }
}