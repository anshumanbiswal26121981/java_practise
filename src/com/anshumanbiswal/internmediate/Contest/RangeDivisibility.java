package com.anshumanbiswal.internmediate.Contest;

/**
 * Given an array A and multiple queries [L, R],
 * find how many numbers in that range are divisible by 7.
 *
 * Approach
 *
 * Create a prefix array where:
 *
 * prefix[i] = count of numbers divisible by 7 from 0 to i
 *
 * Then for any query:
 *
 * answer=prefix[R]−prefix[L−1]
 */
public class RangeDivisibility {
    /**
     * Example
     *
     * Input:
     *
     * A = [7, 2, 14, 21, 5]
     * queries = [[0,2], [1,4]]
     *
     * Divisible by 7:
     *
     * [1, 0, 1, 1, 0]
     *
     * Prefix:
     *
     * [1, 1, 2, 3, 3]
     *
     * Queries:
     *
     * [0,2] → 2
     * [1,4] → 2
     *
     * Output:
     *
     * [2, 2]
     * @param A
     * @param queries
     * @return
     */
    public int[] solve(int[] A, int[][] queries) {

        int n = A.length;

        // Prefix sum array
        int[] prefix = new int[n];

        // First element
        prefix[0] = (A[0] % 7 == 0) ? 1 : 0;

        // Build prefix array
        for (int i = 1; i < n; i++) {

            prefix[i] = prefix[i - 1];

            if (A[i] % 7 == 0) {
                prefix[i]++;
            }
        }

        int q = queries.length;

        int[] ans = new int[q];

        // Process queries
        for (int i = 0; i < q; i++) {

            int L = queries[i][0];
            int R = queries[i][1];

            if (L == 0) {
                ans[i] = prefix[R];
            } else {
                ans[i] = prefix[R] - prefix[L - 1];
            }
        }

        return ans;
    }
}
