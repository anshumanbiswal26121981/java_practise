package com.anshumanbiswal.internmediate.normal.Strings;

/**
 * Toggle Case
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.
 *
 * You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * A[i] ∈ ['a'-'z', 'A'-'Z']
 *
 *
 *
 * Input Format
 *
 * First and only argument is a character string A.
 *
 *
 *
 * Output Format
 *
 * Return a character string.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = "Hello"
 * Input 2:
 *
 *  A = "tHiSiSaStRiNg"
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  hELLO
 * Output 2:
 *
 *  ThIsIsAsTrInG
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  'H' changes to 'h'
 *  'e' changes to 'E'
 *  'l' changes to 'L'
 *  'l' changes to 'L'
 *  'o' changes to 'O'
 * Explanation 2:
 *
 *  "tHiSiSaStRiNg" changes to "ThIsIsAsTrInG".
 */
public class ToggleCase {
    /**
     * Approach: iterate onm every cvharacter of input string
     * @param A
     * @return
     */
    public static String solve(String A) {
        int N = A.length();
        char[] characters = A.toCharArray();
        for (int i = 0; i < N; ++i) {
            Character ch = characters[i];
            if(ch >= 65 && ch <= 90) { //upper case
                characters[i] = (char)(ch + 32);

            } else {//lowercase
                characters[i] = (char)(ch - 32);
            }
        }
        return String.copyValueOf(characters);
    }

    static void main() {
        System.out.println(solve("Hello"));
        System.out.println(solve("tHiSiSaStRiNg"));
    }
}
