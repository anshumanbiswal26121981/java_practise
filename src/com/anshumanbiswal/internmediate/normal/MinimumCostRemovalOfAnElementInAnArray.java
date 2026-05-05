package com.anshumanbiswal.internmediate.normal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Given an n element array , at every step rempove an element in an array.
 * Cost to remove an element = Sum of array of elements present in an array.
 * Find minumum cost to remove all elements.
 *
 * ex {a,b,c,d}
 *
 * remove element   cost
 *  a               a+b+c+d
 *  b                 b+c+d
 *  c                   c+d
 *  d                     d
 *  ------------------------
 *  Total cost =     a+2b+3c+4d
 *  objective is to minimize the Total cost
 *  It can be minimum only if a > b > c > d
 *
 *  Solution is Sort the array in descending order. Iterat on the array and add (i+1)*a[i]
 */
public class MinimumCostRemovalOfAnElementInAnArray {

    public static int minCost(Integer[] arr) {
        int ans = 0;
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            ans += (i+1) * arr[i];
        }

        return ans;
    }

    static void main() {
        Integer[] arr = {2,1,4};
        System.out.println(minCost(arr));
    }
}
