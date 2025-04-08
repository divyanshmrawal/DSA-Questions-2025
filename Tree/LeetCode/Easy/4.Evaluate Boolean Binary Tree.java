//QUESTION-->

/* 
//You are given the root of a full binary tree with the following properties:

Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
The evaluation of a node is as follows:

If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
Return the boolean result of evaluating the root node.

A full binary tree is a binary tree where each node has either 0 or 2 children.

A leaf node is a node that has zero children.

 

Example 1:


Input: root = [2,1,3,null,null,0,1]
Output: true
Explanation: The above diagram illustrates the evaluation process.
The AND node evaluates to False AND True = False.
The OR node evaluates to True OR False = True.
The root node evaluates to True, so we return true.
Example 2:

Input: root = [0]
Output: false
Explanation: The root node is a leaf node and it evaluates to false, so we return false.
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
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false; // An empty node returns false (though in this problem root is always non-null).
        }

        // If the node is a leaf, return its boolean value (0 -> false, 1 -> true).
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        // Recursively evaluate the left and right subtrees.
        boolean rightval = evaluateTree(root.right);
        boolean leftval = evaluateTree(root.left);

        // If current node's value is 2, it represents OR operation.
        if (root.val == 2) {
            return rightval || leftval;
        }

        // If current node's value is 3, it represents AND operation.
        if (root.val == 3) {
            return rightval && leftval;
        }

        return false; // Default return for invalid node value (shouldn’t happen in valid input).
    }
}

// Time Complexity: O(n), Space Complexity: O(h) 