import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] gas = {5,1,2,3,4};
        int[] cost = {4,4,1,5,1};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] peaks = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            peaks[i] = gas[i] - cost[i];
        }
        System.out.println(Arrays.toString(peaks));

        int startPos = 0;
        int idx = 0;
        int accumulator = 0;
        if (Arrays.stream(peaks).sum() < 0) return -1;
        for (int i = 0; i < peaks.length; i++) {
            accumulator = accumulator + peaks[idx];
            if (accumulator < 0) {
                accumulator = 0;
                i = 0;
                startPos = idx == peaks.length - 1 ? 0 : idx + 1;
            }
            idx = idx == peaks.length - 1 ? 0 : idx + 1;

        }
        return startPos;
    }
}