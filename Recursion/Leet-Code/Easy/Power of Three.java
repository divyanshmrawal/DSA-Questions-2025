//QUESTION-->
//Given an integer n, return true if it is a power of three. Otherwise, return false.
/*
An integer n is a power of three, if there exists an integer x such that n == 3x.

Example 1:
Input: n = 27
Output: true
Explanation: 27 = 33

Example 2:
Input: n = 0
Output: false
Explanation: There is no x where 3x = 0.

Example 3:
Input: n = -1
Output: false
Explanation: There is no x where 3x = (-1).

*/
//ANSWER-->
class Solution {
    // Function to check if a number is a power of three
    public boolean isPowerOfThree(int n) {

        // Base case: if n is 1, it's 3^0, so return true
        if(n == 1){
            return true;
        }

        // If n is less than or equal to 0, or not divisible by 3, it's not a power of 3
        if(n <= 0 || n % 3 != 0){
            return false;
        }

        // Recursive call: divide n by 3 and check again
        return isPowerOfThree(n / 3);
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(log n)