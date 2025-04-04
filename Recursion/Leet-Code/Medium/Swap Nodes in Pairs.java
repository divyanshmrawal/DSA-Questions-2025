//QUESTION-->
//Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 
 /*
Example 1:

Input: head = [1,2,3,4]

Output: [2,1,4,3]

Explanation:



Example 2:

Input: head = []

Output: []

Example 3:

Input: head = [1]

Output: [1]

Example 4:

Input: head = [1,2,3]

Output: [2,1,3]
*/
//ANSWER-->

class Solution {
    public ListNode swapPairs(ListNode head) {
        //if list is null then return head because if list is null then we can not swap nodes in combination
        if(head==null || head.next==null){
            return head;
        }

//Store head.next to temp bacause it helps us to update that 2nd node is comes to before the 1st node
    ListNode temp=head.next;

//update head.next to 3rd number in list
head.next=swapPairs(head.next.next);

temp.next=head; 

return temp;
    }
}