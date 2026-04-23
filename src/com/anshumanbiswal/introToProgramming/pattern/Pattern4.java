package com.anshumanbiswal.introToProgramming.pattern;

import java.util.ArrayList;
import java.util.List;

/*
Print the Number Series Pattern for the given value of N.

Input 1: N = 4
Output 1:
1
12
123
1234
Explanation 1: Square of 4*4 will be formed with series up to 1 from the beginning, series up to 2 from the beginning in the second row from the beginning and so on.

Input 2: N = 3
Output 2:
1
12
123

Constraints:
1 <= N <= 50

 */
public class Pattern4 {
    static List<String> solve(int n){
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String s = "";
            for (int j = 1; j <= i ; ++j) {
                s = s.concat(""+j);
            }
            list.add(s);
        }
        return list;
    }

    static void main() {
        System.out.println(solve(4));
        System.out.println(solve(3));
    }
}
