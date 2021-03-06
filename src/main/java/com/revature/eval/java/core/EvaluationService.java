package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
// need to use what sort of methods the temporal import has 
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) // phrase
	{
		// TODO Write an implementation for this method declaration
		/*
		 * Goal Output: TLC
		 */
		/*
		 * turn string into a char array char array to as long as you need it ... 3
		 */
		String acro = phrase.substring(0, 1);

		// create a for loop to scan a string

		char a;
		// let's create a for loop to scan the acronym array
		for (int i = 0; i < phrase.length(); i++) {
			a = phrase.charAt(i);
			// let's find space and dashing without the array
			if (a == ' ' || a == '-') {
				acro = acro + Character.toString(phrase.charAt(i + 1));
			}
		}
		return acro;

	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			boolean c = false;
			/*
			 * nested ifs should work property of equilaterals: all sides are equal
			 */

			if (sideOne == sideTwo & sideOne == sideThree) {

				c = true;
			}
			return c;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			/*
			 * property of an isosceles triangle: two sides MUST be equal
			 */
			if (sideOne == sideTwo) {
				return true;
			} else if (sideOne == sideThree) {
				return true;
			} else
				return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			/*
			 * property of scalene: ALL sides are different
			 */
			// test for sideOne != sideTwo AND != sideThree
			if (sideOne != sideTwo && sideOne != sideThree) {
				return true;
			}

			else
				return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		/*
		 * Goal: Compute scrabble score. Convert a letter to its associating integer
		 * value (string to char to int) Adding calculator Strategy: Map and hashMap
		 * Map: to have a key associated with an integer value (NULL KEYS & VALUES are
		 * NOT ok) Duplicate values are ALLOWED Duplicate keys are NOT ALLOWED hashMap
		 * because order DOESN'T matter on how we need to store keys and values HASHING
		 * is transforming an object to some number
		 *
		 * Upper and lower case letters are different. This way we can have one letter a
		 * piece since we are not returning the string, so what we do with it DOESN'T
		 * matter to the user
		 */
		string = string.toUpperCase();
		/*
		 * We need something to keep score
		 */
		int score = 0;
		// constructing the keys with their values
		Map<Character, Integer> ls = new HashMap<>(); // ls = letter score
		// 'put' keyword to make key/value pairs
		// A, E, I, O, U, L, N, R, S, T = 1
		ls.put('A', 1);
		ls.put('E', 1);
		ls.put('I', 1);
		ls.put('O', 1);
		ls.put('U', 1);
		ls.put('L', 1);
		ls.put('N', 1);
		ls.put('R', 1);
		ls.put('S', 1);
		ls.put('T', 1);
		// D, G = 2
		ls.put('D', 2);
		ls.put('G', 2);
		// B, C, M, P = 3;
		ls.put('B', 3);
		ls.put('C', 3);
		ls.put('M', 3);
		ls.put('P', 3);
		// F, H, V, W, Y = 4
		ls.put('F', 4);
		ls.put('H', 4);
		ls.put('V', 4);
		ls.put('W', 4);
		ls.put('Y', 4);
		// K = 5;
		ls.put('K', 5);
		// J, X = 8
		ls.put('J', 8);
		ls.put('X', 8);
		// Q, Z = 10;
		ls.put('Q', 10);
		ls.put('Z', 10);
		/*
		 * creating the sum calculator use a for loop and a hashmap i = 0 starting point
		 * condition: we need to go through each character in the string individually
		 * post increment
		 */
		for (int i = 0; i < string.length(); i++) {
			/*
			 * referencing the hashmap to add values to the score i is the location in the
			 * string we are checking index wise to add to score call the hashmap
			 * string.charAt() method gets the character based on the index
			 */
			score = score + ls.get(string.charAt(i));

		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		/*
		 * I want to scan for +1 () - . OUT: 1234567890 straight up just numbers the
		 * output is as a string
		 */
		// create a placeholder
		char n;
		// String num is to accept any phone numbers coming
		String num = "";
		/*
		 * Create a for loop to scan the string starting at the first index [0] the
		 * condition: as long as [0] is less than the original phone number the char
		 * being scanned will increment by one
		 */
		for (int i = 0; i < string.length(); i++) {
			/*
			 * string.charAt to check the location of the char in the string starting at i=0
			 * Hence, we need our placeholder char n
			 */
			n = string.charAt(i);

			/*
			 * control flow statement 'if' to see if the character it is scanning is a
			 * integer Thus, use the function Character.isDigit() . + - ' '
			 */
			if (Character.isDigit(n)) {
				/*
				 * condition met: add to the string use the function Character.toString()
				 */
				num = num + Character.toString(n);
			}
		}
		/*
		 * control flow 'if' checks to see that the first integer in the original phone
		 * number ISN'T a 1 use the == '1' our goal is to get rid of it within our 'if'
		 * statement by dropping 1 off to give us a 10 digit string
		 * 
		 * use a short circuit AND && to check if the string greater than 10 indices use
		 * the method .length()
		 */
		if (num.charAt(0) == '1' && num.length() > 10) {
			/*
			 * substring the new I have created to drop of the 1 at index [0] when you
			 * substring, parse, trim cuts to the LEFT of the index you specify
			 */
			num = num.substring(1);
			return num;
		}
		/*
		 * to check that the phone number given meets all requirements and DOESN'T
		 * exceed pass 10 integers
		 */
		if (num.length() != 10) {
			return null;
		}
		return num;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		/*
		 * I used this site as a guided reference for this problem
		 * https://codingbat.com/doc/java-map-wordcount.html
		 */
		// by using a key the compiler will examine a string for each word at least ONCE
		// before reexamining the frequency of the word in the string
		Map<String, Integer> count = new HashMap<String, Integer>();
		/*
		 * An enhanced for loop can serve as effective word counter. Let's focus on a
		 * specifically on the conditional part of the for loop. When a string is
		 * analyzed the first, the compiler will store each word as a key to the map. If
		 * repetition is seen, then the for loop will increment by 1.
		 */
		String[] phrases = string.split(" "); // regex = patterns
		for (String p : phrases) {
			// I don't know what purpose this conditional statement does?
			if (!count.containsKey(p)) {
				count.put(p, 1); // store each word as a key with value 1
			}
			// this part of the code is where the increment and word count
			else {
				int words = count.get(p);
				count.put(p, words + 1);
			}
		}

		return count;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			/*
			 * make a int that starts at the last index of the sortedList
			 */
			int l = (sortedList.size() - 1); // -1 to prevent OutOfBounds errors
			/*
			 * make another int that starts at zero as a placeholder
			 */
			int i = 0;
			/*
			 * make another into to call the input t to make it into a string to parse it to
			 * an int
			 */
			int result = Integer.parseInt(t.toString()); // saving whatever integer is the list
			/*
			 * make a while to check to see if the int i < int l
			 */
			while (i <= l) {
				/*
				 * make another int to be in the middle of i and l
				 */
				int m = (i + l) / 2; // start to evaluate which side to parse
				/*
				 * make another in to store the value of m. What is happening to m is it is
				 * being evaluate against 'result'.
				 */
				int x = Integer.parseInt(sortedList.get(m).toString());
				if (x > result) {
					/*
					 * we are taking l and making it equal to m - 1
					 */
					l = m - 1;
				}
				/*
				 * add an 'else if' to do the opposite of the 'if' statement
				 */
				else if (x < result) {
					/*
					 * go the right side of the whatever the index of 'm' is
					 */
					i = m + 1;
				} else {
					return m;
				}
			}
			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		/*
		 * Reference guide on this site
		 * https://www.geeksforgeeks.org/encoding-word-pig-latin
		 */

		/*
		 * Rule 1: Finding the vowel and adding "ay" at the end First, we must make a
		 * method to examine the string for the first vowel in index [0] let's examine
		 * the string for a vowel
		 */
		string = "quick fast run";
		StringBuilder con = new StringBuilder(); // words with the first index = consonant
		StringBuilder str2 = new StringBuilder();
		StringBuilder str3 = new StringBuilder();
		for (int j = 0; j < string.length(); j++) {
			if (string.contains(" "))
				;
			{
				for (int i = 0; i < string.length(); i++) {
					switch (string.charAt(i)) {
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						str2 = new StringBuilder(string.substring(i) + con.toString() + "ay");
						i = string.length();
						break;
					// return str2.toString();
					default:
						// Rule 2: consonants shifting to the end and adding "ay"
						/*
						 * shift the first two indices at the end for loop to scan the string array
						 */
						con.append(string.charAt(i));
						break;
					}
				}
				str3 = new StringBuilder(string.substring(j) + con.toString() + "ay");
				str3.append(j);
			}
		}
		System.out.println("Str2: " + str2.toString());
		System.out.println("Str3: " + str3.toString());
		System.out.println("");

		return string;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		/*
		 * Here are the sites that gave me some guidance/direction
		 * https://www.geeksforgeeks.org/java-program-to-check-armstrong-number/
		 * https://www.programmingsimplified.com/java/source-code/java-program-armstrong
		 * -number
		 */
		// we will convert the int input into a string by toString(); method
		String num = Integer.toString(input);
		int check = input; // hold input steady at the end for the next
		// now I want to find the length of the string so I can store it as a number of
		// digits
		int ndigits = num.length();
		// create an Int array to store the number, but right now is currently empty
		int[] ia = new int[ndigits];
		/*
		 * for loop to iterate to get the values of the input into the array i = 0;
		 * starting index i < ia.length; Condition to store every digit i++
		 */
		for (int i = 0; i < ia.length; i++) {
			/*
			 * [] to assign a value to a given index perform % on 'input'to get the last
			 * digit of the given number
			 */
			ia[i] = input % 10;
			input /= 10; // division assignment
		}
		/*
		 * create a another for loop to create a calculator to the sum of the digits
		 * rised to the power
		 */
		int sum = 0; // summation variable
		for (int j = 0; j < ia.length; j++) {
			// NOT using the whole array and I am raising it to the number of digits -->
			// ndigits
			sum += Math.pow(ia[j], ndigits);
		}
		// create a checking method for the return type of boolean
		if (sum == check) {
			return true;
		} else
			return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// Let's convert the string into a char array. use '.toCharArray()' method
			char[] stringConverter = string.toCharArray();
			/*
			 * ammend the given string by using the class StringBuilder to store the final
			 * result.
			 */
			StringBuilder result = new StringBuilder();
			// Create two string arrays containing the letters of the alphabet
			String a = "abcdefghijklmnopqrstuvwxyz";
			String A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			// Use an enhanced for loop to start scanning the array
			for (char parser : stringConverter) {

				/*
				 * 'Character.isLetter' will check the array for a non-letters. returns true is
				 * the index contains a letter
				 */
				if (Character.isLetter(parser)) {
					if (Character.isUpperCase(parser)) {

						/*
						 * now starts the shifting process. We need a counter based on the char index.
						 * Hence, use the method '.indexOf'. We will use that method in unison of the
						 * method 'Character.toString()' and the given key
						 */
						int shifted = A.indexOf(Character.toString(parser)) + key;
						while (shifted > 25) // transposing process
						{
							shifted -= 26;
						}
						result.append(A.charAt(shifted));
					} else {
						int shifted = a.indexOf(Character.toString(parser)) + key;
						while (shifted > 25) {
							shifted -= 26;
						}
						result.append(a.charAt(shifted));
					}
				} else {
					result.append(parser);
				}
			}
			return result.toString();
		}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// start with prime integer
		// Thanks wiki for helping with the starting place
		// https://en.wikipedia.org/wiki/Primality_test
		int prime = 5;
		/*
		 * we need a way to check if the given integer i is NOT equal to zero REASON: 0
		 * is NOT prime
		 */
		if (i == 0) {
			throw new IllegalArgumentException("0th Prime does not exist.");
		} else if (i == 1) {
			return 2;
		} else if (i == 2) {
			return 3;
		}
		// while loop go past the prime digit 3.
		while (i >= 3) {
			while (!isPrime(prime)) {
				// not a
				prime++; // continue scanning
			}
			prime++; // post increment (we find a prime)
			i--;
			/*
			 * counting backwards to check if the located prime is the index we are looking
			 * for 'nth prime'
			 */
		}
		return prime - 1; // does NOT exist in the array
	}

	public boolean isPrime(int n) {
		if (n <= 3 && n > 1) {
			return true;
		} else if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		int i = 5;
		while (i * i <= n) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
			i += 6;
		}
		return true;

	}


