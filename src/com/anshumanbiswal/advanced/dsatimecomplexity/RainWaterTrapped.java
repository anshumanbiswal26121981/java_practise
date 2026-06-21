package com.anshumanbiswal.advanced.dsatimecomplexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 *
 * Imagine a histogram where the bars' heights are given by the array A. Each bar is of uniform width, which is 1 unit. When it rains, water will accumulate in the valleys between the bars.
 *
 * Your task is to calculate the total amount of water that can be trapped in these valleys.
 *
 * Example:
 *
 * The Array A = [5, 4, 1, 4, 3, 2, 7] is visualized as below. The total amount of rain water trapped in A is 11.
 *
 *
 * Rain Water Trapped
 *
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 105
 * 0 <= A[i] <= 105
 *
 *
 *
 * Input Format
 *
 * First and only argument is the Integer Array, A.
 *
 *
 *
 * Output Format
 *
 * Return an Integer, denoting the total amount of water that can be trapped in these valleys
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [0, 1, 0, 2]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * 1 unit is trapped on top of the 3rd element.
 * Rain Water Histogram
 * Explanation 2:
 *
 * No water is trapped.
 */
public class RainWaterTrapped {
    public static int trap(final List<Integer> A) {
        int N = A.size();

        if (N <= 2) {
            return 0;
        }

        int ans = 0;

        int[] lmax = new int[N];
        int[] rmax = new int[N];

        // lmax[i] = maximum height from index 0 to i
        lmax[0] = A.get(0);
        for (int i = 1; i < N; i++) {
            lmax[i] = Math.max(A.get(i), lmax[i - 1]);
        }

        // rmax[i] = maximum height from index i to N - 1
        rmax[N - 1] = A.get(N - 1);
        for (int i = N - 2; i >= 0; i--) {
            rmax[i] = Math.max(A.get(i), rmax[i + 1]);
        }

        // water at i = min(left max, right max) - current height
        for (int i = 1; i < N - 1; i++) {
            int water = Math.min(lmax[i], rmax[i]) - A.get(i);

            if (water > 0) {
                ans += water;
            }
        }

        return ans;
    }

    static void main() {
        int [] a = {0, 1, 0, 2};
        int [] b = {1,2};
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.stream(a).boxed().toList());
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.stream(b).boxed().toList());
        System.out.println(trap(A));
        System.out.println(trap(B));

    }
}
