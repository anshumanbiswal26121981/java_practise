package com.anshumanbiswal.internmediate.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Noble Integer
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 2*105
 * -108 <= A[i] <= 108
 *
 *
 * Input Format
 *
 * First and only argument is an integer array A.
 *
 *
 *
 * Output Format
 *
 * Return 1 if any such integer p is present else, return -1.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [3, 2, 1, 3]
 * Input 2:
 *
 *  A = [1, 1, 3, 3]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  For integer 2, there are 2 greater elements in the array..
 * Explanation 2:
 *
 *  There exist no integer satisfying the required conditions.
 */
public class NobleIntegersAsPerElementsGreater {
    public static int countNobleInteger(ArrayList<Integer> A) {
        Collections.sort(A, Collections.reverseOrder());
        int count = 0;
        int smallerCount = 0; // number of elements strictly smaller

        for (int i = 0; i < A.size(); i++) {

            // If it's the first occurrence of this number
            if (i == 0 || A.get(i) != A.get(i-1)) {
                smallerCount = i;
            }

            if (A.get(i) == smallerCount) {
                count++;
            }
        }

        return count;
    }

    public static int solve(ArrayList<Integer> A) {
        if (countNobleInteger(A) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    static void main() {
        int[] a = {3, 2, 1, 3};
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.stream(a).boxed().toList());
        System.out.println(solve(list1));
    }

}
