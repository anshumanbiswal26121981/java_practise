package com.anshumanbiswal.internmediate.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  N/3 Repeat Number
 * Solved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
 * If so, return the integer. If not, return -1.
 *
 * If there are multiple solutions, return any one.
 *
 * Note: Read-only array means that the input array should not be modified in the process of solving the problem
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 7*105
 * 1 <= A[i] <= 109
 *
 *
 * Input Format
 *
 * The only argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return an integer.
 *
 *
 * Example Input
 *
 * Input 1:
 * [1 2 3 1 1]
 * Input 2:
 * [1 2 3]
 *
 *
 * Example Output
 *
 * Output 1:
 * 1
 * Output 2:
 * -1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 * 1 occurs 3 times which is more than 5/3 times.
 * Explanation 2:
 * No element occurs more than 3 / 3 = 1 times in the array.
 */
public class RepeatedNumbers {

    /**
     * If an element appears more than: N/3
     * times, then there can be at most 2 such elements.
     *
     * Why?
     *
     * Because 3 different elements occurring more than N/3 times would exceed N.
     *
     * So we only need to track:
     *
     * 2 candidates
     * 2 counts
     *
     * Note:
     * Key Interview Point
     * For Majority > N/k
     *
     * You need:
     *
     * k−1
     *
     * candidates.
     *
     * Examples:
     *
     * N/2 → 1 candidate
     *
     * N/3 → 2 candidates
     *
     * N/4 → 3 candidates
     * Approach:
     *
     * Step 1
     *
     * Find possible candidates using Boyer-Moore logic.
     *
     * Step 2
     *
     * Verify whether any candidate actually occurs more than N/3.
     *
     * DryRun:
     * Dry Run
     *
     * Array:
     *
     * [1,2,3,1,1,2,1]
     * Step 1
     * num = 1
     * count1 = 0
     *
     * So:
     *
     * candidate1 = 1
     * count1 = 1
     * Step 2
     * num = 2
     * count2 = 0
     *
     * So:
     *
     * candidate2 = 2
     * count2 = 1
     * Step 3
     * num = 3
     *
     * Different from both candidates.
     *
     * So:
     *
     * count1--
     * count2--
     *
     * Now:
     *
     * count1 = 0
     * count2 = 0
     *
     * All three got cancelled.
     *
     * Step 4
     * num = 1
     *
     * count1 = 0
     *
     * So:
     *
     * candidate1 = 1
     * count1 = 1
     *
     * Eventually 1 survives because it appears many times.
     * @param a
     * @return
     */
    public static int repeatedNumber(final List<Integer> a) {
        int n = a.size();

        int candidate1 = -1;
        int candidate2 = -1;

        int count1 = 0;
        int count2 = 0;

        // Step 1: Find possible candidates
        for (int num : a) {

            if (candidate1 == num) {

                count1++;

            } else if (candidate2 == num) {

                count2++;

            } else if (count1 == 0) {

                candidate1 = num;
                count1 = 1;

            } else if (count2 == 0) {

                candidate2 = num;
                count2 = 1;

            } else {

                count1--;
                count2--;
            }
        }

        // Step 2: Verify counts
        count1 = 0;
        count2 = 0;

        for (int num : a) {

            if (num == candidate1) {
                count1++;
            }

            else if (num == candidate2) {
                count2++;
            }
        }

        if (count1 > n / 3) {
            return candidate1;
        }

        if (count2 > n / 3) {
            return candidate2;
        }

        return -1;
    }

    static void main() {
        int[] a = {1, 2, 3, 1, 1};
        List<Integer> A = new ArrayList<Integer>(Arrays.stream(a).boxed().toList());
        System.out.println(repeatedNumber(A));
    }
}
