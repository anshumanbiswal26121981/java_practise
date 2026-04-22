package com.anshumanbiswal.internmediate.optimized;

import java.util.ArrayList;

public class RotateArray {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        B = B % n;
        if (B < 0) { // if k is negative add arr.length i.e n to k
            B = B + n;
        }
        reversePartArray(A, 0, n-1);
        reversePartArray(A, 0, B-1);
        reversePartArray(A, B, n-1);
        return A;
    }

    public static void reversePartArray(ArrayList<Integer> A, int left, int right) {
        while (left < right) {
            swap(A, left, right);
            left++;
            right--;
        }
    }

    public static void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    static void main() {

    }
}
