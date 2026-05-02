package com.anshumanbiswal.internmediate.optimized.prefixsum;

/**
 * . Pick from both sides!
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * You are given an integer array A of size N.
 *
 * You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
 *
 * Find and return the maximum possible sum of the B elements that were removed after the B operations.
 *
 * NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
 *
 * Remove 3 elements from front and 0 elements from the back, OR
 * Remove 2 elements from front and 1 element from the back, OR
 * Remove 1 element from front and 2 elements from the back, OR
 * Remove 0 elements from front and 3 elements from the back.
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * 1 <= B <= N
 *
 * -103 <= A[i] <= 103
 *
 *
 *
 *
 *
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 *
 *
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the maximum possible sum of elements you removed.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *
 *
 *
 *
 *
 *  A = [5, -2, 3 , 1, 2]
 *  B = 3
 * Input 2:
 *
 *  A = [ 2, 3, -1, 4, 2, 1 ]
 *  B = 4
 *
 *
 *
 *
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *
 *
 *
 *
 *
 *  8
 * Output 2:
 *
 *  9
 *
 *
 *
 *
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *
 *
 *
 *
 *
 *  Remove element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
 * Explanation 2:
 *
 *  Remove the first element and the last 3 elements. So we get 2 + 4 + 2 + 1 = 9
 *
 *  Solution:
 *  This problem is a classic pick-from-both-ends optimization task. The key idea is:
 *
 * Instead of trying all combinations explicitly, compute:
 *
 * take k elements from the left
 * take B − k elements from the right
 * try all k = 0 → B
 * and track the maximum sum.
 *
 * This gives an O(B) solution (after initial setup), which easily works for N ≤ 10⁵ 🚀
 *
 * Efficient Approach (Prefix + Suffix Swap Trick)
 *
 * Steps:
 *
 * Take the first B elements → initial sum.
 * Then gradually:
 * remove one element from the left part
 * add one element from the right part
 * Update max each time.
 * Example Walkthrough
 *
 * For:
 *
 * A = [5, -2, 3, 1, 2]
 * B = 3
 *
 * Start:
 *
 * sum = 5 + (-2) + 3 = 6
 *
 * Shift picks from right:
 *
 * remove 3, add 2 → sum = 5
 * remove -2, add 1 → sum = 8  ✅ max
 * remove 5, add 3 → sum = 6
 *
 * Answer = 8
 *
 */
public class PickFromBothSides {
    public static int solve(int[] A, int B) {
        int N = A.length;

        int sum = 0;

        // Step 1: take first B elements
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }

        int maxSum = sum;

        // Step 2: replace left picks with right picks gradually
        for (int i = 1; i <= B; i++) {
            sum -= A[B - i];        // remove from left side
            sum += A[N - i];        // add from right side
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    static void main() {
        int[] A = {5, -2, 3 , 1, 2};
        int B = 3;
        System.out.println(solve(A,B));
    }
}
