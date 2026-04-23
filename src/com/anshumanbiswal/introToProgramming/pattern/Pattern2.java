package com.anshumanbiswal.introToProgramming.pattern;

import java.util.ArrayList;
import java.util.List;

/*
Print the Right Triangle Star Pattern for the given value of N.

Input 1: N = 4
Output 1:
*
**
***
****

Explanation 1: Square of 4*4 will be formed with 1 star in first row, two star in second row and so on.

Input 2: N = 2
Output 2:
*
**
Constraints:
1 <= N <= 10
 */
public class Pattern2 {
    static List<String> solve(int n){
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String s = "";
            for (int j = 1; j <= i ; ++j) {
                s = s.concat("*");
            }
            list.add(s);
        }
        return list;

    }

    static void main() {
        System.out.println(solve(4));
        System.out.println(solve(2));
    }
}
