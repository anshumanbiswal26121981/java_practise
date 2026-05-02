package com.anshumanbiswal.internmediate.optimized.slidingwindow;

/**
 * Sliding windows technique: moving frm one subarray to next there is only a change in 2
 * elements, one being added while other being removed. if we know the summation of the base
 * window, we can get the summation of the next window in constant time.
 *
 * Note: Any scenario where subarray size is fixed then think of sliding window.
 */
public class MaximumSubArraySumOfLenK {

    // k is size of each subrray
    public static long maxSubArraySum(int[] arr, int k, int N) {
        // calculate the base window(base sum)
        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += arr[i];
        }
        int ans = sum;

        // move the windows by 1 to optimaly calculate the sum of remining windows
        int s = 1; int e = k;
        while ( e < N) {
            sum = sum + arr[e] - arr [s-1];
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
