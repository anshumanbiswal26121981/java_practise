package com.anshumanbiswal.internmediate.normal.TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *  Column Sum
 * Solved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A.size() <= 103
 *
 * 1 <= A[i].size() <= 103
 *
 * 1 <= A[i][j] <= 103
 *
 *
 *
 * Input Format
 *
 * First argument is a 2D array of integers.(2D matrix).
 *
 *
 *
 * Output Format
 *
 * Return an array containing column-wise sums of original matrix.
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
 * {15,10,13,16}
 *
 *
 * Example Explanation
 *
 * Explanation 1
 *
 * Column 1 = 1+5+9 = 15
 * Column 2 = 2+6+2 = 10
 * Column 3 = 3+7+3 = 13
 * Column 4 = 4+8+4 = 16
 */
public class ColSum {
    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int sum = 0;
        int col = A.get(0).size();
        int row = A.size();
        for (int c = 0; c < col; c++) {
            sum = 0;
            for (int r = 0; r < row; ++r) {
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
