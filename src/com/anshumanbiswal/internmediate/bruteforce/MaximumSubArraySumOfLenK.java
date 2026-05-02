package com.anshumanbiswal.internmediate.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;

/**
 */
public class MaximumSubArraySumOfLenK {

    // k is size of each subrray
    public static long maxSubArraySum(int[] arr, int k, int N) {
        int ans = Integer.MIN_VALUE;
        int s = 0;
        int e = k-1;
        while ( e < N) {
            int sum = 0;
            for (int i = s; i <= e ; ++i) {
                sum += arr[i];
            }
            ans = Integer.max(ans, sum);
            s++; e++;
        }
        return ans;
    }

    static void main() {
        int[] a = {2,1,3,4,5};
        System.out.println(maxSubArraySum(a,3, a.length));
    }
}
