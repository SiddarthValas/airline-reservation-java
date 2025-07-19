package com.airline;

public class AppTest {
    public static void main(String[] args) {
        // Create an instance of AppTest and run the test
        AppTest test = new AppTest();
        test.shouldAnswerWithTrue();
    }

    public void shouldAnswerWithTrue() {
        // Simple assertion using Java's built-in assert
        assert true : "Test failed: The value should be true"; 

        // If assertion passes
        System.out.println("Test passed!");
    }
}