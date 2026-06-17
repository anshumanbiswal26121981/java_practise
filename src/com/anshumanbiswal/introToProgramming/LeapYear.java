package com.anshumanbiswal.introToProgramming;

/**
 * You are given a number that represents the year, your task is to return true if the given year is a Leap Year or else false.
 *
 * Input 1: year = 2000
 * Output 1: true
 * Explanation 1: 2000 is a leap year.
 *
 * Input 2: year = 2017
 * Output 2: false
 * Constraints:
 * 1700<=year<=9000
 */
public class LeapYear {
    /**
     * Rule:
     *
     * Divisible by 400 → leap year
     *
     * Divisible by 4 and not Divisible by 100 → leap year
     * Divisible by 4 and  Divisible by 100 → not leap year
     * @param year
     * @return
     */
    static boolean check(int year){
        if (year % 400 == 0 ) {
            return true;
        } else {
            if (year % 4 == 0) {
                if (year % 100 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    static void main() {
        System.out.println(check(2000));
        System.out.println(check(2017));
    }
}
