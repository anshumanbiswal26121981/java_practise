package com.anshumanbiswal.internmediate.bruteforce;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseArrayWithoutExtraArray {
    static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]  = temp;
            ++start;
            --end;
        }
    }

    static void reverseArray2(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        for (int i = start, j = end; i <= j; ++i, --j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j]  = temp;
        }
    }

    static void main() {
        int[] arr = {4,3,6,2,1};
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));

        reverseArray2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
