package com.anshumanbiswal.internmediate.optimized.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *  Subarray with given sum and length
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Given an array A of length N. Also given are integers B and C.
 *
 * Return 1 if there exists a subarray with length B having sum C and 0 otherwise
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 104
 *
 * 1 <= B <= N
 *
 * 1 <= C <= 109
 *
 *
 *
 * Input Format
 *
 * First argument A is an array of integers.
 *
 * The remaining arguments B and C are integers
 *
 *
 *
 * Output Format
 *
 * Return 1 if such a subarray exist and 0 otherwise
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *
 * A = [4, 3, 2, 6, 1]
 * B = 3
 * C = 11
 * Input 2:
 *
 * A = [4, 2, 2, 5, 1]
 * B = 4
 * C = 6
 *
 *
 *
 *
 * Example Output
 *
 * Output 1:
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *
 * The subarray [3, 2, 6] is of length 3 and sum 11.
 *
 *
 * Explanation 2:
 *
 *
 * There are no such subarray.
 */
public class SubArrayWithGivenSumAndLength {

    public static int solve(ArrayList<Integer> A, int B, int C) {
        // calculate the base window(base sum)

        int N = A.size();
        int sum = 0;
        for (int i = 0; i < B; ++i) {
            sum += A.get(i);
        }

        if (sum == C) {
            return 1;
        }


        // move the windows by 1 to optimaly calculate the sum of remining windows
        int s = 1; int e = B;
        while ( e < N) {
            sum = sum + A.get(e) - A.get(s-1);
            if (sum == C) {
                return 1;
            }
            s++; e++;
        }

        return 0;
    }

    static void main() {

       int[]  a = {4, 3, 2, 6, 1};
       int B = 3;
       int C = 11;
       ArrayList<Integer> A = new ArrayList<Integer>(Arrays.stream(a).boxed().toList());
       System.out.println(solve(A, B, C));

       int[] a1 = {4, 2, 2, 5, 1};
       int B1 = 4;
       int C1 = 6;
       ArrayList<Integer> A1 = new ArrayList<Integer>(Arrays.stream(a1).boxed().toList());
        System.out.println(solve(A1, B1, C1));

    }
}
