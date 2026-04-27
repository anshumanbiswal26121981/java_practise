package com.anshumanbiswal.internmediate.optimized.prefixsum;

import java.util.ArrayList;

/**
 * Special Index
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 * -105 <= A[i] <= 105
 * Sum of all elements of A <= 109
 *
 *
 * Input Format
 *
 * First argument contains an array A of integers of size N
 *
 *
 * Output Format
 *
 * Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 * A = [2, 1, 6, 4]
 * Input 2:
 *
 * A = [1, 1, 1]
 *
 *
 * Example Output
 *
 * Output 1:
 * 1
 * Output 2:
 *
 * 3
 *
 * Example Explanation
 *
 * Explanation 1:
 * Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
 * Therefore, the required output is 1.
 * Explanation 2:
 *
 * Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
 * Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
 * Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
 * Therefore, the required output is 3.
 */
public class SpecialIndex {

    /**
     * Based on the observation that removing any element from the given array makes even indices of succeeding elements
     * as odd and odd indices of the succeeding elements as even.
     * Follow the steps below to solve the problem:
     *
     * Initialize two variables, say evenSum and oddSum,
     * to store the sum of odd-indexed and even-indexed elements of the given array respectively.
     *
     * Traverse the array using variable i.
     * Remove every ith element of the array and update the sum of the remaining even-indexed elements
     * and the odd-indexed elements based on the above observation. Check if the sums are equal or not.
     * If found to be true, then increment the count.
     *
     * Sum of all odd indices after removing an element in the iTh index =
     * Sum of all odd  indices [0, i-1] + sum of all even indices[i+1, N-1]
     * Sodd = Sodd[0,i-1] + Seven[i+1, N-1]
     * = pSumOdd[i-1] + pSumEven[N-1] - pSumEven[i+1 - 1];
     *
     * Sum of all even indices after removing an element in the iTh index =
     *
     *
     * Seven = Seven[0,i-1] + Sodd[i+1, N-1]
     * Seven = pSumEven[i-1] + pSumOdd[N-1] - pSumOdd[i+1 - 1]
     * @param A
     * @return
     */
    public int solve(ArrayList<Integer> A) {
        int[] pSumEven = PrefixSum.evenIndexPrefixSum(A);
        int[] pSumOdd = PrefixSum.oddIndexPrefixSum(A);
        int Se = 0, So = 0;
        int N = A.size();
        int count = 0;
        for (int i = 0; i < N; ++i) {
            if (i == 0) {
                Se = pSumOdd[N-1] - pSumOdd[0];
                So = pSumEven[N-1] - pSumEven[0];
            } else {
                Se = pSumOdd[N-1] - pSumOdd[i] + pSumEven [i-1];
                So = pSumEven[N-1] - pSumEven[i] + pSumOdd[i-1];
            }
            if (Se == So) {
                ++count;
            }
        }

        return count;
    }
}
