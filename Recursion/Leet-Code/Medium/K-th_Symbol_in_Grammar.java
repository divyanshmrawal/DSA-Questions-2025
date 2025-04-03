//QUESTION-->
//We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
/*
For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

 

Example 1:

Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0
Example 2:

Input: n = 2, k = 1
Output: 0
Explanation: 
row 1: 0
row 2: 01
Example 3:

Input: n = 2, k = 2
Output: 1
Explanation: 
row 1: 0
row 2: 01
*/
//ANSWER-->

import java.util.*;

class Solution {
    public int kthGrammar(int n, int k) {
        int len = (int) Math.pow(2, n - 1); // Calculate the length of the nth row
        int mid = len / 2; // Find the middle point

        // Base case: The first row contains only '0'
        if (n == 1 && k == 1) {
            return 0;
        }

        // If k is in the first half, the value remains the same as the previous row
        if (k <= mid) {
            return kthGrammar(n - 1, k);
        } 
        // If k is in the second half, the value is the complement of the previous row's value
        else {
            return 1 - kthGrammar(n - 1, k - mid);
        }
    }
}


