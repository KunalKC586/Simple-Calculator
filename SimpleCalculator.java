import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("Welcome to the Enhanced Simple Calculator");
        System.out.println("------------------------------------------");

        while (keepRunning) {
            System.out.println("Menu:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                case 2:
                case 3:
                case 4:
                    performOperation(option, scanner);
                    break;

                case 5:
                    System.out.println("Exiting the calculator. Goodbye!");
                    keepRunning = false;
                    break;

                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }

            System.out.println("------------------------------------------");
        }

        scanner.close();
    }

    private static void performOperation(int option, Scanner scanner) {
        System.out.print("Enter the first number: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
            scanner.next(); 
            return;
        }
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
            scanner.next();
            return;
        }
        double num2 = scanner.nextDouble();

        double result = 0;
        boolean calculationError = false;

        switch (option) {
            case 1:
                result = num1 + num2;
                System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
                break;
            case 2:
                result = num1 - num2;
                System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
                break;
            case 3:
                result = num1 * num2;
                System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    calculationError = true;
                } else {
                    result = num1 / num2;
                    System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("Error: Invalid operation.");
                calculationError = true;
        }

        if (!calculationError) {
            System.out.println("Calculation successful.");
        }
    }
}
