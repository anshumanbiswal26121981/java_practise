package com.anshumanbiswal.internmediate.optimized.Strings;

/**
 *  Longest Palindromic Substring
 * Solved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Given a string A of size N, find and return the longest palindromic substring in A.
 *
 * Substring of string A is A[i...j] where 0 <= i <= j < len(A)
 *
 * Palindrome string:
 * A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
 *
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 6000
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
 * Return a string denoting the longest palindromic substring of string A.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 * A = "aaaabaaa"
 * Input 2:
 * A = "abba
 *
 *
 * Example Output
 *
 * Output 1:
 * "aaabaaa"
 * Output 2:
 * "abba"
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 * We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 * Explanation 2:
 * We can see that longest palindromic substring is of length 4 and the string is "abba".
 *
 * A
 */
public class LongestPallindromeSubstring {

    /**
     * Approach:
     * his algorithm is called Expand Around Center.
     *
     * The key idea is:
     *
     * Every palindrome expands symmetrically from its center.
     *
     * For example:
     *
     * racecar
     *    e
     *
     * e is the center.
     *
     * If we keep checking left and right characters:
     *
     * c == c
     * a == a
     * r == r
     *
     * we get the palindrome "racecar".
     *
     * Important Observation
     *
     * A palindrome can have:
     *
     * 1. Odd Length
     *
     * Example:
     *
     * aba
     * racecar
     *
     * Center is a single character.
     *
     * 2. Even Length
     *
     * Example:
     *
     * abba
     * noon
     *
     * Center is between two characters.
     *
     * So for every index we do TWO expansions
     *
     * For index c:
     *
     * Odd length:
     * l = c-1
     * r = c+1
     * Even length:
     * l = c
     * r = c+1
     * Step-by-step Example
     *
     * Take:
     *
     * A = "abba"
     *
     * Indexes:
     *
     * 0 1 2 3
     * a b b a
     * Iteration 1 → c = 0
     * Odd Expansion
     *
     * Center = a
     *
     * l = -1
     * r = 1
     *
     * Invalid immediately.
     *
     * Palindrome = "a"
     *
     * Even Expansion
     * l = 0
     * r = 1
     *
     * a != b
     *
     * No palindrome.
     *
     * Iteration 2 → c = 1
     *
     * Character = b
     *
     * Odd Expansion
     * l = 0
     * r = 2
     *
     * a != b
     *
     * Only "b".
     *
     * Even Expansion
     *
     * THIS is important.
     *
     * l = 1
     * r = 2
     * b == b
     *
     * Expand:
     *
     * l = 0
     * r = 3
     * a == a
     *
     * Expand again:
     *
     * l = -1
     * r = 4
     *
     * Stop.
     *
     * Why length = r - l - 1 ?
     *
     * At stopping point:
     *
     * l = -1
     * r = 4
     *
     * But valid palindrome was:
     *
     * 0 to 3
     *
     * Length:
     *
     * 3 - 0 + 1 = 4
     *
     * Formula:
     *
     * r - l - 1
     * = 4 - (-1) - 1
     * = 4
     *
     * That is why:
     *
     * len = r - l - 1;
     * Why substring(l + 1, r) ?
     *
     * Because after loop:
     *
     * l and r are OUTSIDE palindrome
     *
     * Current:
     *
     * l = -1
     * r = 4
     *
     * Actual palindrome:
     *
     * 0 to 3
     *
     * So:
     *
     * str.substring(l + 1, r)
     *
     * becomes:
     *
     * str.substring(0, 4)
     *
     * which gives:
     *
     * "abba"
     * Complete Flow
     *
     * For every character:
     *
     * Try odd palindrome
     * Try even palindrome
     * Expand while left == right
     * Track longest palindrome
     * Complexity
     *
     * There are N centers.
     *
     * For each center we may expand up to N.
     *
     * So:
     *
     * Time Complexity = O(N²)
     * Space Complexity = O(1)
     * Visualization
     *
     * For "racecar":
     *
     * r a c e c a r
     *       ↑
     *
     * Expand from e.
     *
     * For "abba":
     *
     * a b b a
     *   ↑ ↑
     *
     * Expand from between the two bs.
     * @param str
     * @return
     */
    public String longestPalindrome(String str) {
        int n = str.length();

        int maxLen = 1;
        String ans = str.substring(0, 1);

        for (int c = 0; c < n; c++) {

            // Odd length palindrome
            int l = c - 1;
            int r = c + 1;

            while (l >= 0 && r < n &&
                    str.charAt(l) == str.charAt(r)) {
                l--;
                r++;
            }

            int len = r - l - 1;

            if (len > maxLen) {
                maxLen = len;
                ans = str.substring(l + 1, r);
            }

            // Even length palindrome
            l = c;
            r = c + 1;

            while (l >= 0 && r < n &&
                    str.charAt(l) == str.charAt(r)) {
                l--;
                r++;
            }

            len = r - l - 1;

            if (len > maxLen) {
                maxLen = len;
                ans = str.substring(l + 1, r);
            }
        }

        return ans;
    }
}
