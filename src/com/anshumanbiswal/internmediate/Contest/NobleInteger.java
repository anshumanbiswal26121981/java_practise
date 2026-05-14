package com.anshumanbiswal.internmediate.Contest;

import java.util.*;

/**
 * A Noble Integer is an integer p in an array such that the number of integers greater than p is exactly equal to p
 *
 * Input:
 *
 * [3, 2, 1, 3]
 *
 * Sorted:
 *
 * [1, 2, 3, 3]
 * For 2 → numbers greater than 2 = 2 (3,3)
 * So 2 is a Noble Integer.
 *
 * Output:
 *
 * 1
 *
 * (Return 1 if noble integer exists, otherwise -1)
 */
public class NobleInteger {
    /**
     * Input:
     *
     * [1, 2, 7, 0, 9, 3, 6, 0, 6]
     *
     * After sorting:
     *
     * [0, 0, 1, 2, 3, 6, 6, 7, 9]
     *
     * Now check each element:
     *
     * Index	Value	Greater Elements
     * 0	0	8
     * 1	0	7
     * 2	1	6
     * 3	2	5
     * 4	3	4
     * 5	6	3
     * 6	6	2
     * 7	7	1
     * 8	9	0
     *
     * No element satisfies:
     *
     * value == greater elements
     *
     * So output is:
     *
     * -1
     * @param A
     * @return
     */
    public static int solve(ArrayList<Integer> A) {

        Collections.sort(A);

        int n = A.size();

        for (int i = 0; i < n - 1; i++) {

            // skip duplicates
            if (A.get(i).equals(A.get(i + 1))) {
                continue;
            }

            int greaterElements = n - i - 1;

            if (A.get(i) == greaterElements) {
                return 1;
            }
        }

        // check last element
        if (A.get(n - 1) == 0) {
            return 1;
        }

        return -1;
    }

    /**
     * Example
     *
     * Input:
     *
     * [3,2,1,3]
     *
     * Frequency map:
     *
     * 1 -> 1
     * 2 -> 1
     * 3 -> 2
     *
     * For value 2:
     *
     * prefix count = 2 (1,2)
     * greater elements = 4 - 2 = 2
     *
     * So 2 is a Noble Integer.
     *
     * Output:
     *
     * 1
     * @param A
     * @return
     */
    public static int solveWithoutSorting(int[] A) {

        int n = A.length;

        // Frequency map
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int prefix = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int value = entry.getKey();
            int freq = entry.getValue();

            prefix += freq;

            int greaterElements = n - prefix;

            if (greaterElements == value) {
                return 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        ArrayList<Integer> A =
                new ArrayList<>(Arrays.asList(3, 2, 1, 3));

        System.out.println(solve(A));
    }
}
