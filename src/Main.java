public class Main {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";

        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        String[] array = s.split(" ");
        return array[array.length - 1].length();
    }
}