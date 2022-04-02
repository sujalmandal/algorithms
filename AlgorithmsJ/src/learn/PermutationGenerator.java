package learn;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PermutationGenerator {
	
	/* an very simple & easy to understand way of finding permutations of a given string 
	 * 
	 * here we take a string & find the permutations of all but the last character 
	 * and we generate permutation for the total string by combining the last character in all
	 * the possible positions in all the permutations of all but the last character.
	 * 
	 * Example : SUN
	 * 
	 * we recurse till we reach "S" & return it as a set of all permutations for the string "S"
	 * then in the previous function we work with "U", we add U before S to make an permutation "US"
	 * and we add U after S to make an permutation "SU", we return these two as a set of all permutations
	 * we could find for "SU", now we work with "N".
	 * Since we already have all permutations of "SU" we now just add "N" in all possible positions of 
	 * each permutations we found for the string "SU".
	 * 
	 * for the permutation "SU" of the string "SU"
	 * we add "N" in all possible places and get {NSU,SNU,SUN}
	 * 
	 * for the permutation "US" of the string "SU"
	 * we again add "N" in all possible positions and get {NUS,UNS,USN}
	 * 
	 * now our set contains {NSU,SNU,SUN,NUS,UNS,USN} which indeed is all the permutations of the string "SUN"
	 * 
	 * */
	public static void main(String[] args) {
		String stringToFindPermutationsFor="sujal";
		Set<String> permutations=permute(stringToFindPermutationsFor);
		System.out.println("total permutations : "+permutations.size());
		permutations.stream().forEach(System.out::println);
	}
	
	//recursive function which returns a permutation of a passed string
	public static Set<String> permute(String str) {
		//base condition, for a string of size 1, it itself is all the permutations you can get out of it
		if(str.length()==1) {
			return Collections.singleton(str);
		}
		else {
			//find all the permutations of all the chars except the last
			Set<String> permutationsOfAllButLastChar=permute(str.substring(0, str.length()-1));
			//Initialise a new set to store the permutations we are going to generate by adding the last char 
			//in all possible places for all the permutations for all but the last string
			Set<String> permutationsAfterAddingLastChar=new HashSet<>();
			//get the last char, e.g. if the string passed to this method is "SUN" then the last char is "N"
			char lastChar = str.charAt(str.length()-1);
			//iterate through all the permutations we found for all but last char
			for(String permutationOfAllButLastChar:permutationsOfAllButLastChar) {
				//generate new permutations by combining the current permutation & the last char in every position possible
				for(int index=0;index<permutationOfAllButLastChar.length()+1;index++) {
					//generate the permutation
					String permutation = permutationOfAllButLastChar
							.substring(0, index)+lastChar+permutationOfAllButLastChar.substring(index,permutationOfAllButLastChar.length());
					//add it to the set
					permutationsAfterAddingLastChar.add(permutation);
				}
			}
			//return our set of permutations
			return permutationsAfterAddingLastChar;
		}
	}
}
