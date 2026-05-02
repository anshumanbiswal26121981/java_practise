package com.anshumanbiswal.internmediate.optimized.prefixsum;

/**
 *  Good Subarrays Easy
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
 * 1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
 * 2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
 * Your task is to find the count of good subarrays in A.
 *
 *
 * Problem Constraints
 *
 * 1 <= len(A) <= 5 x 103
 * 1 <= A[i] <= 103
 * 1 <= B <= 107
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is an integer B.
 *
 *
 * Output Format
 *
 * Return the count of good subarrays in A.
 *
 *
 * Example Input
 *
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = 4
 * Input 2:
 *
 * A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
 * B = 65
 *
 *
 * Example Output
 *
 * Output 1:
 * 6
 * Output 2:
 *
 * 36
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 * Even length good subarrays = {1, 2}
 * Odd length good subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5}
 * Explanation 1:
 * There are 36 good subarrays
 *
 *This problem cannot be solved with a standard sliding window efficiently because:
 *
 * Window size is not fixed
 * Condition depends on both length parity (odd/even) and sum
 * Sum condition changes differently for odd vs even lengths
 *
 * Instead, the clean solution is prefix sum + nested loop (O(N²)), which is acceptable since:
 *
 * N ≤ 5000  →  N² = 25,000,000 ✔️
 *
 * Approach (Prefix Sum)
 *
 * For every subarray A[i..j]:
 *
 * Compute length = j − i + 1
 * Compute sum using prefix sum
 * Check condition:
 * if even length → sum < B
 * if odd length → sum > B
 * Increment count
 */
public class GoodSubArrays {

    public static int countGoodSubarrays(int[] A, int B) {

        int n = A.length;
        int count = 0;

        // prefix sum array
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + A[i];
        }

        // check all subarrays
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {

                int length = end - start + 1;
                long sum = prefix[end + 1] - prefix[start];

                if (length % 2 == 0) {
                    if (sum < B) {
                        count++;
                    }
                } else {
                    if (sum > B) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5};
        int B = 4;

        System.out.println(countGoodSubarrays(A, B)); // Output: 6
    }

}
