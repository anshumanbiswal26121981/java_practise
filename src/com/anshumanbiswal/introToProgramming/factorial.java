package com.anshumanbiswal.introToProgramming;

public class factorial {

    static int solve(int n){

        int result = 1;
        while (n >= 1) {
            result *= n;
            --n;
        }
        return result;

    }

    static void main() {
        System.out.println(solve(5));
    }
}