/**
 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
 * system created in the Middle East.
 *
 * The Atbash cipher is a simple substitution cipher that relies on transposing
 * all the letters in the alphabet such that the resulting alphabet is
 * backwards. The first letter is replaced with the last letter, the second with
 * the second-last, and so on.
 *
 * An Atbash cipher for the Latin alphabet would be as follows:
 *
 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
 * very weak cipher because it only has one possible key, and it is a simple
 * monoalphabetic substitution cipher. However, this may not have been an issue
 * in the cipher's time.
 *
 * Ciphertext is written out in groups of fixed length, the traditional group
 * size being 5 letters, and punctuation is excluded. This is to make it harder
 * to guess things based on word boundaries.
 *
 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
 *
 */
static class AtbashCipher {

	/**
	 * Question 13
	 *
	 * @param string
	 * @return
	 */
	public static String encode(String string) {
		/*
		 * make a char array which lower cases all the letters. Use a StringBuilder to
		 * ammend the given string to by encrypted
		 */
		char[] p = string.toLowerCase().toCharArray();
		StringBuilder result = new StringBuilder();

		String a = "abcdefghijklmnopqrstuvwxyz"; // going forward
		String z = "zyxwvutsrqponmlkjihgfedcba"; // going backward

		for (char c : p) { // scans the char array
			if (Character.isLetter(c)) {
				int index = a.indexOf(Character.toString(c));
				result.append(z.charAt(index));
			} else if (Character.isDigit(c)) {
				result.append(c);
			}
		}

		for (int i = 5; i < string.length(); i += 6) {
			result.insert(i, " ");
		}
		// remember that you always start at 0
		// so I an inserting after every 6
		// 0-5 = 6
		// so the first inserting " " is at the 5th index aka 6th element
		// so for your modulus, you have to make sure ur indexing is in the order u want

		int lastIndex = result.length() - 1;

		if (result.charAt(lastIndex) == ' ') {
			result.deleteCharAt(lastIndex);
			/*
			 * safety precaution for a string that has space at the end basically an odd
			 * number indices. The StringBuilder will add an extra space at the 5th element
			 */
		}
		return result.toString();
	}

