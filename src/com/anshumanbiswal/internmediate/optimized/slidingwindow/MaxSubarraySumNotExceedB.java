package com.anshumanbiswal.internmediate.optimized.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Maximum Subarray Easy
 * Attempted
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
 * But the sum must not exceed B.
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 103
 * 1 <= B <= 109
 * 1 <= C[i] <= 106
 *
 *
 * Input Format
 *
 * The first argument is the integer A.
 * The second argument is the integer B.
 * The third argument is the integer array C.
 *
 *
 * Output Format
 *
 * Return a single integer which denotes the maximum sum.
 *
 *
 * Example Input
 *
 * Input 1:
 * A = 5
 * B = 12
 * C = [2, 1, 3, 4, 5]
 * Input 2:
 *
 * A = 3
 * B = 1
 * C = [2, 2, 2]
 *
 *
 * Example Output
 *
 * Output 1:
 * 12
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 * We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
 * Explanation 2:
 *
 * All elements are greater than B, which means we cannot select any subarray.
 * Hence, the answer is 0.
 */
public class MaxSubarraySumNotExceedB {

    public static int maxSubarray(int A, int B, ArrayList<Integer> C) {
        int start = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int end = 0; end < A; end++) {
            currentSum += C.get(end);

            // Shrink window if sum exceeds B
            while (currentSum > B && start <= end) {
                currentSum -= C.get(start);
                start++;
            }

            // Update max sum if valid
            if (currentSum <= B) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    static void main() {
        int[] c = {2, 1,3,4,5};
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.stream(c).boxed().toList());
        System.out.println(maxSubarray(5,12,C));
    }
}
