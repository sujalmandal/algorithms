package algo;

import java.util.HashMap;
import java.util.Map;

public class HasPermutation {
    public static void main(String[] args) {
        System.out.println(hasPermutation("adc", "dcda"));
    }

    public static boolean hasPermutation(String str, String original){
        Map<Character, Integer> charFreqMap = getCharCountMap(str);
        System.out.println("charFreqMap = " + charFreqMap);
        System.out.println(original);
        for(int index=0; index <= original.length() - str.length(); index++){
            char curr=original.charAt(index);
            if(!charFreqMap.containsKey(curr)) continue;
            String substring = original.substring(index, index + str.length());
            System.out.println(String.format("char matched %s, scanning substring %s",curr, substring));
            Map<Character,Integer> subArrFreqMap = getCharCountMap(substring);
            if(subArrFreqMap.equals(charFreqMap)) return true;
        }
        return false;
    }

    private static Map<Character, Integer> getCharCountMap(String str) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        /** count the frequency */
        for(char ch : str.toCharArray()) {
            charFreqMap.putIfAbsent(ch,0);
            charFreqMap.computeIfPresent(ch, (k,v)->v+1);
        }
        return charFreqMap;
    }

}
