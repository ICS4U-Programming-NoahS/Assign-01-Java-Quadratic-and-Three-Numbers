import java.util.Scanner;

/**
* The QuadraticThreeNumbers is 2 programs in one.
* The user can choose the one they want to try.
* The first program is a solves quadratic equations.
* The user is asked to enter a b and c, then the value(s) of x is displayed
* The second program asks the user to enter 3 numbers.
* The program then displays the smallest number.
* The programs will keep looping until the user presses q to quit.

*
* @author Noah Smith
* @version 1.0
* @since 2025-03-07
*/

final class QuadraticThreeNumbers {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private QuadraticThreeNumbers() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Function for the quadratic equation formula.
     *
     * @param numA The first number.
     * @param numB The second number.
     * @param numC The third number.
     * @return The solutions of x.
     */

    public static String calcQuadratic(
            final double numA, final double numB, final double numC
        ) {

        // Define the discriminant
        double discriminant = Math.pow(numB, 2) - (4 * numA * numC);

        // Initialize message
        String calcQuadraticMessage = "";

        // Check if the discriminant is negative
        if (discriminant < 0) {
            calcQuadraticMessage = (
            "The discriminant is negative, no real solutions."
                );

        // Check if a is 0
        } else if (numA == 0) {
            // Tell the user that a cannot be 0
            calcQuadraticMessage = ("a cannot be zero. Try again.");

        // Check if the discriminant is equal to 0
        } else if (discriminant == 0) {

            // If this is true it will have 1 solution
            double x = -numB / (2 * numA);

            // Write the solution in a string, rounded to 2 decimal places
            calcQuadraticMessage = (
            "x is equal to " + String.format("%.2f", x) + "."
                );

        // If there are 2 solutions
        } else {
            // Solution 1
            double x1 = (-numB + Math.sqrt(Math.pow(numB, 2)
            - (4 * numA * numC))) / (2 * numA);

            // Solution 2
            double x2 = (-numB - Math.sqrt(Math.pow(numB, 2)
            - (4 * numA * numC))) / (2 * numA);

            // Write the solutions in a string, rounded to 2 decimal places
            calcQuadraticMessage = (
            "x is equal to "
            + String.format("%.2f", x1)
            + " and " + String.format("%.2f", x2) + "."
                );
        }

        // Return the solution(s) or error message
        return calcQuadraticMessage;

    }

    /**
     * Function for the smallest number program.
     *
     * @param numA The first number.
     * @param numB The second number.
     * @param numC The third number.
     * @return The smallest number.
     */
    public static String smallestNumber(
            final double numA, final double numB, final double numC
        ) {

        // Initialize message
        String smallestNumberMessage = "";

        // Check if a is the smallest
        if (numA < numB && numA < numC) {
            smallestNumberMessage = (numA + " is the smallest.");

        // Check if b is the smallest
        } else if (numB < numA && numB < numC) {
            smallestNumberMessage = (numB + " is the smallest.");

        // Check if c is the smallest
        } else if (numC < numA && numC < numB) {
            smallestNumberMessage = (numC + " is the smallest.");

        // Check if a and b are the smallest
        } else if (numA == numB && numA < numC) {
            smallestNumberMessage = (numA + " and " + numB
            + " are the smallest.");

        // Check if a and c are the smallest
        } else if (numA == numC && numA < numB) {
            smallestNumberMessage = (numA + " and " + numC
            + " are the smallest.");

        // Check if b and c are the smallest
        } else if (numB == numC && numB < numA) {
            smallestNumberMessage = (numB + " and " + numC
            + " are the smallest.");

        // Check if all are the same
        } else {
            smallestNumberMessage = (numA + ", " + numB + ", and " + numC
            + " are the smallest.");
        }

        // Return the smallest number
        return smallestNumberMessage;
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {

        // Using Scanner for getting input from user
        Scanner scanner = new Scanner(System.in);

        // Greet user
        System.out.println("Welcome!");
        System.out.print("\n");

        // Initialize choice outside of the loop
        String choice = "";

        // Loop to give user another chance to enter valid input
        // and to run the program again
        do {

            // Tell the options to the user
            System.out.println(
                    "Enter 1 to use the quadratic equation program. "
                );
            System.out.println(
                    "Enter 2 to use the smallest number program. "
                );
            System.out.println(
                    "If you are done playing, enter 'q' to quit: "
                );

            // Reset choice
            choice = "";

            // Get the choice from the user
            choice = scanner.nextLine();

            if ((choice.equals("1")) || choice.equals("2")) {
                if (choice.equals("1")) {
                    // display instructions for the quadratic equation program
                    System.out.println(
                            "You have chosen the quadratic equation program."
                        );
                    System.out.println(
                            "Enter a, b, and c for the quadratic equation."
                        );
                    System.out.println(
                            "The formula is: (-b ± √(b² - 4ac)) / 2a"
                        );
                } else {
                    // display instructions for the smallest number program
                    System.out.println(
                            "You have chosen the smallest number program."
                        );
                    System.out.println(
                            "Enter 3 numbers to find the smallest one."
                        );
                }

                // Get the first number
                System.out.print("Enter the first number: ");

                // try catch block to handle invalid input
                try {
                    // try to convert first number to double
                    double numA = scanner.nextDouble();

                    // Get the second number
                    System.out.print("Enter the second number: ");

                    // try to convert second number to double
                    double numB = scanner.nextDouble();

                    // Get the third number
                    System.out.print("Enter the third number: ");

                    // try to convert third number to double
                    double numC = scanner.nextDouble();

                    // Clear leftover text to fix error
                    scanner.nextLine();

                    // If the user chooses program 1
                    if (choice.equals("1")) {
                        // Call the quadratic equation function
                        String calcQuadraticMessage = calcQuadratic(
                                numA, numB, numC
                            );

                        // Display the solutions of x or the error message
                        System.out.println(calcQuadraticMessage);

                    // If the user chooses program 2
                    } else if (choice.equals("2")) {

                        // Call the smallest number function
                        String smallestNumMessage = smallestNumber(
                                numA, numB, numC
                            );

                        // Display the smallest number(s)
                        System.out.println(smallestNumMessage);

                    // If the user enters an invalid choice
                    } else {
                        System.out.println("Invalid choice. Try again.");
                    }

                // Catch invalid input
                } catch (Exception exception) {
                    // Display error message
                    System.out.println(
                            "Invalid input. Enter a number next time."
                        );

                    // Move on to next line to prevent infinite loop
                    scanner.nextLine();
                }

            // If the user enters q to quit
            } else if (choice.equals("q")) {
                // display goodbye message
                System.out.println("Goodbye!");
            } else {
                // If the user enters an invalid choice
                System.out.println("Invalid choice. Try again.");
            }
        // While the user does not enter q
        } while (!choice.equals("q"));

        // Closing Scanner
        scanner.close();
    }
}
