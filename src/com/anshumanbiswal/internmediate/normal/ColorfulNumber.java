package com.anshumanbiswal.internmediate.normal;

import java.util.HashSet;

/**
 * Problem Description
 *
 * Given a number A, find if it is COLORFUL number or not.
 *
 * If number A is a COLORFUL number return 1 else, return 0.
 *
 * What is a COLORFUL Number:
 *
 * A number can be broken into different consecutive sequence of digits.
 * The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
 * This number is a COLORFUL number, since the product of every consecutive sequence of digits is different
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 2 * 109
 *
 *
 *
 * Input Format
 *
 * The first and only argument is an integer A.
 *
 *
 *
 * Output Format
 *
 * Return 1 if integer A is COLORFUL else return 0.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 23
 * Input 2:
 *
 *  A = 236
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Possible Sub-sequences: [2, 3, 23] where
 *  2 -> 2
 *  3 -> 3
 *  23 -> 6  (product of digits)
 *  This number is a COLORFUL number since product of every digit of a sub-sequence are different.
 * Explanation 2:
 *
 *  Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
 *  2 -> 2
 *  3 -> 3
 *  6 -> 6
 *  23 -> 6  (product of digits)
 *  36 -> 18  (product of digits)
 *  236 -> 36  (product of digits)
 *  This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
 */
public class ColorfulNumber {
    public static int colorful(int A) {
        String str = String.valueOf(A);

        HashSet<Integer> set = new HashSet<>();

        int n = str.length();

        // Generate all consecutive subsequences
        for (int i = 0; i < n; i++) {

            int product = 1;

            for (int j = i; j < n; j++) {

                int digit = str.charAt(j) - '0';

                product *= digit;

                // Product already exists
                if (set.contains(product)) {
                    return 0;
                }

                set.add(product);
            }
        }

        return 1;
    }

    static void main() {
        System.out.println(colorful(3245));
        System.out.println(colorful(23));
        System.out.println(colorful(236));
    }
}
