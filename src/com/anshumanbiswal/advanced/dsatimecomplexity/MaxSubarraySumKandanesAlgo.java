package com.anshumanbiswal.advanced.dsatimecomplexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Max Sum Contiguous Subarray
 * Solved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Given an array A of length N, your task is to find the maximum possible sum of any non-empty contiguous subarray.
 *
 * In other words, among all possible subarrays of A, determine the one that yields the highest sum and return that sum.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 106
 * -1000 <= A[i] <= 1000
 *
 *
 *
 * Input Format
 *
 * The first and the only argument contains an integer array, A.
 *
 *
 *
 * Output Format
 *
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, -10]
 * Input 2:
 *
 *  A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 * Explanation 2:
 *
 *  The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
public class MaxSubarraySumKandanesAlgo {

    public static int maxSubArray(final List<Integer> A) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); ++i) {
            currSum += A.get(i);
            maxSum = Integer.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }

        }
        return maxSum;
    }

    static void main() {
        int[] a = {1, 2, 3, 4, -10};
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.stream(a).boxed().toList());

        int[] b = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.stream(b).boxed().toList());

        System.out.println(maxSubArray(A));
        System.out.println(maxSubArray(B));
    }
}
