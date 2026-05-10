package com.anshumanbiswal.internmediate.normal.TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *  Matrix Scalar Product
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * You are given a matrix A and and an integer B, you have to perform scalar multiplication of matrix A with an integer B.
 *
 *
 * Problem Constraints
 *
 * 1 <= A.size() <= 1000
 *
 * 1 <= A[i].size() <= 1000
 *
 * 1 <= A[i][j] <= 1000
 *
 * 1 <= B <= 1000
 *
 *
 *
 * Input Format
 *
 * First argument is 2D array of integers A representing matrix.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 *
 * You have to return a 2D array of integers after doing required operations.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [[1, 2, 3],
 *      [4, 5, 6],
 *      [7, 8, 9]]
 * B = 2
 * Input 2:
 * A = [[1]]
 * B = 5
 *
 *
 * Example Output
 *
 * Output 1:
 * [[2, 4, 6],
 * [8, 10, 12],
 * [14, 16, 18]]
 * Output 2:
 * [[5]]
 */
public class MatrixScalarProduct {
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size();
        int M = A.get(0).size();

        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < M; ++col) {
                int element = A.get(row).get(col);
                element *= B;
                A.get(row).set(col, element);
            }
        }

        return A;
    }

    static void main() {
        int [][] a= {
                {1,2,3}, {4,5,6},{7,8,9}
        };
        ArrayList<ArrayList<Integer>> A =
                Arrays.stream(a)
                        .map(row -> Arrays.stream(row)
                                .boxed()
                                .collect(Collectors.toCollection(ArrayList::new)))
                        .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(solve(A, 2));

        int [][] b= {
                {1}
        };
        ArrayList<ArrayList<Integer>> B =
                Arrays.stream(b)
                        .map(row -> Arrays.stream(row)
                                .boxed()
                                .collect(Collectors.toCollection(ArrayList::new)))
                        .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(solve(B,5));

    }
}
