package com.anshumanbiswal.introToProgramming;

/**
 * Return the count of all positive numbers present in the given list of integers.
 *
 * Input 1: list = [-2, 5, 7, -1, 3]
 * Output 1: 3
 * Explanation 1: 3, 5, and 7 are positive numbers.
 *
 * Input 2: list = [-2, -10]
 * Output 2: 0
 * Constraints:
 * 1<=list.length<=10000
 * -10000<=list[i]<=10000
 */
public class CountPositive {
    static int count(int[]  input){
        int count = 0;
        for (int i = 0; i < input.length; ++i) {
            if ( input[i] > 0) {
                ++ count;
            }
        }
        return count;
    }

    static void main() {
        int[] list = {-2, 5, 7, -1, 3};
        System.out.println(count(list));

        int[] list1 = {-2, -10};
        System.out.println(count(list1));
    }
}
