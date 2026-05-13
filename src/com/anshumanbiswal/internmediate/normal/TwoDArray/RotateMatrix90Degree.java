package com.anshumanbiswal.internmediate.normal.TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Rotate Matrix

 * Problem Description
 *
 * You are given a n x n 2D matrix A representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * You need to do this in place.
 *
 * Note: If you end up using an additional array, you will only receive partial score.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= n <= 1000
 *
 *
 *
 * Input Format
 *
 * First argument is a 2D matrix A of integers
 *
 *
 *
 * Output Format
 *
 * Return the 2D rotated matrix.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  [
 *     [1, 2],
 *     [3, 4]
 *  ]
 * Input 2:
 *
 *  [
 *     [1, 2, 3],
 *     [4, 5, 6],
 *     [7, 8, 9]
 *  ]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [
 *     [3, 1],
 *     [4, 2]
 *  ]
 * Output 2:
 *
 *  [
 *     [7, 4, 1],
 *     [8, 5, 2],
 *     [9, 6, 3]
 *  ]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  After rotating the matrix by 90 degree:
 *  1 goes to 2, 2 goes to 4
 *  4 goes to 3, 3 goes to 1
 * Explanation 2:
 *
 *  After rotating the matrix by 90 degree:
 *  1 goes to 3, 3 goes to 9
 *  2 goes to 6, 6 goes to 8
 *  9 goes to 7, 7 goes to 1
 *  8 goes to 4, 4 goes to 2
 *
 *  Approach:
 *  1. Forst take transponse
 *
 *  1 2 3
 *  4 5 6
 *  7 8 9
 *
 *  would become
 *  1 4 7
 *  2 5 8
 *  3 6 9
 *
 *  now reverse the first and last element of each row
 *  7 4 1
 *  8 5 2
 *  9 6 3
 */
public class RotateMatrix90Degree {
    public static void solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B= transpose(A);
        int rowSize = B.size();
        int colSize = B.get(0).size();
        for (int row = 0; row < rowSize; ++row) {
            //reverse each row
            int left = 0;
            int right = rowSize - 1;

            while (left < right) {

                int temp = B.get(row).get(left);

                B.get(row).set(left, B.get(row).get(right));
                B.get(row).set(right, temp);

                left++;
                right--;
            }
        }

        // Copy back into original matrix A
        for (int i = 0; i < rowSize; i++) {

            for (int j = 0; j < rowSize; j++) {

                A.get(i).set(j, B.get(i).get(j));
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        int M = A.size();
        int N = A.get(0).size();
        for (int i = 0; i < N; i++) {
            transpose.add(new ArrayList<>());
        }
        for (int row = 0; row < M; row++ ) {
            for (int col = 0; col < N; ++col) {
                //tran[col][row] = A[row][col]
                transpose.get(col).add(A.get(row).get(col));
            }
        }
        return transpose;
    }

    static void main() {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        A.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        A.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        A.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        solve(A);
        System.out.println(A);

    }
}
