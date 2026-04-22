package com.anshumanbiswal.internmediate.optimized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Problem Description

Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.



Problem Constraints

1 <= A.size() <= 104

1 <= A[i] <= 109

1 <= B <= 109



Input Format

First argument is an integer array A.

Second argument is an integer B.



Output Format

Return 1 if good pair exist otherwise return 0.



Example Input

Input 1:

A = [1,2,3,4]
B = 7
Input 2:

A = [1,2,4]
B = 4
Input 3:

A = [1,2,2]
B = 4


Example Output

Output 1:

1
Output 2:

0
Output 3:

1


Example Explanation

Explanation 1:

 (i,j) = (3,4)
Explanation 2:

No pair has sum equal to 4.
Explanation 3:

 (i,j) = (2,3)

 */
public class GoodPair {

    public static int solve(ArrayList<Integer> A, int B) {

        for (int i = 0; i < A.size(); i++) {
            int numI = A.get(i);
            for (int j = i+1; j < A.size(); j++) {
                int numJ = A.get(j);
                if (numI + numJ == B) {
                    return 1;
                }

            }
        }
        return 0;

    }

    static void main() {
        int[] A = {1,2,3,4};
        int B = 7;
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.stream(A).boxed().toList());

        System.out.println(solve(list1, B));

        int[] A1 = {1,2,4};
        B = 4;
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.stream(A1).boxed().toList());

        System.out.println(solve(list2, B));

        int[] A2 = {1,2,2};
        B = 4;
        ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.stream(A2).boxed().toList());

        System.out.println(solve(list3, B));
    }
}
