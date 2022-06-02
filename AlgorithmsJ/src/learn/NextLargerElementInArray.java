package algo;

import java.util.Arrays;
import java.util.Stack;

public class NextLargerElementInArray {
    public static void main(String[] args) {
        int[] dailyTemperatures = new int[]{73,74,75,71,69,72,76,73};

        int[] nextWarmerTemp = new int[dailyTemperatures.length];

        final Stack<TempDayPair> monoDecreasingStack = new Stack<>();
        monoDecreasingStack.push(TempDayPair.of(dailyTemperatures[0],0));
        for (int currentDay = 1; currentDay < dailyTemperatures.length; currentDay++) {
            int currTemperature = dailyTemperatures[currentDay];
            while(!monoDecreasingStack.isEmpty() && monoDecreasingStack.peek().temp < currTemperature){
                TempDayPair previousRecord = monoDecreasingStack.pop();
                nextWarmerTemp[previousRecord.day] = currTemperature;
            }
            monoDecreasingStack.push(TempDayPair.of(currTemperature,currentDay));
        }
        while(!monoDecreasingStack.isEmpty()){
            int day = monoDecreasingStack.pop().day;
            nextWarmerTemp[day]=0;
        }

        System.out.println(Arrays.toString(dailyTemperatures));
        System.out.println(Arrays.toString(nextWarmerTemp));
    }

    static class TempDayPair{
        int temp;
        int day;
        public static TempDayPair of(int t, int d){
            TempDayPair tempDayPair = new TempDayPair();
            tempDayPair.temp=t;
            tempDayPair.day=d;
            return tempDayPair;
        }
    }
}
