package com.anshumanbiswal.introToProgramming.pattern;

import java.util.ArrayList;
import java.util.List;

/*
Print the Square Star Pattern for the given value of N.

Input 1: N = 4
Output 1:
****
****
****
****

Explanation 1: Square of 4*4 will be formed.

Input 2: N = 2
Output 2:
**
**
Constraints:
1 <= N <= 10
 */
public class Pattern1 {
    static List<String> solve(int n){
        List<String> list=new ArrayList<String>();

        for (int r = 0; r < n; ++r) {
            String s="";
            for (int c = 0; c < n; ++c) {
                s=s.concat("*");
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
