package com.anshumanbiswal.introToProgramming.pattern;

import java.util.ArrayList;
import java.util.List;

/*
Print the Hollow Square Star Pattern for the given value of N.
Input 1:
N = 4
Output 1:

****
*__*
*__*
****
Explanation 1:
Square of 4*4 will be formed with 4 star in first row from the beginning, one star in second row from the beginning and one star in the second row from the last and so on.
Input 2:
N = 3
Output 2:

***
*_*
***
Constraints:
1 <= N <= 10
 */
public class Pattern6 {
    static List<String> solve(int n){
        List<String> list=new ArrayList<String>();
        for(int i=0;i<n;i++){
            String s="";
            for(int j=0;j<n;j++){
                if(i==0 || i==n-1 || j==0 || j==n-1) s=s.concat("*");
                else s=s.concat(" ");
            }
            list.add(s);
        }
        return list;
    }

    static void main() {
        System.out.println(solve(4));
        System.out.println(solve(3));
    }
}
