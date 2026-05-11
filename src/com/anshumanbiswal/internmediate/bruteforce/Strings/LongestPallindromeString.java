package com.anshumanbiswal.internmediate.bruteforce.Strings;

import static java.lang.Math.max;

public class LongestPallindromeString {
    static int lps(String str) {
        int ans=1;
        for (int start = 0; start < str.length(); ++start) {
            for (int end = start; end < str.length(); ++end) {
                boolean isPalindrome = isPallindrome(str,start,end);
                if (isPalindrome) {
                    ans = max(ans,end-start+1);
                }
            }
        }
        return ans;
    }

    public static boolean isPallindrome(String s, int start, int end) {

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            --end;
        }
        return true;
    }

    static void main() {

    }
}
