package com.anshumanbiswal.internmediate.normal;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Generate all subarrays
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * You are given an array A of N integers.
 * Return a 2D array consisting of all the subarrays of the array
 *
 * Note : The order of the subarrays in the resulting 2D array does not matter.
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 100
 * 1 <= A[i] <= 105
 *
 *
 * Input Format
 *
 * First argument A is an array of integers.
 *
 *
 * Output Format
 *
 * Return a 2D array of integers in any order.
 *
 *
 * Example Input
 *
 * Input 1:
 * A = [1, 2, 3]
 * Input 2:
 * A = [5, 2, 1, 4]
 *
 *
 * Example Output
 *
 * Output 1:
 * [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
 * Output 2:
 * [[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]
 *
 *
 * Example Explanation
 *
 * For Input 1:
 * All the subarrays of the array are returned. There are a total of 6 subarrays.
 * For Input 2:
 * All the subarrays of the array are returned. There are a total of 10 subarrays.
 */
public class SubArrays2 {


    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        for (int start = 0; start < A.size(); start++) {
            for (int end = start; end < A.size(); end ++) {
                ArrayList<Integer> arr = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    arr.add(A.get(i));
                }
                answer.add(arr);
            }

        }
        return answer;
    }

    static void main() {
        int[] a = {5, 2, 1, 4};
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.stream(a).boxed().toList());
        System.out.println(solve(A));
    }

}
