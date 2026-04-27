package com.anshumanbiswal.internmediate.bruteforce;

/*
Given a String S . Return the count of pairs

 */
public class StringPairsAG {
    /**
     * whenever you find an a we run a loop to find the number of g to its right
     * @param s
     * @return
     */
    static int solve(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'a'){
                for (int j = i+1; j < s.length(); ++j) {
                    if (s.charAt(j) == 'g') {
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    static void main() {
        String s  = "abegag";
        System.out.println(solve(s));
    }
}
