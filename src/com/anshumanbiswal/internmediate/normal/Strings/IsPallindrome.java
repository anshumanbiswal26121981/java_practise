package com.anshumanbiswal.internmediate.normal.Strings;

/**
 * Given a String check if the string is palindrome or not
 */
public class IsPallindrome {

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

    public static void main() {
        System.out.println(isPallindrome("madam", 0,4));
        System.out.println(isPallindrome("racecar", 0,6));
        System.out.println(isPallindrome("the", 0,2));
    }
}
