package com.anshumanbiswal.introToProgramming;

public class EvenOddNumber {

    static String check(int n){

        if (n % 2 == 0)
            return "Even";
        else
            return "Odd";

    }

    static void main() {
        System.out.println(check(19));
    }
}
