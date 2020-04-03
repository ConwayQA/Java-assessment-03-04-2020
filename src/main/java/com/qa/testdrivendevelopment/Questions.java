package com.qa.testdrivendevelopment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Questions {
	/**
	 * EXAMPLE: THIS ONE HAS BEEN DONE FOR YOU <br>
	 * 
	 * Given a name, return "Hi" plus the name <br>
	 * <br>
	 * For Example:<br>
	 * greetingExample("John") → "Hi John" <br>
	 * greetingExample("Matt") → "Hi Matt" <br>
	 * greetingExample("Angelica") → "Hi Angelica"
	 * 
	 */
	public String greetingExample(String name) {
		return "Hi " + name;
	}


	/**
	 * Given a string and a char, returns the position in the String where the char first appears.
	 * Ensure the positions are numbered correctly, please refer to the examples for guidance. <br>
	 * Do not ignore case <br>
	 * Ignore whitespace <br>
	 * If the char does not occur, return the number -1. <br>
	 * <br>
	 * For Example: <br>
	 * returnPosition("This is a Sentence",'s') → 4 <br>
	 * returnPosition("This is a Sentence",'S') → 8 <br>
	 * returnPosition("Fridge for sale",'z') → -1
	 */
	public int returnPosition(String input, char letter) {
		String temp = "";
		for (int i = 0; i < input.length(); i++) {
			if (!(input.substring(i, i + 1).equals(" "))) {
				temp += input.substring(i, i + 1);
			}
		}
		for (int i = 0; i < temp.length(); i++) {
			if (temp.substring(i, i + 1).equals(Character.toString(letter))) {
				return i + 1;
			}
		}
		return -1;
	}

	/**
	 * Given two Strings of equal length, 'merge' them into one String.
	 * Do this by 'zipping' the Strings together. <br>
	 * Start with the first char of the first String. <br>
	 * Then add the first char from the second String. <br>
	 * Then add the second char from the first String. <br>
	 * And so on. <br>
	 * Maintain case. <br>
	 * You will not encounter whitespace. <br>
	 * <br>
	 * For Example: <br>
	 * zipped("String","Fridge") → "SFtrriidngge" <br>
	 * zipped("Dog","Cat") → "DCoagt"<br>
	 * zipped("True","Tree") → "TTrrueee" <br>
	 * zipped("return","letter") → "rleettutrenr" <br>
	 */
	public String zipped(String input1, String input2) {
		String temp = "";
		for(int i = 0; i < input1.length(); i++) {
			temp+= input1.substring(i, i + 1);
			temp+= input2.substring(i, i + 1);
		}
		return temp;
	}

	
	/**
	 * Given an Array of Strings, remove any duplicate Strings that occur, then return the Array. <br>
	 * Do not ignore case. <br>
	 * <br>
	 * For Example: <br>
	 * removeDuplicates({"Dog"}) → {"Dog"} <br>
	 * removeDuplicates({"Dog","Cat"}) → {"Dog","Cat"} <br>
	 * removeDuplicates({"Dog","Dog","Cat"}) → {"Dog","Cat"} <br>
	 * removeDuplicates({"Dog","DoG","Cat"}) → {"Dog","DoG","Cat"} 
	 */
	public String[] removeDuplicates(String[] stringArray) {
		List<String> tempList = new ArrayList<String>();
		boolean check = false;
		for (String s : stringArray) {
			for (String x : tempList) {
				if (s.contentEquals(x)) {
					check = true;
				}
			}
			if (!check) {
				tempList.add(s);
			}
			check = false;
		}
		String[] tempArray = new String[tempList.size()];
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = tempList.get(i);
		}
		return tempArray;
	}

	/**
	 * Given a large string that represents a csv (comma separated values), the structure of each record will be as follows:
	 * owner,nameOfFile,encrypted?,fileSize <br>
	 * <br>
	 * Example:
	 * "Bert,private.key,True,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445" <br>
	 * <br>
	 * Where a comma separates out the fields, and the \n represents a new line. <br>
	 * For each record, if it is not encrypted, return the names of the owners of the files in a String Array. <br>
	 * Do not include duplicate names. <br>
	 * <br>
	 * For Example: <br>
	 * csvScan("Jeff,private.key,False,1445") → {"Jeff"} <br>
	 * csvScan("Bert,private.key,True,1447\nBert,public.key,True,1318\nJeff,private.key,False,1445") → {"Jeff"} <br>
	 * csvScan("Bert,private.key,False,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445") → {"Bert","Jeff"} <br>
	 * csvScan("Bert,private.key,True,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445") → {"Bert","Jeff"}
	 */
	public String[] csvScan(String csvInput) {
		String[] convert = csvInput.split("\n");
		String recombine = "";
		for (String s: convert) {
			recombine += s + ",";
		}
		String[] convert2 = recombine.split(",");
		List<String> temp = new ArrayList<String>();
		for (int i = 0; i < convert2.length; i+=4) {
				if (convert2[i + 2].contentEquals("False")) {
					if (!(temp.contains(convert2[i]))) {
						temp.add(convert2[i]);
					}
				}
		}
		String[] tempArray = new String[temp.size()];
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = temp.get(i);
		}
		return tempArray;
	}

	
	/**
	 * Write a function to randomly generate a list with 5 even numbers between 100 and 200 inclusive. <br>
	 *  <br>
	 * For Example:     <br>
	 * listGen() → {100,102,122,198,200}  <br>
	 * listGen() → {108,104,106,188,200}  <br>
	 * listGen() → {154,102,132,178,164}
	 */
	public int[] listGen() {
		int[] randoms = new int[5];
		for (int i = 0; i < 5; i++) {
			randoms[i] = 100 + (int)(Math.random() * 101);
			if (randoms[i] % 2 == 1) {
				randoms[i] --;
			}
		}
		return randoms;
	}


	/**
	 * A prime number is one which is only divisible by one and itself.  <br>
	 * Write a function which returns the boolean True if a number is prime, and the boolean False if not. <br>
	 *  <br>
	 * For Example: <br>
	 * isPrime(3) → True <br>
	 * isPrime(8) → False
	 */
	public boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Wrtie a function which returns the number of vowels in a given string.  <br>
	 * You should ignore case. <br>
	 *  <br>
	 * For Example: <br>
	 * getVowel("Hello") → 2  <br>
	 * getVowel("hEelLoooO") → 6
	 */
	public int getVowel(String input) {
		input = input.toLowerCase();
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			String a = input.substring(i, i + 1);
			if (a.contentEquals("a") || a.contentEquals("e") || a.contentEquals("i") || a.contentEquals("o") || a.contentEquals("u")) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Given two string inputs, if one can be made from the other return the boolean True, if not return the boolean False.  <br>
	 *  <br>
	 * For Example:  <br>
	 * wordFinder("dog", "god") → True  <br>
	 * wordFinder("tiredest", "tree") → True  <br>
	 * wordFinder("dog", "cat") → False  <br>
	 * wordFinder("tripping", "gin") → True
	 */
	public boolean wordFinder(String initialWord, String madeString) {
		for (int i = 0; i < madeString.length(); i++) {
			if (!(initialWord.contains(madeString.substring(i, i + 1)))) {
				return false;
			}
		}
		return true;
	}
	

	/**
	 * There is a well known mnemonic which goes "I before E, except after C", which is used to determine which order "ei" or "ie" should be in a word.  <br>
	 *  <br>
	 * Write a function which returns the boolean True if a string follows the mnemonic, and returns the boolean False if not.  <br>
	 *  <br>
	 * For Example:  <br>
	 * iBeforeE("ceiling") → True  <br>
	 * iBeforeE("believe") → True  <br>
	 * iBeforeE("glacier") → False  <br>
	 * iBeforeE("height") → False
	 */
	public boolean iBeforeE(String input) {
		input = input.toLowerCase();
		String a = "";
		for (int i = 0; i < input.length(); i++) {
			a = input.substring(i, i + 1);
			if (a.contentEquals("e")) {
				if(input.substring(i - 1, i).contentEquals("c")) {
					if(input.substring(i + 1, i + 2).contentEquals("i")) {
						return true;
					}
				}
			} else if (a.contentEquals("i")) {
				if(!(input.substring(i - 1, i).contentEquals("c"))) {
					if(input.substring(i + 1, i + 2).contentEquals("e")) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 	A factorial is the product of itself and all previous numbers  <br>
	 * eg 3 factorial is 1 x 2 x 3 = 6  <br>
	 *  <br>
	 * Write a function which can compute the factorial of a given number between 1 and 10 inclusive.   <br>
	 *   <br>
	 * For Example:  <br>
	 * factorial(1) → 1  <br>
	 * factorial(4) → 24  <br>
	 * factorial(8) → 40320
	 */
	public int factorial(int number) {
		int total = 1;
		for (int i = 1; i <= number; i++) {
			total *= i;
		}
		return total;
	}

}
