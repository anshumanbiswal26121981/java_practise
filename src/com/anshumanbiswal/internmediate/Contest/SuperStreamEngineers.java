package com.anshumanbiswal.internmediate.Contest;

/**
 * You've just been hired as a network engineer at SuperStream, a leading video streaming service. One of your first tasks is to optimize the number of video data packets sent to users based on their internet connectivity.
 *
 * When a user hits "play," video data is transmitted in packets. If their device acknowledges these packets quickly, it means they have a strong connection and can receive more packets simultaneously for smoother streaming. If acknowledgments lag, fewer packets should be sent to prevent buffering.
 *
 * Given an array A, where each entry represents the acknowledgment time (in milliseconds) for individual packets, and two integers B and C, can you determine if there's a continuous sequence of B packets with an average acknowledgment time less than or equal to C milliseconds? If so, it's a green signal (integer 1) to send more packets. Otherwise, it's time to throttle back (integer 0).
 *
 * Note: For average, take the floor of (sum / total number of elements).
 *
 * Problem Constraints
 *
 * 1 <= ... (rest is cut off in the image)
 */
public class SuperStreamEngineers {

    public int solve(int[] A, int B, int C) {

        int n = A.length;

        // Calculate first window sum
        int sum = 0;

        for (int i = 0; i < B; i++) {
            sum += A[i];
        }

        // Check first window
        if ((sum / B) <= C) {
            return 1;
        }

        // Sliding window
        for (int i = B; i < n; i++) {

            sum = sum - A[i - B] + A[i];

            if ((sum / B) <= C) {
                return 1;
            }
        }

        return 0;
    }

    /**
     * Example
     *
     * Input:
     *
     * A = [1, 2, 3, 4, 5]
     * B = 2
     * C = 2
     *
     * Subarrays of size 2:
     *
     * [1,2] → avg = 1
     * [2,3] → avg = 2
     * [3,4] → avg = 3
     * [4,5] → avg = 4
     *
     * Since a valid subarray exists, output:
     *
     * 1
     * @param A
     * @param B
     * @param C
     * @return
     */
    public int optimizedSolve(int[] A, int B, int C) {

        int n = A.length;
        int sum = 0;

        // First window
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }

        if (sum <= B * C) {
            return 1;
        }

        // Remaining windows
        for (int i = B; i < n; i++) {

            sum = sum - A[i - B] + A[i];

            if (sum <= B * C) {
                return 1;
            }
        }

        return 0;
    }
}
