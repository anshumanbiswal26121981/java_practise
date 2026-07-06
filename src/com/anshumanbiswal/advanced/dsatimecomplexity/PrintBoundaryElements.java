package com.anshumanbiswal.advanced.dsatimecomplexity;

import java.util.ArrayList;

public class PrintBoundaryElements {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> ans = new ArrayList<>();

        int N = A.size();
        int M = A.get(0).size();

        // Case 1: Only one row
        if (N == 1) {
            for (int j = 0; j < M; j++) {
                ans.add(A.get(0).get(j));
            }
            return ans;
        }

        // Case 2: Only one column
        if (M == 1) {
            for (int i = 0; i < N; i++) {
                ans.add(A.get(i).get(0));
            }
            return ans;
        }

        // 1. Top row: left to right
        for (int j = 0; j < M; j++) {
            ans.add(A.get(0).get(j));
        }

        // 2. Right column: top to bottom
        // Start from row 1 because top-right is already added
        for (int i = 1; i < N; i++) {
            ans.add(A.get(i).get(M - 1));
        }

        // 3. Bottom row: right to left
        // Start from M-2 because bottom-right is already added
        for (int j = M - 2; j >= 0; j--) {
            ans.add(A.get(N - 1).get(j));
        }

        // 4. Left column: bottom to top
        // Skip both bottom-left and top-left
        for (int i = N - 2; i >= 1; i--) {
            ans.add(A.get(i).get(0));
        }

        return ans;
    }
}