	/**
	 * Question 14
	 *
	 * @param string
	 * @return
	 */
	public static String decode(String string) {
		// TODO Write an implementation for this method declaration
		char[] parse = string.toLowerCase().toCharArray();
		StringBuilder real = new StringBuilder();
		// Holds decrypt message

		String a = "abcdefghijklmnopqrstuvwxyz"; // REAL alphabet
		String z = "zyxwvutsrqponmlkjihgfedcba"; // the substitution

		for (char c : parse) {
			if (Character.isLetter(c)) { // the start of the decryption
				int index = z.indexOf(Character.toString(c));
				real.append(a.charAt(index));
			} else if (Character.isDigit(c)) {
				real.append(c);
			}
		}
		return real.toString();
	}

	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 *
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 *
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 *
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 *
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 *
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// First convert the string into a char array
		char[] parser = string.toCharArray();
		// store the possible values into an ArrayList
		List<Integer> n = new ArrayList<>();

		for (char c : parser) // scans the char array
		{
			if (Character.isDigit(c)) {
				n.add(Integer.parseInt(Character.toString(c)));
			} else if (c == 'X') {
				n.add(10);
			} else if (c != '-') {
				return false;
			}
		}
		int multiplier = 10; // X*10
		for (int i = 0; i < 10; i++) {

			n.set(i, n.get(i) * multiplier--);

		}
		int sum = 0; // the starter for adding the overrall sum
		Iterator<Integer> repeat = n.iterator();
		// it keeps adding with each increment
		while (repeat.hasNext()) {
			int i = (int) repeat.next(); // performing a casting
			sum += i; // add and replace operation
		}
		if (sum % 11 == 0) // to check for no remainders
		{
			return true;
		}

