package com.anshumanbiswal.internmediate.bruteforce;

import java.util.Arrays;

public class RotateArray {

    static int[] rotateArray(int k , int[] arr) {
        int len = arr.length;

        for(int rotate = 1; rotate <= k; rotate++) {
            int temp =  arr[len - 1];
            for (int i = len - 1; i > 0; --i) {
                arr[i] = arr[i-1];
            }
            arr[0] = temp;
        }
        return arr;

    }

    static void main() {
        int[] arr = {4, 3, 6, 2, 1};
        int[] arr2 = rotateArray(1,arr);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = rotateArray(2,arr);
        System.out.println(Arrays.toString(arr3));
    }
}
