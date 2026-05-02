Revision Notes: Sum of Subarrays and Maximum Sum Subarray of Length K
Agenda
Calculate the Total Sum of All Subarray Sums.
Find the Maximum Sum Subarray of Length K.
1. Total Sum of All Subarray Sums
   Problem Statement: Given an array of size
   N
   N, calculate the total sum of all the subarray sums【4:0†handwritten.pdf】.

Approaches:
Approach 1: Brute Force
Idea: Consider every possible subarray by iterating over all starting and ending indices. Calculate their sum and accumulate this in a global sum variable.
Time Complexity:
O
(
N
3
)
O(N
3
)【4:0†handwritten.pdf】.
int allSubarraySum(int arr[], int N) {
int totalSum = 0;
for (int s = 0; s < N; s++) {
for (int e = s; e < N; e++) {
int sum = 0;
for (int i = s; i <= e; i++) {
sum += arr[i];
}
totalSum += sum;
}
}
return totalSum;
}
Approach 2: Using Prefix Sum
Idea: Utilize prefix sums to calculate the sum of any subarray in constant time.
Time Complexity:
O
(
N
2
)
O(N
2
)【4:0†handwritten.pdf】.
int allSubarraySum(int arr[], int N) {
int psum[N];
psum[0] = arr[0];
for (int i = 1; i < N; ++i) {
psum[i] = psum[i - 1] + arr[i];
}
int totalSum = 0;
for (int s = 0; s < N; s++) {
for (int e = s; e < N; e++) {
int sum = (s == 0) ? psum[e] : psum[e] - psum[s - 1];
totalSum += sum;
}
}
return totalSum;
}
Approach 3: Combination of Brute Force and Prefix Sum
Idea: Avoid using extra space for prefix sum.
Time Complexity:
O
(
N
2
)
O(N
2
).
Space Complexity:
O
(
1
)
O(1)【4:0†handwritten.pdf】.
int allSubarraySum(int arr[], int N) {
int totalSum = 0;
for (int s = 0; s < N; s++) {
int sum = 0;
for (int e = s; e < N; e++) {
sum += arr[e];
totalSum += sum;
}
}
return totalSum;
}
Approach 4: Contribution Technique
Idea: Calculate how many subarrays an element appears in and multiply this count by the element's value【4:0†handwritten.pdf】.
int allSubarraySum(int arr[], int N) {
int totalSum = 0;
for (int i = 0; i < N; i++) {
int contribution = arr[i] * (i + 1) * (N - i);
totalSum += contribution;
}
return totalSum;
}
2. Maximum Sum Subarray of Length K
   Problem Statement: Given an array of size
   N
   N and an integer
   K
   K, find the maximum sum of all subarrays of length
   K
   K【4:1†handwritten.pdf】.

Approaches:
Approach 1: Brute Force
Idea: Iterate over every possible subarray of length
K
K and calculate its sum to find the maximum.
Time Complexity:
O
(
N
×
K
)
O(N×K)【4:2†handwritten.pdf】.
int maxSumSubarray(int arr[], int N, int K) {
int ans = INT_MIN;
for (int s = 0; s <= N - K; s++) {
int sum = 0;
for (int i = s; i < s + K; i++) {
sum += arr[i];
}
ans = max(ans, sum);
}
return ans;
}
Approach 2: Sliding Window
Idea: Compute the sum of the first window of length
K
K. Then, slide the window across the array, adding the next element and removing the first (leftmost) element of the window.
Time Complexity:
O
(
N
)
O(N)【4:2†handwritten.pdf】.
int maxSumSubarray(int arr[], int N, int K) {
int sum = 0, ans;
// Calculate the sum of the first window
for (int i = 0; i < K; i++) {
sum += arr[i];
}
ans = sum;
// Slide the window
for (int i = K; i < N; i++) {
sum += arr[i] - arr[i - K];
ans = max(ans, sum);
}
return ans;
}
This note covers all discussed algorithms and approaches for computing subarray sums and maximum subarray sums, providing a variety of methods with differing time and space complexities【4:3†handwritten.pdf】.