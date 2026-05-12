package com.anshumanbiswal.internmediate.normal.Strings;

/**
 * Amazing Subarrays
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * You are given a string S, and you have to find all the amazing substrings of S.
 *
 * An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 *
 * Input
 *
 * Only argument given is string S.
 * Output
 *
 * Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
 * Constraints
 *
 * 1 <= length(S) <= 1e6
 * S can have special characters
 * Example
 *
 * Input
 *     ABEC
 *
 * Output
 *     6
 *
 * Explanation
 *     Amazing substrings of given string are :
 *     1. A
 *     2. AB
 *     3. ABE
 *     4. ABEC
 *     5. E
 *     6. EC
 *     here number of substrings are 6 and 6 % 10003 = 6.
 * Expected Output
 * Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
 */
public class CountAmazingSubArrays {

    public static int solve(String A) {
        char[] a = A.toLowerCase().toCharArray();
        int sum = 0;
        for (int i = 0; i < a.length; ++i) {
            char character = a[i];
            if (character == 'a' || character == 'e' || character == 'o' || character == 'u' || character == 'i') {
                int startIndex = i;
                int endIndex = a.length - 1;
                sum += (endIndex-startIndex + 1); // number of subarrays from l:r is r-l+1
                sum %= 10003;
            }
        }
        return sum;
    }

    static void main() {
        System.out.println(solve("ABEC"));
    }
}
