package com.anshumanbiswal.internmediate.normal.TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * . Row Sum
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * You are given a 2D matrix A of integers.
 *
 * Your task is to compute the sum of elements in each row and return a 1D array where each element represents the sum of a corresponding row in the matrix.
 *
 *
 * Problem Constraints
 *
 * 1 <= A.size() <= 103
 *
 *
 * 1 <= A[i].size() <= 103
 *
 * 1 <= A[i][j] <= 103
 *
 *
 *
 *
 *
 *
 * Input Format
 *
 * First argument A is a 2D array of integers.(2D matrix).
 *
 *
 *
 * Output Format
 *
 * Return an array containing row-wise sums of original matrix.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * [1,2,3,4]
 * [5,6,7,8]
 * [9,2,3,4]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [10,26,18]
 *
 *
 * Example Explanation
 *
 * Explanation 1
 *
 * Row 1 = 1+2+3+4 = 10
 * Row 2 = 5+6+7+8 = 26
 * Row 3 = 9+2+3+4 = 18
 */
public class RowSum {
    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int sum = 0;
        int col = A.get(0).size();
        int row = A.size();
        for (int r = 0; r < row; r++) {
            sum = 0;
            for (int c = 0; c < col; ++c) {
                sum += A.get(r).get(c);
            }
            result.add(sum);
        }

        return result;
    }

    static void main() {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 2, 3, 4}};

        ArrayList<ArrayList<Integer>> A =
                Arrays.stream(a)
                        .map(row -> Arrays.stream(row)
                                .boxed()
                                .collect(Collectors.toCollection(ArrayList::new)))
                        .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(solve(A));

    }
}
