package com.anshumanbiswal.internmediate.bruteforce;

public class CountOfFactors {

    static int count(int N) {
        int count = 0;
        for (int i = 1; i <= N; ++i) {
            if (N % i == 0) {
                ++count;
            }
        }
        return count;
    }

    static void main() {
        System.out.println(count(10));
        System.out.println(count(24));
    }
}
