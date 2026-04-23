package com.anshumanbiswal.internmediate.normal;

import java.util.ArrayList;
import java.util.Arrays;

/*
Time to equality
Solved
feature icon
Using hints except Complete Solution is Penalty free now
Use Hint
Problem Description

Given an integer array A of size N. In one second, you can increase the value of one element by 1.

Find the minimum time in seconds to make all elements of the array equal.


Problem Constraints

1 <= N <= 1000000
1 <= A[i] <= 1000


Input Format

First argument is an integer array A.


Output Format

Return an integer denoting the minimum time to make all elements equal.


Example Input

A = [2, 4, 1, 3, 2]


Example Output

8
 */
public class TimeToEquality {
    static int solve(ArrayList<Integer> A) {
        int max = A.get(0);
        for (int i = 1; i < A.size(); ++i) {
            if (A.get(i) > max) {
                max = A.get(i);
            }
        }
        int minTime = 0;
        for (int j = 0; j < A.size(); ++j) {
            minTime = minTime + (max - A.get(j));
        }

        return minTime;
    }

    static void main() {
        int[] A = {2, 4, 1, 3, 2};
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.stream(A).boxed().toList());
        System.out.println(solve(list1));
    }
}
