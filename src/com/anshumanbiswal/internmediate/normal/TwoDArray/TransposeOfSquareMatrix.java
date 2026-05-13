package com.anshumanbiswal.internmediate.normal.TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * atrix Transpose
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Given a 2D integer array A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 *
 *
 * Problem Constraints
 *
 * 1 <= A.size() <= 1000
 *
 *
 *
 *
 *
 *
 * 1 <= A[i].size() <= 1000
 *
 * 1 <= A[i][j] <= 1000
 *
 *
 *
 *
 *
 *
 * Input Format
 *
 * First argument is a 2D matrix of integers.
 *
 *
 *
 *
 *
 * Output Format
 *
 * You have to return the Transpose of this 2D matrix.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *
 *
 *
 * A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
 * Input 2:
 *
 * A = [[1, 2],[1, 2],[1, 2]]
 *
 *
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *
 *
 *
 *
 *
 * [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
 * Output 2:
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * [[1, 1, 1], [2, 2, 2]]
 *
 *
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Clearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
 *  we will get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].
 * Explanation 2:
 *
 * After transposing the matrix, A becomes [[1, 1, 1], [2, 2, 2]]
 */
public class TransposeOfSquareMatrix {

    /**
     * Observation:
     * 1. Principal diagonal remains same
     * 2. Every elemnt at index(i,j) has been swapped with elements at index(j,i)
     *
     * Approach:
     *
     * Iterate either of the two halves and swap i,j with j,i
     * @param A
     * @return
     */
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        for (int i = 0; i < N; ++i) {
            for (int j = i+1; j < N; ++j) {
                //swap a[i][j] with a[j][i]
                int temp = A.get(i).get(j);
                //A[i][j] = A[j][i];
                A.get(i).set(j, A.get(j).get(i));
                //A[j][i] = temp;
                A.get(j).set(i, temp);
            }
        }
        return A;
    }

    static void main() {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        A.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        A.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        A.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        System.out.println(solve(A));
    }


}
