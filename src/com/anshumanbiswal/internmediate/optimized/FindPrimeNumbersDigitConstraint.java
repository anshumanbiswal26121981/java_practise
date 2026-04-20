package com.anshumanbiswal.internmediate.optimized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Find Prime Numbers in a Range with Digit Constraints
Write a program that finds all prime numbers between two given integers L and R (inclusive). However, only include those primes that do not contain the digit '3' in their decimal representation.
Input: L = 10, R = 30
Output: 11 17 19 29
(Note: 13 and 23 are prime but contain the digit '3', so they are excluded.)
Input: L = 30, R = 35
Output: No valid primes found.
Constraints:
1 ≤ L ≤ R ≤ 10,000
 */
public class FindPrimeNumbersDigitConstraint {
    static String[] check(int n, int m){
        int len = (m-n)+1;
        List<String> result = new ArrayList<>();
        int arrPos = 0;
        for (int i = n ; i <= m ; ++i) {
            if (!hasThree(i)) {
                if (countFactors(i) == 2) {
                    result.add("" + i);
                }
            }
        }
        if (result.isEmpty()) {
            return new String[]{"No valid primes found."};
        }
        return result.toArray(new String[0]);

    }

    static int countFactors (int n) {
        int count = 0;
        for (int i = 1; i*i <= n ; ++i) {
            if (n % i == 0)  {
                if (n/i == i) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    static boolean hasThree(int n) {
        boolean hasThree = false;
        while (n > 0) {
            int digit = n % 10;  // get last digit
            if (digit == 3) {
                hasThree = true;
                break;
            }
            n = n / 10;
        }
        return hasThree;
    }

    static void main() {
        System.out.println(Arrays.toString(check(10, 30)));
        System.out.println(Arrays.toString(check(30, 35)));
    }
}
