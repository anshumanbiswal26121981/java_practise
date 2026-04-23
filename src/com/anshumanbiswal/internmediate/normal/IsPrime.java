package com.anshumanbiswal.internmediate.normal;

import com.anshumanbiswal.internmediate.optimized.CountOfFactors;

public class IsPrime {

    /*
     A number is prime if it has exactly two factors. 1 and the number itself
     */
    static boolean isPrime(int N) {
        if (CountOfFactors.count(N) == 2) {
            return true;
        } else {
            return false;
        }
    }

    static void main() {
        System.out.println(isPrime(31));
        System.out.println(isPrime(25));

    }
}
