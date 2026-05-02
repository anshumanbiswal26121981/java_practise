package com.anshumanbiswal.internmediate.optimized.slidingwindow;

/**
 * Minimum Swaps
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
 *
 * Note: It is possible to swap any two elements, not necessarily consecutive.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length of the array <= 100000
 * -109 <= A[i], B <= 109
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 *
 * Return the minimum number of swaps.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 12, 10, 3, 14, 10, 5]
 *  B = 8
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *  B = 20
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  A = [1, 12, 10, 3, 14, 10, 5]
 *  After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
 *  After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
 *  Now, all elements less than or equal to 8 are together.
 * Explanation 2:
 *
 *  A = [5, 17, 100, 11]
 *  After swapping 100 and 11, A => [5, 17, 11, 100].
 *  Now, all elements less than or equal to 20 are together.
 *
 *  Solution:
 *  Count how many elements are ≤ B (these are the “good” elements).
 * Then find a window of that size containing the maximum number of good elements.
 * Minimum swaps = number of bad elements inside that window.
 *
 * Because each bad element inside the window must be swapped out
 *
 * Count how many elements are ≤ B → call this goodCount
 * Take a window of size goodCount
 * Count how many elements inside the window are > B → call this badCount
 * Slide the window across the array
 * Track the minimum badCount
 * That minimum value = answer
 *
 * Why this works
 *
 * We want all ≤ B elements together.
 *
 * So we:
 *
 * fix window size = number of such elements
 * minimize unwanted elements inside it
 * each unwanted element needs 1 swap
 *
 * Thus:
 *
 * min swaps = minimum bad elements in window
 *
 */
public class MinimumSwaps {

        public static int minSwaps(int[] A, int B) {
            int n = A.length;

            // Step 1: Count elements <= B
            int goodCount = 0;
            for (int num : A) {
                if (num <= B) {
                    goodCount++;
                }
            }

            // Step 2: Count bad elements in first window
            int badCount = 0;
            for (int i = 0; i < goodCount; i++) {
                if (A[i] > B) {
                    badCount++;
                }
            }

            int minSwaps = badCount;

            // Step 3: Slide window
            for (int i = 0, j = goodCount; j < n; i++, j++) {

                // remove outgoing element
                if (A[i] > B) {
                    badCount--;
                }

                // add incoming element
                if (A[j] > B) {
                    badCount++;
                }

                minSwaps = Math.min(minSwaps, badCount);
            }

            return minSwaps;
        }

        public static void main(String[] args) {
            int[] A = {1, 12, 10, 3, 14, 10, 5};
            int B = 8;

            System.out.println(minSwaps(A, B)); // Output: 2
        }

}
