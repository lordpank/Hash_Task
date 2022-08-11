import java.util.HashMap;
import java.util.Map;

public class Main {

    static String inputString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
            "Ut enim ad minim veniam, quis nostrud exercitation " +
            "ullamco laboris nisi ut aliquip ex ea commodo consequat." +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
            "Excepteur sint occaecat cupidatat non proident," +
            "sunt in culpa qui officia deserunt mollit anim id est laborum.";

    private static String inputString() {
        String textLowerCase = inputString.toLowerCase();
        return textLowerCase.replaceAll("\\s", "");
    }

    public static void main(String[] args) {
        char[] letters = inputString().toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < letters.length; i++) {
            char letter = inputString().charAt(i);
            if (!map.containsKey(letter)) {
                map.put(letter, 1);
            } else {
                int calculation = map.get(letter);
                calculation++;
                map.put(letter, calculation);
            }
        }

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        for (int calculation : map.values()) {
            if (calculation > maximum) {
                maximum = calculation;
            }
            if (calculation < minimum) {
                minimum = calculation;
            }
        }

        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            if (kv.getValue() == minimum) {
                System.out.println("Буква " + kv.getKey() + " в тексте используется минимальное количество раз. Встретилась " + kv.getValue() + " раз.");
            }
            if (kv.getValue() == maximum) {
                System.out.println("Буква " + kv.getKey() + " в тексте используется максимальное количество раз. Встретилась " + kv.getValue() + " раз.");
            }
        }
    }
}