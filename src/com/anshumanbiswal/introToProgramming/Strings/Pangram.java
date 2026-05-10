package com.anshumanbiswal.introToProgramming.Strings;

import java.util.HashSet;

/**
 * Check if given String is Pangram or not
 * Note : A pangram is a sentence containing every letter in the English Alphabet.
 *
 * Input 1: “The quick brown fox jumps over the lazy dog”
 * Output 1: true
 * Explanation 1: Contains all the characters from ‘a’ to ‘z’
 *
 * Input 2: “The quick brown fox jumps over the dog”
 * Output 2: false
 * Constraints:
 * 1 <= str.length <= 105
 */
public class Pangram {

    static boolean check(String str){
        str = str.toLowerCase();
        HashSet<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                set.add(ch);
            }
        }

        return set.size() == 26;

    }

    static void main() {
        String s = "The quick brown fox jumps over the lazy dog.";
        System.out.println(check(s));
    }
}
