package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println("lists = " + lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams=new HashMap<>();
        for(String str : strs){
            String hash = hash(str);
            if(groupedAnagrams.containsKey(hash)){
                groupedAnagrams.get(hash).add(str);
            } else {
                List<String> anagrams=new ArrayList<>();
                anagrams.add(str);
                groupedAnagrams.put(hash,anagrams);
            }
        }
        List<List<String>> groupedList = new ArrayList<>();
        groupedAnagrams.forEach((hash,anagrams)-> groupedList.add(anagrams));
        return groupedList;
    }

    public static String hash(String str){
        int[] charCount=new int[26];
        for(char c:str.toCharArray()) {
            int charIndex=(c-'a');
            charCount[charIndex]=charCount[charIndex]+1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i: charCount) sb.append(i);
        return sb.toString();
    }
}
