package com.anshumanbiswal.internmediate.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class RangeSum {

    static List<Integer> solve(int[] arr, int[][] queries) {
        int s,e,sum;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            s = queries[i][0];
            e = queries[i][1];
            sum = 0;
            for (int j = s; j <= e; ++j) {
                sum += arr[j];
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
