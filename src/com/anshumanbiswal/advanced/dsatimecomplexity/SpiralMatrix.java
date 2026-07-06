package com.anshumanbiswal.advanced.dsatimecomplexity;

import java.util.ArrayList;
import java.util.List;

/**
 * For Spiral Matrix, traverse layer by layer:
 *
 * Top row: left → right
 * Right column: top → bottom
 * Bottom row: right → left
 * Left column: bottom → top
 *
 * Example
 *
 * For:
 *
 * 1   2   3
 * 4   5   6
 * 7   8   9
 *
 * Traversal:
 *
 * 1 → 2 → 3
 *         ↓
 * 4 → 5   6
 * ↑       ↓
 * 7 ← 8 ← 9
 *
 * Result:
 *
 * [1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 * The important part is these two conditions:
 *
 * if (top <= bottom)
 *
 * and
 *
 * if (left <= right)
 *
 * They prevent duplicate elements for rectangular matrices such as:
 *
 * 1  2  3  4
 * 5  6  7  8
 *
 * Time: O(N × M)
 * Extra space: O(1) excluding the returned result.
 */
public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(
            final List<ArrayList<Integer>> A) {

        ArrayList<Integer> ans = new ArrayList<>();

        int N = A.size();

        if (N == 0) {
            return ans;
        }

        int M = A.get(0).size();

        int top = 0;
        int bottom = N - 1;
        int left = 0;
        int right = M - 1;

        while (top <= bottom && left <= right) {

            // 1. Top row: left to right
            for (int j = left; j <= right; j++) {
                ans.add(A.get(top).get(j));
            }
            top++;

            // 2. Right column: top to bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(A.get(i).get(right));
            }
            right--;

            // 3. Bottom row: right to left
            if (top <= bottom) {

                for (int j = right; j >= left; j--) {
                    ans.add(A.get(bottom).get(j));
                }

                bottom--;
            }

            // 4. Left column: bottom to top
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    ans.add(A.get(i).get(left));
                }

                left++;
            }
        }

        return ans;
    }
}
