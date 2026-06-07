import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.print("Enter temperature (or type 'stop' to quit): ");
            String tempInput = input.nextLine();

            if (tempInput.equalsIgnoreCase("stop")) {
                System.out.println("Program ended.");
                break;
            }

            // validate numeric input manually (no exceptions)
            if (!isNumeric(tempInput)) {
                System.out.println("Error: Please enter a valid number.");
                continue;
            }

            double temperature = Double.parseDouble(tempInput);

            System.out.print("Enter unit (C or F): ");
            String unit = input.nextLine().trim();

            if (!unit.equalsIgnoreCase("C") && !unit.equalsIgnoreCase("F")) {
                System.out.println("Error: Unit must be 'C' or 'F'.");
                continue;
            }

            double result = convertTemperature(temperature, unit);

            if (unit.equalsIgnoreCase("C")) {
                System.out.println(temperature + "°C = " + result + "°F");
            } else {
                System.out.println(temperature + "°F = " + result + "°C");
            }
        }

        input.close();
    }

    // REQUIRED METHOD
    public static double convertTemperature(double temperature, String unit) {

        if (unit.equalsIgnoreCase("C")) {
            // Celsius to Fahrenheit
            return (temperature * 9 / 5) + 32;
        } else {
            // Fahrenheit to Celsius
            return (temperature - 32) * 5 / 9;
        }
    }

    // helper method (avoids exceptions)
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (!Character.isDigit(c) && c != '.' && c != '-' ) {
                return false;
            }
        }

        return true;
    }
}
