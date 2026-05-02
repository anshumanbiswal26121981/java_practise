package com.anshumanbiswal.internmediate.optimized.slidingwindow;

/**
 * Given an array A of size N, find the subarray of size B with the least average.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= B <= N <= 105
 * -105 <= A[i] <= 105
 *
 *
 * Input Format
 *
 * First argument contains an array A of integers of size N.
 * Second argument contains integer B.
 *
 *
 * Output Format
 *
 * Return the index of the first element of the subarray of size B that has least average.
 * Array indexing starts from 0.
 *
 *
 * Example Input
 *
 * Input 1:
 * A = [3, 7, 90, 20, 10, 50, 40]
 * B = 3
 * Input 2:
 *
 * A = [3, 7, 5, 20, -10, 0, 12]
 * B = 2
 *
 *
 *
 *
 *
 *
 * Example Output
 *
 * Output 1:
 * 3
 * Output 2:
 *
 * 4
 *
 *
 *
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 * Subarray between indexes 3 and 5
 * The subarray {20, 10, 50} has the least average
 * among all subarrays of size 3.
 * Explanation 2:
 *
 *  Subarray between [4, 5] has minimum average
 *
 *  Solution:
 *  Key idea:
 *
 * The subarray with the least average is the same as the subarray with the least sum (because window size B is constant).
 *
 * So instead of computing averages repeatedly, we just track the minimum window sum.
 *
 * Compute sum of first window of size B
 * Store it as minSum
 * Slide the window:
 * subtract outgoing element
 * add incoming element
 * Update minSum and index when a smaller sum appears
 * Return starting index of that window
 */
public class SubArrayWithLeastAverage {
    public static int leastAverageIndex(int[] A, int B) {
        int n = A.length;

        // Step 1: Calculate sum of first window
        long windowSum = 0;
        for (int i = 0; i < B; i++) {
            windowSum += A[i];
        }

        long minSum = windowSum;
        int minIndex = 0;

        // Step 2: Slide window
        for (int i = B; i < n; i++) {
            windowSum += A[i] - A[i - B];

            if (windowSum < minSum) {
                minSum = windowSum;
                minIndex = i - B + 1;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        int[] A = {3, 7, 90, 20, 10, 50, 40};
        int B = 3;

        System.out.println(leastAverageIndex(A, B)); // Output: 3
    }
}
