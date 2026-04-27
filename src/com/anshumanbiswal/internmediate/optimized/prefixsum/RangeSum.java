package com.anshumanbiswal.internmediate.optimized.prefixsum;

import java.util.ArrayList;
import java.util.List;

public class RangeSum {
    /**
     * sum = pSum[end] - pSum [start -1] for start != 0
     * sum = pSum[end] for start ==0
     * @param arr
     * @param queries
     * @return
     */
    static List<Integer> solve(int[] arr, int[][] queries) {
        int s,e,sum;
        int[] prefixSum = PrefixSum.prefixSum(arr);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            s = queries[i][0];
            e = queries[i][1];
            if (s == 0) {
                sum = prefixSum[e];
            } else {
                sum = prefixSum[e] - prefixSum[s-1];
            }

            list.add(sum);
        }
        return list;
    }

    static void main() {
        int [] arr = {-5,10,20,40,35,-2,-10};
        int[][] queries = {{0,4},{1,2}, {2,5},{3,3}};

        System.out.println(solve(arr, queries));
    }
}
