package P02_firstNonRepeatedCharacter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class FirstNonRepeatedCharacter {

    private static final int EXTENDED_ASCII_CODES = 256; //can be incresed to 65,535

    private FirstNonRepeatedCharacter() { throw new AssertionError("cannot be instantiated..");}

    public static char firstNonRepeatedCharV1(String str) {

        if(str == null || str.isBlank()){
            return Character.MIN_VALUE;
        }

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if(ch == str.charAt(j) && i != j){
                    count++;
                }
            }

            if(count == 0) {
                return ch;
            }
        }
         return Character.MIN_VALUE;
    }

    public static char firstNonRepeatedCharV2(String str) {

        if(str == null || str.isBlank()) {
            return Character.MIN_VALUE;
        }

        // create a new list with  size of ascii codes
        int[] flags = new int[EXTENDED_ASCII_CODES];

        // loop through the flags list and assign -1 to all element
        for (int i = 0; i < flags.length; i++) {
            flags[i] = -1;

        }

        for (int i = 0; i < str.length() ; i++) {
            char ch = str.charAt(i);
            if(flags[ch] == -1) {
                flags[ch] = i;
            } else {
                flags[ch] = -2;
            }
        }

        int position = Integer.MAX_VALUE;
        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0) position = Math.min(position, flags[i]);

        }

        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
    }

    public static char firstNonRepeatedCharV3(String str) {
        if (str == null || str.isBlank()) return Character.MIN_VALUE;

        Map<Character, Integer> chars = new LinkedHashMap<>();

        for(char ch : str.toCharArray()){
            chars.compute(ch, (k,v) -> (v == null) ? 1 : ++v);

        }
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return Character.MIN_VALUE;
    }

    public static  char firstNonRepeatedCharV4(String str) {
        if (str == null || str.isBlank()) return Character.MIN_VALUE;

        Map<Integer, Long> chs = str.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

        return (char) (int) chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));
    }

    public static String firstNonRepeatedCharVCP4(String str) {

        if (str == null || str.isBlank()) return String.valueOf(Character.MIN_VALUE);

        Map<Integer, Long> integerLongMap = str.codePoints()
                .mapToObj(cp -> cp)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        int cp = integerLongMap.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));

        return String.valueOf(Character.toChars(cp));
    }


}
