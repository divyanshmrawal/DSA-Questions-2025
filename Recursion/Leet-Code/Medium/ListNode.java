//QUESTION-->
//You are given the head of a singly linked-list. The list can be represented as:
/* 
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]*/

//ANSWER-->

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


// =========================================================[APPROCH = 1st]=========================================================
class Solution {
    public void reorderList(ListNode head) {
        // Base case: if the list is empty or has only one node, no reordering is needed
        if (head == null || head.next == null) return;
        
        ListNode temp = null;
        ListNode j = head.next; // Pointer to traverse the list

        // Iterate through the list to reorder it
        while (head != null && head.next != null && j != null) {
            // Move j to the second last node in the list
            while (j.next != null && j.next.next != null) {
                j = j.next;
            }
            
            temp = j.next; // Last node of the list
            if (temp == null) break; // If there's no last node, stop the process
            
            j.next = null; // Remove last node from its position
            temp.next = head.next; // Link last node to the second node
            head.next = temp; // Insert last node after the first node
            
            // Move head pointer two steps ahead for the next iteration
            head = head.next.next;
            j = head.next;
        }
    }
}

// =========================================================[APPROCH = 2nd]=========================================================
class Solution {
    ListNode curr; // Pointer to track the current position during reordering

    // Recursive function to reorder the linked list
    void solve(ListNode head) {
        if (head == null) { // Base case: If we reach the end of the list, return
            return;
        }   

        solve(head.next); // Recursively call for the next node to reach the end first

        ListNode temp = curr.next; // Store the next node after curr

        if (temp == null) { // If temp is null, no more processing is needed
            return;
        } 
        else if (head == curr) { // If head and curr meet, it means we are at the middle, so break the link
            head.next = null;
            return;
        }

        curr.next = head; // Connect curr node to head
        head.next = (temp == head) ? null : temp; // If temp is head, terminate the list, else link head to temp
        curr = temp; // Move curr forward
    }

    // Function to reorder the linked list
    public void reorderList(ListNode head) {
        curr = head; // Initialize curr with head
        solve(head); // Start the recursive reordering process
    }
}

// Time Complexity:O(n)
// Space Complexity:O(1)
