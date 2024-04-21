import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        int num = 58;

        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder(100);
        var wrapper = new Object(){ int ordinal = num;};
        LinkedHashMap<Integer, String> romanNumbers = new LinkedHashMap<>();
        romanNumbers.put(1000, "M");
        romanNumbers.put(900, "CM");
        romanNumbers.put(500, "D");
        romanNumbers.put(400, "CD");
        romanNumbers.put(100, "C");
        romanNumbers.put(90, "XC");
        romanNumbers.put(50, "L");
        romanNumbers.put(40, "XL");
        romanNumbers.put(10, "X");
        romanNumbers.put(9, "IX");
        romanNumbers.put(5, "V");
        romanNumbers.put(4, "IV");
        romanNumbers.put(1, "I");
        Consumer<Map.Entry<Integer, String>> action = entry -> {
            while (wrapper.ordinal >= entry.getKey()) {
                stringBuilder.append(entry.getValue());
                wrapper.ordinal = wrapper.ordinal - entry.getKey();
            }
        };
        romanNumbers.sequencedEntrySet().iterator().forEachRemaining(action);
        return stringBuilder.toString();
    }


}