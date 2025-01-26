package classwork;

public class MathUtils {

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract the second integer from the first
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method to multiply two integers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method to divide the first integer by the second
    public double divide(int a, int b) {
        if (b == 0) {
            // Handle division by zero
            return -1.0;
        }
        return (double) a / b;
    }
    
}
