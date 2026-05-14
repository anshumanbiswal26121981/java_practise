package com.anshumanbiswal.internmediate.Contest;

/**
 * two striungs ared given start capitalizing from second stroing onwirdsd oinm first string
 *
 * A = "hello"
 * B = "e"
 *
 * output: hELLO
 */
public class AliceCaptitalizing {
    public static String solve(String A, String B) {

        int index = A.indexOf(B);

        if (index == -1) {
            return A;
        }

        String firstPart = A.substring(0, index);

        String secondPart =
                A.substring(index).toUpperCase();

        return firstPart + secondPart;
    }

    public static void main(String[] args) {

        String A = "hello";
        String B = "e";

        System.out.println(solve(A, B));
    }
}
