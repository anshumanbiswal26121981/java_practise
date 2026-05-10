package com.anshumanbiswal.internmediate.normal.TwoDArray;

import java.util.ArrayList;

/**
 * Given a square matrix print its diagonals.
 * Total diagonals for N*M matrix is N+M-1
 */
public class PrintDiagonal {

    /**
     * principal diagonal indexes
     * 0 0
     * 1 1
     * 2 2
     *
     * @param a
     * @return
     */
    public static int[] principalDiagonal(int[][] a) {
        int N = a.length;
        int[] result = new int[N];
        for (int i = 0; i < N; ++i) {
            result[i] = a[i][i];
        }
        return result;
    }

    /**
     * Principal anti diagonal index
     * 0 2
     * 1 1
     * 2 0
     * <p>
     * i+ j = N-1
     * j = N-1-i
     *
     * @param a
     * @return
     */
    public static int[] principalAntiDiagonal(int[][] a) {
        int N = a.length;
        int[] result = new int[N];
        for (int i = 0; i < N; ++i) {
            result[i] = a[i][N - 1 - i];
        }
        return result;
    }

    /**
     * Observations:
     * 1. All diagonals follows same movement pattern i.e row++ and col --
     * 2. all diagonals either start from first row or from the last column . making total count as N+M-1
     * <p>
     * Approach:
     * 0   1   2   3  4
     * 1
     * 2
     * 3
     * 4
     * 1. fix the starting point of first row. Move the diagonal until there are valid cells.
     * <p>
     * 2. repeat the process by fixing the starting point in the last column.
     *
     * @param A
     * @return
     */
    public static ArrayList<ArrayList<Integer>> allDiagonal(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        System.out.println("N = " + N);
        System.out.println("M = " + M);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        //step 1: fix the starting point of the first row
        int i = 0;
        for (int j = 0; j < M; ++j) {
            int row = i;
            int col = j;
            ArrayList<Integer> elements = new ArrayList<>();
            while (row < N && col >= 0) {
                System.out.println(A[row][col]);
                elements.add(A[row][col]);
                row++;
                col--;
            }
            System.out.println();
            // Pad with 0s
            while (elements.size() < M) {
                elements.add(0);
            }
            result.add(elements);
        }

        //step 2: fix the starting point of last column
        int j = M - 1;
        for (i = 1; i < N; ++i) {
            int row = i;
            int col = j;
            ArrayList<Integer> elements = new ArrayList<>();
            while (row < N && col >= 0) {
                System.out.println(A[row][col]);
                elements.add(A[row][col]);
                row++;
                col--;
            }
            System.out.println();
            // Pad with 0s
            while (elements.size() < N) {
                elements.add(0);
            }
            result.add(elements);

        }
        return result;

    }

    static void main() {

        int[][] a = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        System.out.println(allDiagonal(a));

    }
}


