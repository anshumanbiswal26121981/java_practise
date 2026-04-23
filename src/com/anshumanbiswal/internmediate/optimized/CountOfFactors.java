package com.anshumanbiswal.internmediate.optimized;

/*
for N = 24
i      N/i
1       24
2       12
3       8
4       6
**********
6       4
8       3
12      2
24      1

for N = 100

i       N/i
1       100
2       50
4       25
5       20
10      10
************
20      5
25      4
50      2
100     1


we can see that after some point of time the factors start repeating
the line is divided when i <= N/i. so if we can count only the first half for i <= N/i

So ,
iterate for  i <= N/i and count the factor in pairs

*/

public class CountOfFactors {

    public static int count(int N) {
        int count = 0;
        for (int i = 1; i <= N/i; ++i) { //for (int i = 1; i * i <= N; ++i) {
            if (N % i == 0) {
                if( i == N/i) { // for perfect squares
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    static void main() {
        System.out.println(count(10));
        System.out.println(count(24));
        System.out.println(count(100));
    }
}
