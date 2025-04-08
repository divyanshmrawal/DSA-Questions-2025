//QUESTION-->
//Given two binary trees original and cloned and given a reference to a node target in the original tree.
/*
The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

Example 1:


Input: tree = [7,4,3,null,null,6,19], target = 3
Output: 3
Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
Example 2:


Input: tree = [7], target =  7
Output: 7
Example 3:


Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
Output: 4
*/
//ANSWER-->

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // Base case: if original is null, return null
        if(original == null){
            return null;
        }

        // If we've found the target node in the original tree,
        // return the corresponding node from the cloned tree
        if(original == target){
            return cloned;
        }

        // Recursively search in the left subtree
        TreeNode leftResult = getTargetCopy(original.left, cloned.left, target);
        if(leftResult != null){
            return leftResult;
        }

        // If not found in left, search in right subtree
        return getTargetCopy(original.right, cloned.right, target);
    }
}
// Time: O(N), Space: O(H) (where N = total nodes, H = height of the tree)
