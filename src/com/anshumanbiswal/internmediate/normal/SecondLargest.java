package com.anshumanbiswal.internmediate.normal;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description

You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.


Problem Constraints

1 <= |A| <= 105


0 <= A[i] <= 109





Input Format

The first argument is an integer array A.





Output Format

Return the second largest element. If no such element exist then return -1.



Example Input

Input 1:

 A = [2, 1, 2]
Input 2:

 A = [2]


Example Output

Output 1:

 1
Output 2:

 -1
 */
public class SecondLargest {

    static int solve(ArrayList<Integer> A) {
        int max = A.get(0);
        for (int i = 1; i < A.size(); ++i) {
            if (A.get(i) > max) {
                max = A.get(i);
            }
        }
        int secondMax = -1;
        for (int j = 0; j < A.size(); ++j) {
            if (A.get(j) > secondMax && A.get(j) != max) {
                secondMax = A.get(j);
            }
        }
        return secondMax;
    }

    static void main() {
        int[] A = {2, 1,2};
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.stream(A).boxed().toList());
        System.out.println(solve(list1));
    }
}
