package com.anshumanbiswal.internmediate.normal;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description

Given an array A of N integers.
Count the number of elements that have at least 1 elements greater than itself.


Problem Constraints

1 <= N <= 103
1 <= A[i] <= 109


Input Format

First and only argument is an array of integers A.


Output Format

Return the count of elements.


Example Input

Input 1:
A = [3, 1, 2]
Input 2:
A = [5, 5, 3]


Example Output

Output 1:
2
Output 2:
1


Example Explanation

Explanation 1:
The elements that have at least 1 element greater than itself are 1 and 2
Explanation 2:
The elements that have at least 1 element greater than itself is 3

 */
public class CountOfElements {
    static int solve(ArrayList<Integer> A) {
        int max = A.get(0);
        for (int i = 1; i < A.size(); ++i) {
            if (A.get(i) > max) {
                max = A.get(i);
            }
        }
        int count = 0;
        for (int j = 0; j < A.size(); ++j) {
            if(A.get(j) < max) {
                ++count;
            }
        }

        return count;
    }

    static void main() {
        int[] A = {3,1,2};
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.stream(A).boxed().toList());
        System.out.println(solve(list1));
    }
}
