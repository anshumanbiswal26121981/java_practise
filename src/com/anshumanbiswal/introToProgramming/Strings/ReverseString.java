package com.anshumanbiswal.introToProgramming.Strings;

/**
 *  Simple Reverse
 * Solved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Given a string A, you are asked to reverse the string and return the reversed string.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 105
 *
 * String A consist only of lowercase characters.
 *
 *
 *
 * Input Format
 *
 * First and only argument is a string A.
 *
 *
 *
 * Output Format
 *
 * Return a string denoting the reversed string.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = "scaler"
 * Input 2:
 *
 *  A = "academy"
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  "relacs"
 * Output 2:
 *
 *  "ymedaca"
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Reverse the given string.
 */
public class ReverseString {

    public static String solve(String A) {
        char[] ch = A.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = ch.length -1 ; i >=0; --i) {
            sb.append(ch[i]);
        }

        return sb.toString();
    }

    static void main() {
        System.out.println(solve("scaler"));
    }
}
