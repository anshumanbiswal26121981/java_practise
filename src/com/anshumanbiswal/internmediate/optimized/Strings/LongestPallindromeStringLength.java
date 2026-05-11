package com.anshumanbiswal.internmediate.optimized.Strings;

import static java.lang.Math.max;

/**
 * Since every palindromic string is symmetric around its center consider every index as the
 * center and expand it in both directions.
 */
public class LongestPallindromeStringLength {
    static int lps(String str) {
        int ans=1;
        int N = str.length();
        for (int c = 0; c < N; ++c) { // c as center
            int l = c-1;
            int r = c+1;
            while( l >= 0 && r < N && (str.charAt(l) == str.charAt(r))) {
                l--; r++;
            }
             ans = max(ans, r-l-1);

            l = c;
            r = c+1;

            while( l >= 0 && r < N && (str.charAt(l) == str.charAt(r))) {
                l--; r++;
            }
            ans = max(ans, r-l-1);
        }
        return ans;
    }

    static void main() {
        
    }
}
