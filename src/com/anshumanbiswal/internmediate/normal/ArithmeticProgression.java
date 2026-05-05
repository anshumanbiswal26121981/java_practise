package com.anshumanbiswal.internmediate.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *  Arithmetic Progression?
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.
 *
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 *
 *
 *
 * Problem Constraints
 *
 * 2 <= N <= 105
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * The first and only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 *
 * Return 1 if the array can be rearranged to form an arithmetic progression, otherwise return 0.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [3, 5, 1]
 * Input 2:
 *
 *  A = [2, 4, 1]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  We can reorder the elements as [1, 3, 5] or [5, 3, 1] with differences 2 and -2 respectively, between each consecutive elements.
 * Explanation 2:
 *
 *  There is no way to reorder the elements to obtain an arithmetic progression.
 */
public class ArithmeticProgression {
    public static int solve(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);

        int diff = A.get(1) - A.get(0);

        for (int i = 2; i < n; i++) {
            if (A.get(i) - A.get(i-1) != diff) {
                return 0;
            }
        }

        return 1;
    }

    static void main() {
        int[] a =  {3,5,1};
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.stream(a).boxed().toList());
        System.out.println(solve(list1));
    }
}
