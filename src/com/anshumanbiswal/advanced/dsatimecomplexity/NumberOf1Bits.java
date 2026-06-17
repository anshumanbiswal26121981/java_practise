package com.anshumanbiswal.advanced.dsatimecomplexity;

/**
 * Q1. Number of 1 Bits
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Write a function that takes an integer and returns the number of 1 bits present in its binary representation.
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 109
 *
 *
 * Input Format
 *
 * First and only argument contains integer A
 *
 *
 * Output Format
 *
 * Return an integer
 *
 *
 * Example Input
 *
 * Input 1:
 * 11
 * Input 2:
 * 6
 *
 *
 * Example Output
 *
 * Output 1:
 * 3
 * Output 2:
 * 2
 *
 *
 * Example Explanation
 *
 * Explaination 1:
 * 11 is represented as 1011 in binary.
 * Explaination 2:
 * 6 is represented as 110 in binary.
 */
public class NumberOf1Bits {
    public static int numSetBits(int A) {
        int countOf1 = 0;
        while (A != 0) {
            countOf1 += ( A&1);  // n & 1 extract least significant bit.
            // If the last bit is 1, n & 1 returns 1
            // If the last bit is 0, n & 1 returns 0
            // sp the whole line increments count only when the current last bit is 1.
            A >>>= 1; //This shifts all bits of n one position to the right.

            //so 11101 >>> 1 = 1110
            //1110  >>> 1 = 111
            //111   >>> 1 = 11
            //11    >>> 1 = 1
            //1     >>> 1 = 0
        }
        return countOf1;
    }

    static void main() {
        System.out.println(numSetBits(11));
        System.out.println(numSetBits(6));
    }
}
