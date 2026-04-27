package com.anshumanbiswal.internmediate.optimized.prefixsum;

import java.util.ArrayList;
import java.util.List;

public class SumOfEvenIndexElementsWithinRange {

    static List<Integer> solve (int [] arr, int[][]queries) {
        int s,e,sum;
        int[] prefixSum = PrefixSum.evenIndexPrefixSum(arr);
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
        int[] arr = {2,3,1,6,4,5};
        int[][] queries = {{1,3},{2,5},{0,4},{3,3}};
        System.out.println(solve(arr, queries));
    }
}
