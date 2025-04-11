//QUESTION-->
//You are given the root of a binary search tree (BST) and an integer val.

// Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

// Example 1:
// Input: root = [4,2,7,1,3], val = 2
// Output: [2,1,3]

// Example 2:
// Input: root = [4,2,7,1,3], val = 5
// Output: []

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
    public TreeNode searchBST(TreeNode root, int val) {
        // Base case: if current node is null, return null
        if (root == null) {
            return null;
        }

        // If the value of the current node matches the target, return the node
        if (root.val == val) {
            return root;
        }
        
        // If the target value is smaller, search in the left subtree
        else if (root.val > val) {
            return searchBST(root.left, val);
        }

        // If the target value is larger, search in the right subtree
        else {
            return searchBST(root.right, val);
        }
    }
}

// Time Complexity:O(log n)
// Space Complexity:O(h)