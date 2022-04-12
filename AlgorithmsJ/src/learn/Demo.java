package algo;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {1,1,4,2,2,8,10,23,2};
        Map<Integer, Integer> itemAndCount = new HashMap<>();
        //group by frequency
        toStream(arr).get().forEach(i-> itemAndCount.computeIfAbsent(i,key->0));
        toStream(arr).get().forEach(i-> itemAndCount.computeIfPresent(i,(key, oldVal) ->  oldVal+1));
        System.out.println(itemAndCount);
        //distribute into buckets
        Map<Integer, List<Integer>> buckets = new TreeMap<>();
        itemAndCount.forEach((item,count)->{
            buckets.computeIfAbsent(count,key->new ArrayList<>());
            buckets.computeIfPresent(count,(key,oldVal)->{
                oldVal.add(item);
                return oldVal;
            });
        });
        System.out.println(buckets);
    }

    public static Supplier<IntStream> toStream(int[] arr){
        return ()-> Arrays.stream(arr);
    }
}
