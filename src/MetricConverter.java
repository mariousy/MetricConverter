import java.util.Scanner;

public class MetricConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Metric Converter!\n" +
                           "Please input your query. For example, 1 kg = lb.\n" +
                           "Enter 'exit' or '-1' to exit the program");

        while (true) {
            String input = scanner.nextLine().trim();

            if ("exit".equals(input) || "-1".equals(input)) {
                break;
            }

            String[] splitInput = input.split("\\s*=\\s*");

            if (splitInput.length != 2) {
                System.out.println("Your input is not currently handled by this app, " +
                                   "please input another query, for example, 1 kg = lb");
                continue;
            }

            try {
                String[] leftSplit = splitInput[0].trim().split("\\s+");
                double value = Double.parseDouble(leftSplit[0]);
                String toUnit = splitInput[1].trim();

                double convertedValue;

                switch (toUnit) {
                    case "lb":
                        convertedValue = value * 2.20462;
                        System.out.println(value + " kg = " + convertedValue + " lb");
                        break;
                    case "oz":
                        convertedValue = value * 0.035274;
                        System.out.println(value + " g = " + convertedValue + " oz");
                        break;
                    case "mi":
                        convertedValue = value * 0.621371;
                        System.out.println(value + " km = " + convertedValue + " mi");
                        break;
                    case "in":
                        convertedValue = value * 0.0393701;
                        System.out.println(value + " mm = " + convertedValue + " in");
                        break;
                    default:
                        System.out.println("Conversion to " + toUnit + " not supported");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        scanner.close();
    }
}
