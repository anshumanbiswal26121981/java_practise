package com.anshumanbiswal.introToProgramming.Strings;

/**
 * Reverse Words In String
 * Microsoft
 *
 * Question
 * Submission
 * Solution
 * Given a string, the task is to reverse the order of the words in the given string.
 *
 * Input 1: s = “bosscoder quiz practice code”
 * Output 1: “code practice quiz bosscoder”
 * Explanation 1: The last word comes first, the second last comes second first and so on.
 *
 * Input 2: s = “i love programming very much”
 * Output 2: “much very programming love i”
 * Constraints:
 * 1 <= s.length <= 105
 */
public class ReverseWords {
    static String solve(String s){
        String[] s1 = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length-1; i >= 0; --i) {
            sb.append(s1[i]);
            if( i > 0) {
                sb.append(" ");
            }

        }
        return sb.toString().trim();
    }

    static void main() {
        System.out.println(solve("bosscoder quiz practice code"));
    }
}
