package com.anshumanbiswal.internmediate.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Kth Smallest Element
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Find the Bth smallest element in given array A .
 *
 * NOTE: Users should try to solve it in less than equal to B swaps.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 100000
 *
 * 1 <= B <= min(|A|, 500)
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * The first argument is an integer array A.
 *
 * The second argument is integer B.
 *
 *
 *
 * Output Format
 *
 * Return the Bth smallest element in given array.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [2, 1, 4, 3, 2]
 * B = 3
 * Input 2:
 *
 * A = [1, 2]
 * B = 2
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  3rd element after sorting is 2.
 * Explanation 2:
 *
 *  2nd element after sorting is 2.
 */
public class KthSmallestElement {

    public static int kthsmallest(final List<Integer> A, int B) {
        Collections.sort(A);
        return A.get(B-1);
    }

    static void main() {
        Integer[] arr = {2, 1, 4, 3, 2};
        List<Integer> A = Arrays.asList(arr);
        System.out.println(kthsmallest(A, 3));

    }
}
