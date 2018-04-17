package de.gotthold;

public class Main {

    /**
     * Main entry point for calling the two methods.
     */
    public static void main(String[] args) {
	    MaxSubString maxSubString = new MaxSubString();
	    String resultRecursive = maxSubString.MaxSubStringRecursive("informativ","undramatisch");
        String resultIterative = maxSubString.MaxSubStringIterative("informativ","undramatisch");

        System.out.println("Rekursiv: " + resultRecursive);
        System.out.println("Iterativ: " + resultIterative);
    }
}
