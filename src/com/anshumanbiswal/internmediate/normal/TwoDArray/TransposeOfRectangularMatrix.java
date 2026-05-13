package com.anshumanbiswal.internmediate.normal.TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;

public class TransposeOfRectangularMatrix {
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
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

        System.out.println(solve(A));
    }
}
