Revision Notes for Software Engineering Class on Array Techniques
Table of Contents
Introduction
Key Concepts
Problems and Algorithms
Detailed Explanations
1. Introduction
   In this session, the focus was on exploring array manipulation techniques, specifically optimizing calculations through the use of prefix sums and determining leaders in an array. The class emphasized practical applications through coding exercises.

2. Key Concepts
   Prefix Sum
   The prefix sum is an array manipulation technique used to simplify range sum queries. It involves creating a cumulative sum of elements up to each index, enabling constant-time range sum calculations.

Special Index
Special indices in an array are the ones which when removed, result in equal sums of elements at even and odd indices of the remaining array.

Leaders in an Array
An element is defined as a leader if it is greater than all elements to its right in the array. The problem involves determining these leaders efficiently.

3. Problems and Algorithms
   Problem 1: Sum of Odd Indexed Elements
   Given an array and query indices, calculate the sum of odd indexed elements within the given range.

Approach:
Brute Force: Calculate sums by iterating over the specified indices for each query.
Optimized Strategy: Use prefix sums for odd indices to allow constant time retrieval for any range【4:15†source】.
Problem 2: Calculate Special Indices
Determine how many special indices exist in an array.

Approach:
Maintain prefix sums for both odd and even indices.
For each index, simulate removal and check equality of the two prefix sums【4:14†source】.
Problem 3: Determine Leaders in an Array
Find leaders in the array where leaders are larger than all elements to their right.

Approach:
Brute Force: Compare each element with all elements to its right.
Optimized Strategy: Traverse the array from right to left, maintaining a running maximum (a carry forward of the maximum element encountered thus far). This reduces the need to compare the current element against all its successors【4:1†source】【4:17†source】.
4. Detailed Explanations
   Prefix Sum Array
   The prefix sum array for odd indices is created as follows:

If the index i is odd: PSo[i] = PSo[i-1] + A[i]
If the index i is even: PSo[i] = PSo[i-1]
Example:
Given array A[] = {2, 3, 1, 6, 4, 5}, the odd indexed prefix sum PSo[] becomes {0, 3, 3, 9, 9, 14}.

Computing Leaders
For each element from right to left:

Use a variable max_on_right to store the maximum observed on the right.
If an element is greater than max_on_right, it is a leader.
Update max_on_right as you move left through the array【4:3†source】【4:6†source】.
Understanding Special Indices
For each index, calculate if removing it balances the prefix sums for the odd and even positions. Utilize the pre-computed prefix sums to achieve this efficiently, expecting an entire traversal only once to obtain these sums【4:9†source】【4:10†source】.

These notes compile the core techniques taught in the class, focusing on efficient algorithm design using prefix sums and array manipulations, aiming for enhanced computational performance.