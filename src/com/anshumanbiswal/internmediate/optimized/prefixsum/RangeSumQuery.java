package com.anshumanbiswal.internmediate.optimized.prefixsum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Range Sum Query
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * You are given an integer array A of length N.
 * You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
 * For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
 * More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N, M <= 105
 * 1 <= A[i] <= 109
 * 0 <= L <= R < N
 *
 *
 * Input Format
 *
 * The first argument is the integer array A.
 * The second argument is the 2D integer array B.
 *
 *
 * Output Format
 *
 * Return an integer array of length M where ith element is the answer for ith query in B.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *
 * A = [1, 2, 3, 4, 5]
 * B = [[0, 3], [1, 2]]
 * Input 2:
 *
 * A = [2, 2, 2]
 * B = [[0, 0], [1, 2]]
 *
 *
 *
 *
 * Example Output
 *
 * Output 1:
 * [10, 5]
 * Output 2:
 *
 * [2, 4]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *
 * The sum of all elements of A[0 ... 3] = 1 + 2 + 3 + 4 = 10.
 * The sum of all elements of A[1 ... 2] = 2 + 3 = 5.
 * Explanation 2:
 *
 * The sum of all elements of A[0 ... 0] = 2 = 2.
 * The sum of all elements of A[1 ... 2] = 2 + 2 = 4.
 */
public class RangeSumQuery {
    public static ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        Long sum;
        int s,e;
        long[] prefixSum =  pSum(A);
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            s = B.get(i).get(0);
            e =  B.get(i).get(1);
            if (s == 0) {
                sum = prefixSum[e];
            } else {
                sum = prefixSum[e] - prefixSum[s-1];
            }

            list.add(sum);
        }
        return list;
    }

    public static long[] pSum (ArrayList<Integer> arr) {
        long[] pSum = new long[arr.size()];
        pSum[0] = arr.get(0);
        for (int i = 1; i < arr.size(); ++i) {
            pSum[i] = arr.get(i) + pSum[i-1];
        }
        return pSum;

    }

    static void main() {
        int[] a = {1, 2, 3, 4, 5};
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.stream(a).boxed().toList());
        int[][] b = {{0, 3}, {1, 2}};

        ArrayList<ArrayList<Integer>> B =
                Arrays.stream(b)
                        .map(row -> Arrays.stream(row)
                                .boxed()
                                .collect(java.util.stream.Collectors.toCollection(ArrayList::new)))
                        .collect(java.util.stream.Collectors.toCollection(ArrayList::new));

        System.out.println(rangeSum(A,B));
    }
}
