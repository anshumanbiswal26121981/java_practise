package com.anshumanbiswal.internmediate.normal;

import java.util.Arrays;

/**
 * Given an array elements calculate the number of noble integers.
 * An element in an array is said to be noble if count of smaller elements = element itself.
 *
 * ex: {1,-5,3,5,-10,4}
 * 3 is noble integer because elements lesser than 3 are 1, -5, -10 (3 elements)
 * 5 is noble integer because elements lesser than 5 are 1, -5,3,-10,4 (5 elements)
 * 4 is noble integer because elements lesser than 4 are 1,-5,3,-10 (4 elements)
 *
 * arr = {-3,0,2,2,5,5,5,5,8,8,10,10,10,14}
 * ans: 7 (elements are 2,2,8,8,10,10,10)
 *
 * Observation:
 * 1. If any one of the duplicate elements is noble other elements will be noble
 * 2.  the first element in the duplicates is noble then all duplicates will be noble
 * if(a[i] == i) then all the duplicates will be noble
 *
 * idea:
 * Sort the array in ascending order
 * Iterate the array
 *  a. a[i] == a[i-1] (repeated occurence of some duplicate elements)
 *  b. if a[i] != a[i-1] (this is first occurrence of any duplicate sequence)
 *
 *  Sort the array
 * Iterate:
 * If current is same as previous → use previous smaller count
 * Else → smaller count = current index i
 * If smallerCount == A[i] → it's noble
 *
 *
 */
public class NobleIntegersAsPerAnyElementSmaller {

    public static int countNobleInteger(int[] A) {
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int count = 0;
        int smallerCount = 0; // number of elements strictly smaller

        for (int i = 0; i < A.length; i++) {

            // If it's the first occurrence of this number
            if (i == 0 || A[i] != A[i - 1]) {
                smallerCount = i;
            }

            if (A[i] == smallerCount) {
                count++;
            }
        }

        return count;
    }

    static void main() {
        int[] arr = {1,-5,3,5,-10,4};
        System.out.println(countNobleInteger(arr));

        int[] A = {-3,0,2,2,5,5,5,5,8,8,10,10,10,14};
        System.out.println(countNobleInteger(A));
    }
}
