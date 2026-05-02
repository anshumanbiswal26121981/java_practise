package com.anshumanbiswal.internmediate.normal;

/**
 *  Closest MinMax
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
 *
 * and at least one occurrence of the minimum value of the array.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 2000
 *
 *
 *
 * Input Format
 *
 * First and only argument is vector A
 *
 *
 *
 * Output Format
 *
 * Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 3, 2]
 * Input 2:
 *
 * A = [2, 6, 1, 6, 9]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
 * Explanation 2:
 *
 *  Take the last 3 elements of the array.
 */
public class ClosestMinMax {
        public static int solve(int[] A) {
            int n = A.length;

            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;

            // Step 1: find global min and max
            for (int num : A) {
                minVal = Math.min(minVal, num);
                maxVal = Math.max(maxVal, num);
            }

            // Edge case: if min == max
            if (minVal == maxVal) {
                return 1;
            }

            int lastMin = -1;
            int lastMax = -1;
            int ans = n;

            // Step 2: single pass tracking indices
            for (int i = 0; i < n; i++) {
                if (A[i] == minVal) {
                    lastMin = i;
                    if (lastMax != -1) {
                        ans = Math.min(ans, i - lastMax + 1);
                    }
                }

                if (A[i] == maxVal) {
                    lastMax = i;
                    if (lastMin != -1) {
                        ans = Math.min(ans, i - lastMin + 1);
                    }
                }
            }

            return ans;
        }

    static void main() {
        int[] A = {2, 6, 1, 6, 9};
        System.out.println(solve(A));
    }
}