		return false; // there is a remainder
	}

	/**
	 *
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 *
	 * The quick brown fox jumps over the lazy dog.
	 *
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 *
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// convert string into a char array
		char[] c = string.toCharArray();
		// StringBuilder will enable us to manipulate a string to our will
		StringBuilder sb = new StringBuilder("abcdefghijklmnopqrstuvwxyz");

		for (char cr : c) {// scans char array
			if (Character.isLetter(cr)) {
				int index = sb.indexOf(Character.toString(cr));
				if (index == -1) {
					// starts back at the top
					continue;
				}

				sb.deleteCharAt(index);
			}
		}

		if ("".equals(sb.toString())) {
			return true;
		}

		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 *
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 *
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// ACTUALLY EXPLICTLY CAST THE DOUBLE INTO AN INT
		int gigasecond = (int) Math.pow(10, 9);
		if (given instanceof LocalDate) {
			return ((LocalDate) given).atTime(0, 0, 0).plus(gigasecond, ChronoUnit.SECONDS);
		} else if (given instanceof LocalDateTime) {
			return given.plus(gigasecond, ChronoUnit.SECONDS);
		}

		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 *
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 *
	 * The sum of these multiples is 78.
	 *
	 * @param i
	 * @param set
	 * @return
	 */

// 15 {4, 6}
// 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0 | n -> 0
// 0 4 8 12 | multiples of 4
// 0 6 12 | multiples of 6
// 4 6 8 12 | unique
// 30 | sum of uniques

	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration

		HashSet<Integer> hs = new HashSet<>();
		// adding values into the HashSet
		for (int n = 1; n < i; n++) {
			for (int j = 0; j < set.length; j++) {
				if (n % set[j] == 0) {
					hs.add(n);
				}
			}
		}

		Iterator<Integer> iter = hs.iterator(); // iterates the hashset

		int answer = 0;

		while (iter.hasNext()) {
			answer += (int) iter.next(); // downcasting
		}

		return answer;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 *
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 *
	 * The task is to check if a given string is valid.
	 *
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 *
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 *
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 *
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 *
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 *
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 *
	 * 7253 2262 5312 0539 Sum the digits
	 *
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 *
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		//
		if (string.length() < 1) {
			return false;
		}

		char[] parseString = string.toCharArray();
		List<Integer> num = new ArrayList<>();

		for (char c : parseString) {
			if (Character.isDigit(c)) {
				num.add(Integer.parseInt((Character.toString(c))));
			} else if (c == ' ') {
				continue;
			} else {
				return false;
			}
		}

		for (int i = 0; i < num.size(); i++) {
			if (isOdd(i)) {
				int newNum = num.get(i) * 2;
				while (newNum > 9) {
					newNum -= 9;
				}
				num.set(i, newNum);
			}
		}

		int sum = 0;
		Iterator<Integer> iter = num.iterator();
		while (iter.hasNext()) {
			sum += (int) iter.next();
		}

		if (sum % 10 == 0) {
			return true;
		}

		return false;

	}

	public boolean isOdd(int n) {
		if (!(n % 2 == 0)) {
			return true;
		}
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 *
	 * Add two numbers together.
	 *
	 * What is 5 plus 13?
	 *
	 * 18
	 *
	 * Now, perform the other three operations.
	 *
	 * What is 7 minus 5?
	 *
	 * 2
	 *
	 * What is 6 multiplied by 4?
	 *
	 * 24
	 *
	 * What is 25 divided by 5?
	 *
	 * 5
	 *
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		String[] spit = string.split("[ ?]");
		int amRight = 0;
		for (int i = 0; i < spit.length; i++) {
			if (spit[i].equals("plus")) {
				String leftInteger = spit[i - 1];
				String rightInteger = spit[i + 1];
				amRight = Integer.parseInt(leftInteger) + Integer.parseInt(rightInteger);
			} else if (spit[i].equals("minus")) {
				String leftInteger = spit[i - 1];
				String rightInteger = spit[i + 1];
				amRight = Integer.parseInt(leftInteger) - Integer.parseInt(rightInteger);
			} else if (spit[i].equals("multiplied")) {
				String leftInteger = spit[i - 1];
				String rightInteger = spit[i + 2];
				amRight = Integer.parseInt(leftInteger) * Integer.parseInt(rightInteger);
			} else if (spit[i].equals("divided")) {
				String leftInteger = spit[i - 1];
				String rightInteger = spit[i + 2];
				amRight = Integer.parseInt(leftInteger) / Integer.parseInt(rightInteger);
			}
		}
		return amRight;
	}

}
