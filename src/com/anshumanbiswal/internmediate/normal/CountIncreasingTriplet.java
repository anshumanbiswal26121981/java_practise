package com.anshumanbiswal.internmediate.normal;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Count Increasing Triplets
 * Solved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * You are given an array A of N elements. Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 103
 * 1 <= A[i] <= 109
 *
 *
 * Input Format
 *
 * First argument A is an array of integers.
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
 * A = [1, 2, 4, 3]
 * Input 2:
 * A = [2, 1, 2, 3]
 *
 *
 * Example Output
 *
 * Output 1:
 * 2
 * Output 2:
 * 1
 *
 *
 * Example Explanation
 *
 * For Input 1:
 * The triplets that satisfy the conditions are [1, 2, 3] and [1, 2, 4].
 * For Input 2:
 *
 * The triplet that satisfy the conditions is [1, 2, 3].
 */
public class CountIncreasingTriplet {
    public static int solve(ArrayList<Integer> A) {
        int count = 0;
        for (int i = 0 ; i < A.size(); i ++) {
            for (int j = i; j < A.size(); ++j) {
                for (int k = j ; k < A.size(); ++k) {
                    if (i < j && j < k ) {
                        if (A.get(i) < A.get(j) && A.get(j) < A.get(k)) {
                            ++ count;
                        }
                    }
                }
            }
        }
        return count;
    }

    static void main() {
        int [] a = {1, 2, 4, 3};
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.stream(a).boxed().toList());
        System.out.println(solve(A));

        int [] b = {2,1,2,3};
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.stream(b).boxed().toList());
        System.out.println(solve(B));
    }
}
