import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        int[] ratings1 = {1,2,2};
        int[] ratings2 = {1,3,2,2,1};
        int[] ratings3 = {1,2,87,87,87,2,1};

        System.out.println(candy(ratings3));
    }

    public static int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;
        int result = 1;
        int previous = 1;
        int idxLocalMax = 0;
        int localMaxCandy = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                previous = previous + 1;
                result = result + previous;
                idxLocalMax = i;
                localMaxCandy = previous;
            } else if (ratings[i] < ratings[i - 1]) {
                if (previous == 1) {
                    if (i - idxLocalMax < localMaxCandy) {
                        result = result + i - idxLocalMax;
                    } else {
                        result = result + i - idxLocalMax + 1;
                        localMaxCandy = localMaxCandy + 1;
                    }
                } else {
                    previous = 1;
                    result = result + previous;
                }
            } else if (ratings[i] == ratings[i - 1]) {
                previous = 1;
                idxLocalMax = i;
                localMaxCandy = previous;
                result = result + previous;
            }
        }
        return result;
    }
}