package algo;

import java.util.*;

public class TopKElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topK(new int[]{1,1,19,2,2,3,13,12,13,12,19,19,19},3)));
    }

    public static Integer[] topK(int[] nums, int k){
        final Map<Integer,Integer> freqMap = new HashMap<>();
        /**
         * count the number of times the elements appear in the input
         */
        for(int num: nums){
            freqMap.computeIfPresent(num,(key,freq)-> freq+1);
            freqMap.putIfAbsent(num, 1);
        }

        List<Integer>[] listOfElemsWithFreq = new List[nums.length];
        /**
         * scan the frequency map and compile a structure where the key is the count and the value is the list of
         * elements that appeared that many times (count)
         *
         * use the count as an index in the structure to that the resulting structure is count sorted
         * i.e. if we encounter the count 10 then the count 2
         * we will use 10 as the index, so that we end up adding the numbers that appeared 10 times in the value
         * similary, for the count 2, we will use 2 as index and add the elements appeared two times
         *
         * once this is done, we can simply scan through the array in a reverse order and find the elements that appeared
         * the most number of times
         *
         */
        freqMap.forEach((num,freq)->{
            if(listOfElemsWithFreq[freq]==null) listOfElemsWithFreq[freq]=new ArrayList<>();
            listOfElemsWithFreq[freq].add(num);
        });
        List<Integer> topK=new ArrayList<>(k);
        int counter=0;
        for (int i = listOfElemsWithFreq.length-1; i > 0 ; i--) {
            /** no elements of this count was found */
            if(listOfElemsWithFreq[i]==null) continue;
            /** element(s) of this count was found */
            if(listOfElemsWithFreq[i]!=null){
                boolean topKDone=false;
                /** look at the elements with i as the count value and add them one by one while incrementing the counter */
                for(int element : listOfElemsWithFreq[i]){
                    /** we already counted k elements, time to quit the loop */
                    if(counter==k) { topKDone=true; break; }
                    counter++;
                    topK.add(element);
                }
                /** no point in looking for other counts, we already have k top elements, quit */
                if(topKDone) break;
            }
        }
        return topK.toArray(new Integer[0]);
    }
}
