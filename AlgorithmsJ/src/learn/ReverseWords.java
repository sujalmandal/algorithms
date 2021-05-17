/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String sentence="Things will look up soon";
		char[] str=sentence.toCharArray();
		reverseWordsInSentence(str);
		for(char ch:str){
		    System.out.print(ch);
		}
	}
	
	public static void reverseWordsInSentence(char[] str){
	    int start=0;
	    int end=0;
	    while(end<str.length){
	        char currChar=str[end];
	        //space encountered. i.e. a word has been found
	        if(currChar==' ' || end+1==str.length){
	            if(str[start]==' '){
	                start++;
	            }
	            print(str,start,end-1);
	            reversePortionOfArray(str,start,end-1);
	            start=end;
	        }
	        end++;
	    }
	}
	public static void print(char[] arr,int start, int end){
	    for(int i=start;i<=end;i++){
	        System.out.print(arr[i]);
	    }
	    System.out.println();
	}
	
	public static void reversePortionOfArray(char[] arr, int start, int end){
	    System.out.println("start: "+start+" end: "+end);
	    while(start<end){
	        char temp=arr[start];
	        arr[start]=arr[end];
	        arr[end]=temp;
	        start++;
	        end--;
	    }
	}
}
