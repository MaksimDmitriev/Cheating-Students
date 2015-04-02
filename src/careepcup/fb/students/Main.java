package careepcup.fb.students;

import java.util.Arrays;

/*
 * A professor wants to see if two students have cheated when writing a paper. 
 * Design a function : hasCheated(String s1,String s2, int N) that evaluates to true if 
 * two strings have a common substring of length N. Additional question after implementation. 
 * Assume you don't have the possibility of using String.contains() and String.substring(). 
 * How would you implement this?
 */
public class Main {

	// http://www.careercup.com/question?id=6196366774632448
	public static void main(String[] args) {
		System.out.println(areCheating("surm", "lorem ipsum", 3));
		System.out.println(areCheatingNoAddMemory("surm", "lorem ipsum", 3));
	}

	private static boolean areCheatingNoAddMemory(String s1, String s2, int num) {
		if (s1.length() < num || s2.length() < num) {
			return false;
		}

		int count = 0;
		char s1AsArray[] = s1.toCharArray();
		char s2AsArray[] = s2.toCharArray();
		for (int istart = 0; istart <= s1AsArray.length - num; istart++) {
			int i = istart;
			int jstart = 0;
			int j = jstart;
			for (; jstart <= s2AsArray.length-num;) {
				if (s1AsArray[i] == s2AsArray[j]) {
					if (++count == num) {
						return true;
					} else {
						if (++i == s1AsArray.length || ++j == s2AsArray.length) {
							return false;
						}
					}
				} else {
					count = 0;
					i = istart;
					j = ++jstart;
				}
			}
		}
		return false;
	}

	private static boolean areCheating(String s1, String s2, int symbols) {
		if (s1.length() < symbols || s2.length() < symbols) {
			return false;
		}
		char[] s1AsArray = s1.toCharArray();
		char[] s2AsArray = s2.toCharArray();
		for (int i = 0; i <= s1AsArray.length - symbols; i++) {
			char[] sub1 = Arrays.copyOfRange(s1AsArray, i, i + symbols);
			for (int j = 0; j <= s2AsArray.length - symbols; j++) {
				char[] sub2 = Arrays.copyOfRange(s2AsArray, j, j + symbols);
				if (Arrays.equals(sub1, sub2)) {
					return true;
				}
			}
		}
		return false;
	}

}
