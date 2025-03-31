//QUESTION-->
//You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.
/*
Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0. At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the chosen number to their score. The game ends when there are no more elements in the array.

Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return true. You may assume that both players are playing optimally.

 

Example 1:

Input: nums = [1,5,2]
Output: false
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return false.
Example 2:

Input: nums = [1,5,233,7]
Output: true
Explanation: Player 1 first chooses 1. Then player 2 has to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
*/

//ANSWER-->
class Solution {

    // Recursive function to calculate the maximum score a player can get 
    int solve(int i, int j, int[] nums) {
        // Base case: If only one element is left, return it
        if (i == j) {
            return nums[i];
        }

        // Base case: If indices cross, return 0 (invalid case)
        if (i > j) {
            return 0;
        }

        // If the player picks the element at index 'j'
        int take_j = nums[j] + Math.min(solve(i, j - 2, nums), solve(i + 1, j - 1, nums));
        
        // If the player picks the element at index 'i'
        int take_i = nums[i] + Math.min(solve(i + 2, j, nums), solve(i + 1, j - 1, nums));

        // Return the maximum score the player can achieve
        return Math.max(take_i, take_j);
    }

    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        int total_score = 0;

        // Calculate the total score of all elements in the array
        for (int i = 0; i < len; i++) {
            total_score += nums[i];
        }

        // Calculate the score for player 1 using the recursive function
        int p1_score = solve(0, len - 1, nums);

        // Player 2's score is the remaining score
        int p2_score = total_score - p1_score;

        // Player 1 wins or ties if their score is greater than or equal to Player 2's score
        return p1_score >= p2_score;
    }
}

// time complexity is O(2ⁿ)
// space complexity is O(n)