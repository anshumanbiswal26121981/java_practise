package com.anshumanbiswal.advanced.dsatimecomplexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Problem Description
 *
 * You are given a collection of intervals A in a 2-D array format, where each interval is represented by a pair of integers `[start, end]`. The intervals are sorted based on their start values.
 *
 * Your task is to merge all overlapping intervals and return the resulting set of non-overlapping intervals.
 *
 *
 * Problem Constraints
 *
 * 1 <= len(A) <= 100000.
 * 1 <= A[i][0] <= A[i][1] <= 100000
 *
 * A is sorted based on the start value (A[i][0])
 *
 *
 *
 * Input Format
 *
 * First argument is a list of intervals in 2-Dimentional Array.
 *
 *
 *
 * Output Format
 *
 * Return the sorted list of intervals after merging all the overlapping intervals.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * [ [1, 3], [2, 6], [8, 10], [15, 18] ]
 * Input 2:
 *
 * [ [2, 10], [4, 9], [6, 7] ]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [ [1, 6], [8, 10], [15, 18] ]
 * Output 2:
 *
 * [ [2, 10] ]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Merge intervals [1,3] and [2,6] -> [1,6].
 * so, the required answer after merging is [1,6],[8,10],[15,18].
 * No more overlapping intervals present.
 * Explanation 2:
 *
 * Merge intervals [2, 10], [4, 9], [6, 7] as [2,10].
 * Since [4, 9] and [6, 7] is overlapping inside the interval [2, 10].
 *
 * so, the required answer after merging is [2, 10].
 */
public class MergeSortOverlappingIntervals {
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int start = A.get(0).get(0);
        int end = A.get(0).get(1);

        for (int i = 1; i < A.size(); i++) {

            int currentStart = A.get(i).get(0);
            int currentEnd = A.get(i).get(1);

            // Overlapping interval
            if (currentStart <= end) {
                end = Math.max(end, currentEnd);
            } else {
                // No overlap, store previous merged interval
                ArrayList<Integer> interval = new ArrayList<>();
                interval.add(start);
                interval.add(end);
                result.add(interval);

                // Start a new interval
                start = currentStart;
                end = currentEnd;
            }
        }

        // Add the last interval
        ArrayList<Integer> interval = new ArrayList<>();
        interval.add(start);
        interval.add(end);
        result.add(interval);

        return result;

    }

    public static int[][] solveIntArray (int[][] A) {

       int[][] ans = new int[A.length][2];
       int currS = A[0][0];
       int currE = A[0][1];
       int ptr = 0;
        for (int i = 1; i < A.length; i++) {

            int nextS = A[i][0];
            int nextE = A[i][1];

            // Overlapping interval
            if (currE >= nextS) {
                currS = Math.min(currS, nextS);//redundant lines as the arrays elements are sorted
                currE = Math.max(currE, nextE);
            } else {
                // No overlap, store previous merged interval
                ans[ptr][0] = currS;
                ans[ptr][1] = currE;
                ptr++;

                //update current
                currS = nextS;
                currE = nextE;
            }
        }

        //you will be left with 1 interval in current
        ans[ptr][0] = currS;
        ans[ptr][1] = currE;
        return Arrays.copyOf(ans,ptr+1);

    }


    static void main() {

        int[][] a = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        ArrayList<ArrayList<Integer>> A =
                Arrays.stream(a)
                        .map(row -> Arrays.stream(row)
                                .boxed()
                                .collect(Collectors.toCollection(ArrayList::new)))
                        .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(solve(A));

        int[][] ans = solveIntArray(a);
        System.out.println(Arrays.deepToString(ans));

    }
}
