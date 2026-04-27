package com.anshumanbiswal.internmediate.normal;

import java.util.ArrayList;

public class SubArrays {

    /**
     * Consider subarray by fixing the starting and ending indices of the array
     * iterate on that subarray to print that element
     * @param arr
     */
    static void solve(int[] arr) {
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end ++) {
                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i]);
                }
                System.out.println();
            }

        }
    }


    static void main() {
        int[] arr = {1,2,3,4,5,6};
        solve(arr);
    }
}
