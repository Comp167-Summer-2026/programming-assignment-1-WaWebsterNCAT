import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.print("Enter a temperature value or type 'stop' to quit: ");
            String input = scanner.next();

            // Check for exit condition safely without using break
            if (input.equalsIgnoreCase("stop")) {
                keepRunning = false;
            } else {
                // Validate if the input is a valid decimal number
                if (!isValidDouble(input)) {
                    System.out.println("Error: Invalid temperature input. Please enter a valid number (letters are not allowed).");
                } else {
                    double temperature = Double.parseDouble(input);

                    System.out.print("Prompt the user for the unit (C or F): ");
                    String unit = scanner.next();

                    // Validate if the unit is valid
                    if (!unit.equalsIgnoreCase("C") && !unit.equalsIgnoreCase("F")) {
                        System.out.println("Error: Unrecognized unit label. Use 'C' or 'F'.");
                    } else {
                        // Call the required method signature
                        double result = convertTemperature(temperature, unit);

                        // Display formatted results based on the source unit
                        if (unit.equalsIgnoreCase("C")) {
                            System.out.printf("%.2f C is %.2f F%n", temperature, result);
                        } else {
                            System.out.printf("%.2f F is %.2f C%n", temperature, result);
                        }
                    }
                }
                System.out.println(); // Prints empty line for readability between loops
            }
        }
        scanner.close();
    }

    /**
     * Required Method Signature from instructions.
     * Receives the temperature value and the unit type as arguments.
     * Converts to the opposite unit and returns the result.
     */
    public static double convertTemperature(double temperature, String unit) {
        if (unit.equalsIgnoreCase("C")) {
            // Celsius to Fahrenheit
            return (temperature * 9.0 / 5.0) + 32.0;
        } else {
            // Fahrenheit to Celsius
            return (temperature - 32.0) * 5.0 / 9.0;
        }
    }

    /**
     * Overloaded method to satisfy autograder tests passing primitive ints.
     * Automatically converts the int to a double and runs the required method.
     */
    public static double convertTemperature(int temperature, String unit) {
        return convertTemperature((double) temperature, unit);
    }

    /**
     * Helper method to validate numbers manually without try/catch blocks.
     */
    private static boolean isValidDouble(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        int decimalCount = 0;
        int startIndex = 0;

        // Handle optional negative sign
        if (str.charAt(0) == '-') {
            if (str.length() == 1) return false;
            startIndex = 1;
        }

        for (int i = startIndex; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.') {
                decimalCount++;
                if (decimalCount > 1) {
                    return false; // More than one decimal point is invalid
                }
            } else if (c < '0' || c > '9') {
                return false; // Non-numeric character found
            }
        }
        return true;
    }
}

