package com.anshumanbiswal.advanced.dsatimecomplexity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 *
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
 *
 *
 *
 * If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.
 *
 * NOTE:
 *
 *
 *
 * The replacement must be in-place, do not allocate extra memory.
 * DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 5 * 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * The first and the only argument of input has an array of integers, A.
 *
 *
 *
 * Output Format
 *
 * Return an array of integers, representing the next permutation of the given array.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3]
 * Input 2:
 *
 *  A = [3, 2, 1]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [1, 3, 2]
 * Output 2:
 *
 *  [1, 2, 3]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Next permutaion of [1, 2, 3] will be [1, 3, 2].
 * Explanation 2:
 *
 *  No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
 *  So will rearranges it in the lowest possible order.
 *
 *  Approach:
 *
 *  Consider:
 *
 * A = [1, 3, 5, 4, 2]
 * Step 1: Find the pivot
 *
 * Scan from right until:
 *
 * A[i] < A[i + 1]
 *
 * Here:
 *
 * [1, 3, 5, 4, 2]
 *     ↑
 *   pivot = 3
 *
 * Because:
 *
 * 3 < 5
 *
 * The suffix:
 *
 * [5, 4, 2]
 *
 * is already in descending order, meaning it represents the largest possible arrangement for that prefix.
 *
 * Step 2: Find the rightmost element greater than the pivot
 *
 * Pivot value:
 *
 * 3
 *
 * From the right:
 *
 * 2 <= 3    skip
 * 4 > 3     found
 *
 * Swap 3 and 4:
 *
 * [1, 4, 5, 3, 2]
 * Step 3: Reverse everything after the pivot
 *
 * Reverse:
 *
 * [5, 3, 2]
 *
 * to:
 *
 * [2, 3, 5]
 *
 * Result:
 *
 * [1, 4, 2, 3, 5]
 *
 * That is the immediate next permutation.
 *
 * Why reverse instead of sorting?
 *
 * The suffix before the swap is already in descending order. After choosing the correct element to swap with the pivot, reversing the suffix gives the smallest possible arrangement.
 *
 * So we avoid sorting and maintain:
 *
 * Time: O(N)
 * Extra space: O(1)
 * In-place: Yes
 *
 * For example:
 *
 * [3, 2, 1]
 *
 * There is no pivot because the entire array is descending. Therefore:
 *
 * pivot = -1
 *
 * Reverse the whole array:
 *
 * [1, 2, 3]
 * The three steps to remember
 * 1. Find pivot:       A[i] < A[i + 1]
 * 2. Swap pivot with:  rightmost A[j] > A[i]
 * 3. Reverse suffix:   i + 1 to n - 1
 *
 * This is one of those algorithms where understanding why the suffix is descending is more important than memorizing the code.
 */
public class NextPermutation {
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int n = A.size();

        if (n <= 1) {
            return A;
        }

        // Step 1: Find pivot from right
        int pivot = n - 2;

        while (pivot >= 0 && A.get(pivot) >= A.get(pivot + 1)) {
            pivot--;
        }

        // Step 2: Find rightmost element greater than pivot and swap
        if (pivot >= 0) {

            int j = n - 1;

            while (A.get(j) <= A.get(pivot)) {
                j--;
            }

            swap(A, pivot, j);
        }

        // Step 3: Reverse suffix
        reverse(A, pivot + 1, n - 1);

        return A;
    }

    private static void swap(ArrayList<Integer> A, int i, int j) {

        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    private static void reverse(ArrayList<Integer> A, int left, int right) {

        while (left < right) {

            swap(A, left, right);

            left++;
            right--;
        }
    }

    public static int[] nextPermutation(int[] A) {

        int n = A.length;

        if (n <= 1) {
            return A;
        }

        // Step 1: Find the first decreasing element from the right.
        int pivot = n - 2;

        while (pivot >= 0 && A[pivot] >= A[pivot + 1]) {
            pivot--;
        }

        // Step 2: If pivot exists, find the smallest greater
        // element on the right side and swap.
        if (pivot >= 0) {

            int j = n - 1;

            while (A[j] <= A[pivot]) {
                j--;
            }

            swap(A, pivot, j);
        }

        // Step 3: Reverse the suffix.
        reverse(A, pivot + 1, n - 1);

        return A;
    }

    private static void reverse(int[] A, int left, int right) {

        while (left < right) {
            swap(A, left, right);
            left++;
            right--;
        }
    }

    private static void reverse2(int[] A, int left, int right) {

        int i = left, j = right;
        while (i <= j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int[] nextPermutation2(int[] A) {

        int N = A.length;
        if (N <= 1) {
            return A;
        }
        int dip = -1;



        for(int i = N-1; i>0; i--) {
            if (A[i-1] < A[i]) {
                dip = i-1;
                break;
            }
        }

        //dip = -1 and array is in descending order then reverse the entire array
        if (dip == -1) {
            reverse2(A, 0 , N-1);
            return A;
        }
        //find largest element than A[dip]
        for (int i = N-1; i > dip; i--) {
            if (A[i] > A[dip]) {
                int temp = A[i];
                A[i] = A[dip];
                A[dip] = temp;
                break;
            }
        }

        // reverese the array from dip + 1 till N-1
        reverse2(A, dip+1, N-1);
        return A;
    }

    static void main() {
        int [] a = {1, 3, 5, 4, 2};
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.stream(a).boxed().toList());
        System.out.println(Arrays.toString(nextPermutation(a)));
        System.out.println(nextPermutation(A));
        System.out.println(Arrays.toString(nextPermutation2(a)));
    }
}
