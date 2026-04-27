package com.anshumanbiswal.internmediate.optimized.prefixsum;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Even numbers in a range
Unsolved
feature icon
Using hints except Complete Solution is Penalty free now
Use Hint
Problem Description

You are given an array A of length N and Q queries given by the 2D array B of size Q×2.

Each query consists of two integers B[i][0] and B[i][1].

For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].



Problem Constraints

1 <= N <= 105
1 <= Q <= 105
1 <= A[i] <= 109
0 <= B[i][0] <= B[i][1] < N


Input Format

First argument A is an array of integers.
Second argument B is a 2D array of integers.


Output Format

Return an array of integers.


Example Input

Input 1:
A = [1, 2, 3, 4, 5]
B = [   [0, 2]
        [2, 4]
        [1, 4]   ]
Input 2:
A = [2, 1, 8, 3, 9, 6]
B = [   [0, 3]
        [3, 5]
        [1, 3]
        [2, 4]   ]


Example Output

Output 1:
[1, 1, 2]
Output 2:
[2, 1, 1, 1]


Example Explanation

For Input 1:
The subarray for the first query is [1, 2, 3] (index 0 to 2) which contains 1 even number.
The subarray for the second query is [3, 4, 5] (index 2 to 4) which contains 1 even number.
The subarray for the third query is [2, 3, 4, 5] (index 1 to 4) which contains 2 even numbers.
For Input 2:
The subarray for the first query is [2, 1, 8, 3] (index 0 to 3) which contains 2 even numbers.
The subarray for the second query is [3, 9, 6] (index 3 to 5) which contains 1 even number.
The subarray for the third query is [1, 8, 3] (index 1 to 3) which contains 1 even number.
The subarray for the fourth query is [8, 3, 9] (index 2 to 4) which contains 1 even number.
 */
public class EvenNumbersInRange {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int[] pCount = prefixCountEven(A);
        int count;
        int s,e;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            s = B.get(i).get(0);
            e =  B.get(i).get(1);
            if (s == 0) {
                count = pCount[e];
            } else {
                count = pCount[e] - pCount[s-1];
            }

            list.add(count);
        }
        return list;
    }

    /**
     * prefixCountEven[0] = 1 if arr[i] %2 == 0 else 0
     * prefixCountEven = prefixCountEven[i-1] + 1 if arr[i] %2 == 0
     * else
     * prefixCountEven = prefixCountEven[i-1]
     * @param A
     * @return
     */
    public static int[] prefixCountEven(ArrayList<Integer> A) {
        int[] pCount = new int[A.size()];
        pCount[0] = A.get(0) % 2 == 0 ? 1 : 0;
        for (int i = 1; i < A.size(); ++i) {
            if (A.get(i) % 2 == 0) {
                pCount[i] = pCount[i-1] + 1;
            } else {
                pCount[i] = pCount[i-1];
            }
        }
        return pCount;
    }

    static void main() {
        int[] a = {2, 1, 8, 3, 9, 6};
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.stream(a).boxed().toList());
        int[][] b = {{0, 3}, {3, 5}, {1,3}, {2,4}};

        ArrayList<ArrayList<Integer>> B =
                Arrays.stream(b)
                        .map(row -> Arrays.stream(row)
                                .boxed()
                                .collect(java.util.stream.Collectors.toCollection(ArrayList::new)))
                        .collect(java.util.stream.Collectors.toCollection(ArrayList::new));

        System.out.println(solve(A,B));
    }
}
