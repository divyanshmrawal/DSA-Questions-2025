//QUESTION-->
//Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
/*
Example 1:


Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
Example 2:


Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
*/
//ANSWER-->
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0; // This will store the sum of values within the given range

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0; // Base case: if the node is null, return 0
        }

        // If current node's value is within the range, add it to sum
        // and recursively call for both left and right subtrees
        if (root.val >= low && root.val <= high) {
            rangeSumBST(root.left, low, high);
            ans += root.val;
            rangeSumBST(root.right, low, high);
        }

        // If current node's value is less than low,
        // we ignore the left subtree (all values will be smaller)
        else if (root.val < low) {
            rangeSumBST(root.right, low, high);
        }

        // If current node's value is greater than high,
        // we ignore the right subtree (all values will be greater)
        else if (root.val > high) {
            rangeSumBST(root.left, low, high);
        }

        return ans;
    }
}

// Time: O(N)
// Space: O(H) 
// (where N = number of nodes, H = height of the tree)