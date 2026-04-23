package com.anshumanbiswal.introToProgramming.pattern;

import java.util.ArrayList;
import java.util.List;

/*
Print the Right Triangle Alphabet Pattern for the given value of N.





Input 1:
N = 4
Output 1:

a
ab
abc
abcd


Input 2:
N = 2
Output 2:

a
ab
Constraints:
1 <= N <= 10
 */
public class Pattern3 {
    static List<String> solve(int n){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j <= i ; ++j) {
                char ch = (char)(j+97);
                s = s.concat(""+ch);
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
