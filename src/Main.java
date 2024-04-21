import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "MCMXCIV";

        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            switch (chars[i]) {
                case 'M': result += 1000; break;
                case 'D': result += 500; break;
                case 'C': result += result < 300 ? 100 : -100; break;
                case 'L': result += 50; break;
                case 'X': result += result < 30 ? 10 : -10; break;
                case 'V': result += 5; break;
                case 'I': result += result < 3 ? 1 : -1; break;
            }
        }
        return result;
    }
}