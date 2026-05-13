package com.anshumanbiswal.internmediate.normal.Strings;

/**
 *  Length of longest consecutive ones
 *
 * The only argument given is string A.
 * Output Format
 *
 * Return the length of the longest consecutive 1’s that can be achieved.
 * Constraints
 *
 * 1 <= length of string <= 1000000
 * A contains only characters 0 and 1.
 * For Example
 *
 * Input 1:
 *     A = "111000"
 * Output 1:
 *     3
 *
 * Input 2:
 *     A = "111011101"
 * Output 2:
 *     7
 *
 *     Efficient Approach
 *
 * For every index:
 *
 * Count consecutive left 1s
 * Count consecutive right 1s
 *
 * If current char is 0:
 *
 * left[i]+right[i]+1
 *
 * But answer cannot exceed total count of 1s.
 */
public class MaxLengthOfConsecutiveOnes {
    public static  int solve(String A) {
        int n = A.length();

        int totalOnes = 0;

        // Count total ones
        for (int i = 0; i < n; i++) {

            if (A.charAt(i) == '1') {
                totalOnes++;
            }
        }

        // Edge case
        if (totalOnes == n) {
            return n;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        // Build left array
        if (A.charAt(0) == '1') {
            left[0] = 1;
        }

        for (int i = 1; i < n; i++) {

            if (A.charAt(i) == '1') {
                left[i] = left[i - 1] + 1;
            }
        }

        // Build right array
        if (A.charAt(n - 1) == '1') {
            right[n - 1] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {

            if (A.charAt(i) == '1') {
                right[i] = right[i + 1] + 1;
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (A.charAt(i) == '0') {

                int leftOnes = 0;
                int rightOnes = 0;

                if (i > 0) {
                    leftOnes = left[i - 1];
                }

                if (i < n - 1) {
                    rightOnes = right[i + 1];
                }

                int total = leftOnes + rightOnes;

                // If extra 1 exists somewhere else
                if (total < totalOnes) {
                    total++;
                }

                ans = Math.max(ans, total);
            }
        }

        return ans;
    }

    static void main() {
        System.out.println(solve("111000"));

    }
}
