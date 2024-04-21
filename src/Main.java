public class Main {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int minLength = prefix.length();
        for (int i = 1; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
            for (int j = 0; j < minLength; j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    minLength = j;
                    break;
                }
            }
        }
        return prefix.substring(0, minLength);
    }
}