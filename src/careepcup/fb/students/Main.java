package careepcup.fb.students;


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
		System.out.println(areCheatingNoAddMemory("lor", "lor", 3));

		System.out.println(areCheatingNoAddMemory("lorsdfgsdv", "lorem ipsum", 3));
		System.out.println(areCheatingNoAddMemory("scsaaslorsdfgsdv", "lorem ipsum", 3));
		
		System.out.println(areCheatingNoAddMemory("scsaaslofbdrsdfgsdvlor", "lorem ipsum", 3));
		System.out.println(areCheatingNoAddMemory("lorem ipsum", "scsaaslofbdrsdfgsdvlor", 3));

		System.out.println(areCheatingNoAddMemory("lolorewevjj", "lorem ipsum", 3));
		System.out.println(areCheatingNoAddMemory("lorem ipsum", "loloresdvsdhg", 3));
		
		// False
		System.out.println(areCheatingNoAddMemory("trhtjtjyjyjy", "lorem ipsum", 3));
		System.out.println(areCheatingNoAddMemory("gukgjkykjlohfghfjgfgj", "lorem ipsum", 3));
		
		System.out.println("-----------------------------------------------------");
		
		System.out.println(areCheatingRegex("tlory", "hlorf", 3));
		System.out.println(areCheatingRegex("lorsdfgsdv", "lorem ipsum", 3));
		System.out.println(areCheatingRegex("scsaaslorsdfgsdv", "lorem ipsum", 3));
		
		System.out.println(areCheatingRegex("scsaaslofbdrsdfgsdvlor", "lorem ipsum", 3));
		System.out.println(areCheatingRegex("lorem ipsum", "scsaaslofbdrsdfgsdvlor", 3));

		System.out.println(areCheatingRegex("lolorewevjj", "lorem ipsum", 3));
		System.out.println(areCheatingRegex("lorem ipsum", "loloresdvsdhg", 3));
		
		// False
		System.out.println(areCheatingRegex("trhtjtjyjyjy", "lorem ipsum", 3));
		System.out.println(areCheatingRegex("gukgjkykjlohfghfjgfgj", "lorem ipsum", 3));
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
			for (; jstart <= s2AsArray.length - num;) {
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

	private static boolean areCheatingRegex(String s1, String s2, int symbols) {
		if (s1.length() < symbols || s2.length() < symbols) {
			return false;
		}
		String concat = s1 + "\u0001" + s2;
		String regex= "^[^\u0001]*([^\u0001]{" + symbols + "})[^\u0001]*\u0001[^\u0001]*\\1[^\u0001]*$";
		return concat.matches(regex);
	}

}
