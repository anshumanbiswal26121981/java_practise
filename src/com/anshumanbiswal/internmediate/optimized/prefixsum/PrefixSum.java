package com.anshumanbiswal.internmediate.optimized.prefixsum;

import java.util.ArrayList;

/**
 * sum(l to r)=prefSum[r]−prefSum[l−1]
 */
public class PrefixSum {

    public static int[]  prefixSum(int[] arr) {
        int[] pSum = new int[arr.length];
        pSum[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            pSum[i] = arr[i] + pSum[i-1];
        }
        return pSum;
    }

    public static long[] pSum (ArrayList<Integer> arr) {
        long[] pSum = new long[arr.size()];
        pSum[0] = arr.get(0);
        for (int i = 1; i < arr.size(); ++i) {
            pSum[i] = arr.get(i) + pSum[i-1];
        }
        return pSum;

    }

    /**
     * Returns the Even index prefix sum
     * eg: {2,3,1,6,4,5}
     * even index pSum = {2,2,3,3,7,7}
     *
     * only add elements for even index and keep the same for odd index
     * pSumE[i]=pSumE[i-1] + arr[i] when i is even
     * pSumE[i] = pSumE[i-1] + 0 when i is odd
     * @param arr
     * @return
     */
    public static int[] evenIndexPrefixSum(int[] arr) {
        int[] pSum = new int[arr.length];
        pSum[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (i % 2 == 0) {
                pSum[i] = arr[i] + pSum[i-1];
            } else {
                pSum[i] = pSum[i-1];
            }

        }
        return pSum;
    }

    /**
     * Returns the Even index prefix sum
     * eg: {2,3,1,6,4,5}
     * even index pSum = {2,2,3,3,7,7}
     *
     * only add elements for even index and keep the same for odd index
     * pSumE[i]=pSumE[i-1] + arr[i] when i is even
     * pSumE[i] = pSumE[i-1] + 0 when i is odd
     * @param arr
     * @return
     */
    public static int[] evenIndexPrefixSum(ArrayList<Integer> arr) {
        int[] pSum = new int[arr.size()];
        pSum[0] = arr.get(0);
        for (int i = 1; i < arr.size(); ++i) {
            if (i % 2 == 0) {
                pSum[i] = arr.get(i) + pSum[i-1];
            } else {
                pSum[i] = pSum[i-1];
            }

        }
        return pSum;
    }

    /**
     * prefixCountEven[0] = 1 if arr[i] %2 == 0 else 0
     * prefixCountEven = prefixCountEven[i-1] + 1 if arr[i] %2 == 0
     * else
     * prefixCountEven = prefixCountEven[i-1]
     * @param A
     * @return
     */
    public static int[] prefixCountEven(ArrayList<Integer> A) {
        int[] pCount = new int[A.size()];
        pCount[0] = A.get(0) % 2 == 0 ? 1 : 0;
        for (int i = 1; i < A.size(); ++i) {
            if (A.get(i) % 2 == 0) {
                pCount[i] = pCount[i-1] + 1;
            } else {
                pCount[i] = pCount[i-1];
            }
        }
        return pCount;
    }

    /**
     * Returns the Odd index prefix sum
     * eg: {2,3,1,6,4,5}
     * odd index pSum = {0,3,3,9,9,14}
     *
     * only add elements for even index and keep the same for odd index
     * pSumO[i]=pSumO[i-1] + 0 when i is even
     * pSumO[i] = pSumE[i-1] + arr[i] when i is odd
     * @param arr
     * @return
     */
    public static int[] oddIndexPrefixSum(int[] arr) {
        int[] pSum = new int[arr.length];
        pSum[0] = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (i % 2 == 0) {
                pSum[i] = pSum[i-1];
            } else {
                pSum[i] = pSum[i-1] + arr[i];
            }

        }
        return pSum;
    }

    /**
     * Returns the Odd index prefix sum
     * eg: {2,3,1,6,4,5}
     * odd index pSum = {0,3,3,9,9,14}
     *
     * only add elements for even index and keep the same for odd index
     * pSumO[i]=pSumO[i-1] + 0 when i is even
     * pSumO[i] = pSumE[i-1] + arr[i] when i is odd
     * @param arr
     * @return
     */
    public static int[] oddIndexPrefixSum(ArrayList<Integer> arr) {
        int[] pSum = new int[arr.size()];
        pSum[0] = 0;
        for (int i = 1; i < arr.size(); ++i) {
            if (i % 2 == 0) {
                pSum[i] = pSum[i-1];
            } else {
                pSum[i] = pSum[i-1] + arr.get(i);
            }

        }
        return pSum;
    }


}
