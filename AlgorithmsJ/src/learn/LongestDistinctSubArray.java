package algo;

import java.util.HashMap;

class LongestDistinctSubArray {
  /*
    input= "abcabcd"
    output= 4 (abcd)
  */
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        //abcfcghe
        char[] arr=s.toCharArray();
        int currLen=0;
        int maxLen=0;
        int start=0;
        int end=0;
        HashMap<Character,Integer> charMap= new HashMap<>();
        while(end<arr.length){
            char curr=arr[end];
            //System.out.println("current: "+curr);
            //current char is unique
            if(!charMap.keySet().contains(curr)){
                //add to known chars & increase count
                charMap.put(curr,end);
                currLen=currLen+1;
                end++;
                //System.out.println("counting, new curr len: "+currLen);
            }
            //current char is not unique
            //shift the window forward
            else{
                //System.out.println("duplicate found");
                int indexOfDuplicate=charMap.get(curr);
                charMap.clear();
                start=indexOfDuplicate+1;
                end=indexOfDuplicate+1;
                maxLen=Math.max(currLen,maxLen);
                currLen=0;
            }
        }
        return Math.max(currLen,maxLen);
    }
}
