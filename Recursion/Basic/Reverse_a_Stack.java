import java.util.Stack;

public class Reverse_a_Stack {

    // Recursive function to reverse the stack
    public static void Reverse(Stack<Integer> st){
        if (st.isEmpty()) {
            return; // Base case: If stack is empty, return
        }

        int top = st.pop(); // Remove the top element
        Reverse(st); // Recursively call for the remaining stack
        insertBottom(st, top); // Insert the removed element at the bottom
    }

    // Recursive function to insert an element at the bottom of the stack
    static void insertBottom(Stack<Integer> st, int element){
        if (st.isEmpty()) {
            st.push(element); // If stack is empty, push the element and return
            return;
        }

        int currnum = st.pop(); // Remove the top element
        insertBottom(st, element); // Recursively insert the element at the bottom
        st.push(currnum); // Push the removed element back to maintain order
    }

    public static void main(String[] args){
        Stack<Integer> str = new Stack<>();
        str.push(5);
        str.push(4);
        str.push(3);
        str.push(2);
        str.push(1);

        System.out.println("Original Stack: " + str);

        Reverse(str); // Call function to reverse the stack

        System.out.println("Reversed Stack: " + str);
    }
}
// Space Complexity: O(n)
// Time Complexity: O(n^2)