Revision Notes: Array Techniques
In this class, we covered key techniques related to arrays, specifically focusing on how these can be used to address certain types of problems in data structures and algorithms. Key topics included were Prefix Sum, Carry Forward technique, and Subarrays.

1. Array Techniques Overview
   The class began with an introduction to array techniques aimed at helping solve distinct DSA questions by modifying operations on arrays. Two primary techniques discussed were:

Prefix Sum
Carry Forward
Additionally, subarrays were discussed as an important concept in manipulating arrays【6:0†source】.

2. Prefix Sum
   Concept
   The prefix sum technique involves creating a new array that holds the cumulative sum of elements from the start to each index. This is particularly useful in answering range sum queries efficiently.

Problem Statement
Given an array that represents daily profits or losses, the task is to compute the total profit or loss over given ranges without recalculating for each query【6:0†source】.

Basic Implementation
Create a prefix sum array Psum of the same size as the original array.
For each index i, compute Psum[i] as the sum of array elements from index 0 to i.
Return the prefix sum array【6:1†source】.
Optimized Approach
The class demonstrated an optimized method to compute prefix sums, reducing the time complexity from O(n^2) to O(n) by using previously computed results:

Psum[i] = array[i] + Psum[i-1], for i > 0【6:7†source】.
Application
The prefix sum allows query answers in constant time after preprocessing, which is efficient compared to recalculating sums for each query【6:11†source】.

3. Carry Forward Technique
   Concept
   The carry forward technique is utilized to efficiently process problems involving pairs over a sequence, such as counting pair relationships between characters or elements of an array【6:8†source】.

Example Problem
Count pairs (i, j) in a string such that the character at index i is 'a', and at index j is 'g', and i < j.

Approach
Maintain a count of 'a's while iterating through the string.
For each 'g' encountered, add the count of previous 'a's to your answer【6:10†source】.
Complexity
Reduced from O(n^2) to O(n) using a single pass with auxiliary counting【6:15†source】.

4. Subarrays
   Definition
   A subarray is a contiguous part of an array, maintaining the order and directional flow of elements. Each subarray must at least contain one element【6:6†source】.

Representation Methods
By starting and ending indices.
By starting index and length【6:6†source】.
Task
The task was to understand the concept of subarrays well enough to solve subsequent problems, ensuring the foundation was laid without diving deep into every possible application【6:17†source】.

Summary
The session's main takeaway was to understand these techniques as foundational tools that would be repeatedly used when solving more complex problems in future coding challenges. The importance of prefixes and carry forward as optimization strategies was emphasized, enabling more efficient algorithms in practice【6:18†source】. This session laid the groundwork for improving problem-solving skills, focusing on methodical performance enhancements.