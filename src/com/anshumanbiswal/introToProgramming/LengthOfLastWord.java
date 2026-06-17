package com.anshumanbiswal.introToProgramming;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string. A word is a maximal substring consisting of non-space characters only.
 *
 * Input 1: s = "Hello World"
 * Output 1: 5
 * Explanation 1: The last word is "World" with length 5.
 *
 * Input 2: s = " fly me to the moon "
 * Output 2: 4
 * Constraints:
 * 1 <= s.length <= 10000
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 */
public class LengthOfLastWord {
    static int solve(String s){
        String [] splits = s.trim().split("\\s+");
        int len = splits.length;
        String lastWord = splits[len-1];
        return lastWord.length();
    }
    static void main() {
        System.out.println(solve("Hello World"));
        System.out.println(solve(" fly me to the moon "));
    }
}
