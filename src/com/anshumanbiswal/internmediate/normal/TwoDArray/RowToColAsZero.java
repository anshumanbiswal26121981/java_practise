package com.anshumanbiswal.internmediate.normal.TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *  Row to Column Zero
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A.size() <= 103
 *
 * 1 <= A[i].size() <= 103
 *
 * 0 <= A[i][j] <= 103
 *
 *
 *
 * Input Format
 *
 * First argument is a 2D integer matrix A.
 *
 *
 *
 * Output Format
 *
 * Return a 2D matrix after doing required operations.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * [1,2,3,4]
 * [5,6,7,0]
 * [9,2,0,4]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [1,2,0,0]
 * [0,0,0,0]
 * [0,0,0,0]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
 *
 * Approach:
 * 1. In first iteration store ir simply mark thr presence of 0
 *   0   1   2   3
 * 0 1   2   3   4
 * 1 5   6   7   0
 * 2 9   2   0   4
 *
 * row: {0,1,0} and col: {0,0,0,1} in the row and col array mark the (1,3) as 1 since (1,3) index found is 0
 * again we found 0 in next iteration at (2,2). so mark the row and col array as follows
 * row: {0,1,1} and col: {0,0,1,1}
 *
 * 2. in the second iteration you refer the marker array and update
 * then in the next iteration start with the 0th row and check with the marked row and col array, which had mark of 1
 * we find that 0th row is not marked but 2 and 3 col is marked. So make the (0,2) and (0,3) as 0
 * In next iteration of 1th row. we find that 1th is is marked so make all the 1th row as 0
 * In next iteration of 2th row. we find that 2th is is marked so make all the 2th row as 0
 */
public class RowToColAsZero {
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        int[] rowMarker = new int[N];
        int[] colMarker = new int[M];

        //step 1: In first iteration store ir simply mark thr presence of 0
         for (int row = 0; row < N; ++row ) { //row
             for (int col = 0; col < M; ++col) { // col
                 if (A.get(row).get(col) == 0) {
                    rowMarker[row] = 1;
                    colMarker[col] = 1;
                 }
             }
         }

         //step 2: in the second iteration you refer the marker array and update the Array

        for (int row = 0; row < N; ++row ) { //row
            for (int col = 0; col < M; ++col) { // col
                if (rowMarker[row] ==  1 || colMarker[col] == 1 ) {
                    A.get(row).set(col, 0);
                }
            }
        }

        return A;

    }

    static void main() {
        int[][] a = {{1,2,3,4}, {5,6,7,0}, {9,2,0,4}};
        ArrayList<ArrayList<Integer>> A =
                Arrays.stream(a)
                        .map(row -> Arrays.stream(row)
                                .boxed()
                                .collect(Collectors.toCollection(ArrayList::new)))
                        .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(solve(A));
    }
}
