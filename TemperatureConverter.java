public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {

        if (unit.equalsIgnoreCase("C")) {
            return (temperature * 9 / 5) + 32; // C to F
        } else {
            return (temperature - 32) * 5 / 9; // F to C
        }
    }
}
