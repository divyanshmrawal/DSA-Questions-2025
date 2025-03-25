import java.util.Scanner;

public class Factorial_Of_nth_number {

    // Recursive method to compute factorial using tail recursion
    int fac(int n, int product) {
        // Base case: when n reaches 1, return the product
        if (n == 1) {
            return product;
        }

        // Recursive call reducing n and updating the product
        return fac(n - 1, product * n);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter your number : ");
        int input = scan.nextInt();

        // Create an instance of the class
        Factorial_Of_nth_number obj = new Factorial_Of_nth_number();

        // Call the factorial function with initial product as 1
        int answer = obj.fac(input, 1);

        // Display the result
        System.out.print("Your Answer is : " + answer);
    }
}

// Time complexity O(n)
// Space complexity O(1)