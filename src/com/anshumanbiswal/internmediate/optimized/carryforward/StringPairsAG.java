package com.anshumanbiswal.internmediate.optimized.carryforward;

/*
Given a String S . Return the count of pairs

 */
public class StringPairsAG {
    /**
     * S = bcaggaag
     * you know that for every g you find, it will form
     * a pair with every a that lies to its left side.
     * So in this whenever you iterate the String.
     * Increase the count of a whenever you find a and when you find the g. That is your answer.
     * i.e maintain a running count (carryforward) of a's.
     * when found a 'g', add that count to the answer
     * @param s
     * @return
     */
    static int solve(String s) {
        int answer = 0;
        int countA = 0; // carryforward count
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'a') {
                ++countA;
            }
            if (s.charAt(i) == 'g') {
                answer += countA;
            }
        }
        return answer;
    }

    static void main() {
        String s  = "abegag";
        System.out.println(solve(s));
    }
}
