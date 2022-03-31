package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringSubSequenceGenerator {
    public static void main(String[] args) {
        subSequence("abc").forEach(System.out::println);
    }

    public static List<String> subSequence(String str){
        List<String> subSequences = new ArrayList<>();
        _subSequence(subSequences,str,"",0);
        Collections.sort(subSequences, Comparator.comparingInt(String::length));
        return subSequences;
    }

    public static void _subSequence(List<String> subSequences, String originalStr, String subSequence, int currentIndex){
        if(currentIndex==originalStr.length()){
            subSequences.add(subSequence);
        }
        else {
            /* either choose an item at a particular index, or not choose it */
            String withCharAtIndex = subSequence+originalStr.charAt(currentIndex);
            String withoutCharAtIndex = subSequence;
            /* however, increment the index we are looking at */
            _subSequence(subSequences,originalStr,withCharAtIndex,currentIndex+1);
            _subSequence(subSequences,originalStr,withoutCharAtIndex,currentIndex+1);
        }
    }
}
