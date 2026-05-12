package com.anshumanbiswal.internmediate.normal.Strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Longest Common Prefix
 * Solved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.
 *
 *
 * The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 *
 * Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 *
 *
 *
 *
 * Problem Constraints
 *
 * 0 <= sum of length of all strings <= 1000000
 *
 *
 *
 * Input Format
 *
 * The only argument given is an array of strings A.
 *
 *
 *
 * Output Format
 *
 * Return the longest common prefix of all strings in A.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *
 * A = ["abcdefgh", "aefghijk", "abcefgh"]
 * Input 2:
 *
 * A = ["abab", "ab", "abcd"];
 *
 *
 *
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * "a"
 * Output 2:
 *
 * "ab"
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Longest common prefix of all the strings is "a".
 * Explanation 2:
 *
 * Longest common prefix of all the strings is "ab".
 */
public class LongestCommonPrefixInStringList {
    public static String longestCommonPrefix(ArrayList<String> A) {

        if (A.size() == 1) {
            return A.get(0);
        }

        // find the minLength String
        String minLenString = findMinLenString(A);
        //Remove that element in the list as that will be used to compare with other Strings
        A.remove(minLenString);
        //check from yhe minLengthString what all characters present in all the Strings in the ArrayList
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < minLenString.length(); ++i) {
            char character = minLenString.charAt(i);
            boolean isCharacterPresentAtI = isCharacterPresentAtI(character, i, A);

            //if the character present in all the string at that position i then keep appending it to the answer
            if (isCharacterPresentAtI) {
                answer.append(character);
            }
        }

        return answer.toString();

    }

    public static boolean isCharacterPresentAtI(char character, int i , ArrayList<String> A) {
        for (int j = 0; j < A.size(); ++j) {
            String s = A.get(j);
            if (s.charAt(i) != character) {
                return false;
            }
        }
        return true;
    }

    public static String findMinLenString(ArrayList<String> A) {
        int minLen = A.get(0).length();
        String minLenString = A.get(0);
        int index = 0;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i).length() < minLen) {
                minLen = A.get(i).length();
                minLenString = A.get(i);
                index = i;
            }
        }
        return minLenString;
    }

    static void main() {
        String[] a = {"abcdefgh", "aefghijk", "abcefgh"};
        ArrayList<String> A = new ArrayList<String>(Arrays.stream(a).toList());
        System.out.println(longestCommonPrefix(A));

        String[] b = {"abab", "ab", "abcd"};
        ArrayList<String> B = new ArrayList<String>(Arrays.stream(b).toList());
        System.out.println(longestCommonPrefix(B));
    }
}
