package com.anshumanbiswal.internmediate.normal.TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Minor Diagonal Sum
 * Solved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
 *
 * Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based).
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 103
 *
 * -1000 <= A[i][j] <= 1000
 *
 *
 *
 * Input Format
 *
 * First and only argument is a 2D integer matrix A.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the sum of minor diagonal elements.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [[1, -2, -3],
 *       [-4, 5, -6],
 *       [-7, -8, 9]]
 * Input 2:
 *
 *  A = [[3, 2],
 *       [2, 3]]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  -5
 * Output 2:
 *
 *  4
 */
public class MinorDiagonalSum {
    public static int solve(final List<ArrayList<Integer>> A) {
        int N = A.size();
        int M = N; // as it is a square matrix
        int sum = 0;
        for (int i = 1; i < N+1 ; ++i) {
            for (int j = 1; j < M+1; ++j) {
                if (i + j == M+1) {
                    sum += A.get(i-1).get(j-1);
                }
            }
        }
        return sum;
    }

    static void main() {
        int[][] a = {{1, -2, -3}, {-4, 5, -6}, {-7, -8, 9}};
        ArrayList<ArrayList<Integer>> A =
                Arrays.stream(a)
                        .map(row -> Arrays.stream(row)
                                .boxed()
                                .collect(Collectors.toCollection(ArrayList::new)))
                        .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(solve(A));

        int[][] b = {{3,2}, {2,3}};
        ArrayList<ArrayList<Integer>> B =
                Arrays.stream(b)
                        .map(row -> Arrays.stream(row)
                                .boxed()
                                .collect(Collectors.toCollection(ArrayList::new)))
                        .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(solve(B));
    }
}
