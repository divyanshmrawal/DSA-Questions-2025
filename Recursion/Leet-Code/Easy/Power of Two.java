//QUESTION-->
//Given an integer n, return true if it is a power of two. Otherwise, return false.
/*
An integer n is a power of two, if there exists an integer x such that n == 2x.

 

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false
*/
//ANSWER-->
class Solution {
    public boolean isPowerOfTwo(int n) {
        // Base case: 1 is 2^0, so return true
        if(n == 1) {
            return true;
        }

        // If n is less than or equal to 0, or not divisible by 2, it's not a power of 2
        if(n <= 0 || n % 2 != 0) {
            return false;
        }

        // Recursive call: divide n by 2 and check again
        return isPowerOfTwo(n / 2);
    }
}

// Time Complexity:O(log n)
// Space Complexity:O(log n)