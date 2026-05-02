package com.anshumanbiswal.internmediate.optimized.prefixsum;

/**
 * Equilibrium index of an array
 * Unsolved
 * feature icon
 * Using hints except Complete Solution is Penalty free now
 * Use Hint
 * Problem Description
 *
 * You are given an array A of integers of size N.
 *
 * Your task is to find the equilibrium index of the given array
 *
 * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 *
 * If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
 *
 * Note:
 *
 * Array indexing starts from 0.
 * If there is no equilibrium index then return -1.
 * If there are more than one equilibrium indexes then return the minimum index.
 *
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 * -105 <= A[i] <= 105
 *
 *
 * Input Format
 *
 * First arugment is an array A .
 *
 *
 * Output Format
 *
 * Return the equilibrium index of the given array. If no such index is found then return -1.
 *
 *
 * Example Input
 *
 * Input 1:
 * A = [-7, 1, 5, 2, -4, 3, 0]
 * Input 2:
 *
 * A = [1, 2, 3]
 *
 *
 * Example Output
 *
 * Output 1:
 * 3
 * Output 2:
 *
 * -1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 * i   Sum of elements at lower indexes    Sum of elements at higher indexes
 * 0                   0                                   7
 * 1                  -7                                   6
 * 2                  -6                                   1
 * 3                  -1                                  -1
 * 4                   1                                   3
 * 5                  -3                                   0
 * 6                   0                                   0
 *
 * 3 is an equilibrium index, because:
 * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
 * Explanation 1:
 *
 * i   Sum of elements at lower indexes    Sum of elements at higher indexes
 * 0                   0                                   5
 * 1                   1                                   3
 * 2                   3                                   0
 * Thus, there is no such index.
 *
 *
 * To solve the Equilibrium Index problem efficiently, use the prefix-sum idea without storing the prefix array (O(N) time, O(1) space) ✅
 *
 * 🧠 Key Idea
 *
 * For index i to be an equilibrium index:
 *
 * leftSum == rightSum
 *
 * Instead of recomputing sums repeatedly:
 *
 * Compute totalSum of the array
 * Traverse the array
 * Maintain leftSum
 * Compute:
 * rightSum = totalSum − leftSum − A[i]
 *
 * If:
 * leftSum == rightSum
 *
 * return index i
 *
 * Return the first such index (minimum index required).
 */
public class EquilibriumIndexOfArray {

        public static int equilibriumIndex(int[] A) {

            long totalSum = 0;

            // Step 1: compute total sum
            for (int num : A) {
                totalSum += num;
            }

            long leftSum = 0;

            // Step 2: check equilibrium condition
            for (int i = 0; i < A.length; i++) {

                long rightSum = totalSum - leftSum - A[i];

                if (leftSum == rightSum) {
                    return i;
                }

                leftSum += A[i];
            }

            return -1;
        }

        public static void main(String[] args) {

            int[] A = {-7, 1, 5, 2, -4, 3, 0};

            System.out.println(equilibriumIndex(A)); // Output: 3
        }
}
