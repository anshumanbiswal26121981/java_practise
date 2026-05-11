package com.anshumanbiswal.introToProgramming.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Conditional Multiplication Table Printer
 * Maths
 * Multiplication Table
 *
 *
 * 0
 * Write a program that prints a conditional multiplication table for a given number.
 * You are given two integers:
 * n — the base number for the multiplication table
 * m — the range limit (inclusive) up to which the table should be printed
 * Your task is to print only those results from the multiplication table of n (from 1 to m) that satisfy both of the following conditions:
 * The product n * i is an even number
 * The product n * i is divisible by 4
 * Each qualifying line should be printed in the following format: n x i = result
 * If no such result exists within the range, print: No qualifying multiples found.
 * Input: n = 3, m = 10
 * Output: 3 x 4 = 12
 *              3 x 8 = 24
 * Input: n = 5, m = 3
 * Output: No qualifying multiples found.
 * Constraints:
 * 1 ≤ n ≤ 100
 * 1 ≤ m ≤ 100
 */
public class ConditionalMultiplicationTable {
    static String[] solve(int n, int m) {

        List<String> results = new ArrayList<>();

        for (int i = 1; i <= m; ++i) {
            int num = n * i;
            if (num % 2 == 0 && num % 4 == 0) {
                String s = n + " x " + i + " = " + num;
                results.add(s);
            }
        }
        if (results.isEmpty()) {
            results.add("No qualifying multiples found.");
        }

        return results.toArray(new String[0]);
    }

    static void main() {
        System.out.println(Arrays.toString(solve(3, 10)));
    }

    }
