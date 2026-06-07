import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.print("Enter a temperature value or type 'stop' to quit: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("stop")) {
                keepRunning = false;
            } else {
                if (!isValidDouble(input)) {
                    System.out.println("Error: Invalid temperature input.");
                } else {
                    double temperature = Double.parseDouble(input);

                    System.out.print("Prompt the user for the unit (C or F): ");
                    String unit = scanner.next();

                    if (!unit.equalsIgnoreCase("C") && !unit.equalsIgnoreCase("F")) {
                        System.out.println("Error: Unrecognized unit label.");
                    } else {
                        double result = convertTemperature(temperature, unit);

                        if (unit.equalsIgnoreCase("C")) {
                            System.out.printf("%.2f C is %.2f F%n", temperature, result);
                        } else {
                            System.out.printf("%.2f F is %.2f C%n", temperature, result);
                        }
                    }
                }
                System.out.println();
            }
        }
        scanner.close();
    }

    // This matches your required signature exactly
    public static double convertTemperature(double temperature, String unit) {
        if (unit != null && unit.equalsIgnoreCase("C")) {
            return (temperature * 9.0 / 5.0) + 32.0;
        } else {
            return (temperature - 32.0) * 5.0 / 9.0;
        }
    }

    private static boolean isValidDouble(String str) {
        if (str == null || str.isEmpty()) return false;
        int decimalCount = 0;
        int startIndex = (str.charAt(0) == '-') ? 1 : 0;
        if (startIndex == 1 && str.length() == 1) return false;

        for (int i = startIndex; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.') {
                decimalCount++;
                if (decimalCount > 1) return false;
            } else if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}

