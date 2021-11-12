package calculator;

import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static MathematicalCalculation mathematicalCalculation = new MathematicalCalculationImpl();

    private static FileManager instance;

    private static final String NUMBER_PATTERN = "-?\\d+(\\.\\d+)?";

    private FileManager() {
    }

    public static List<String> getOperationsFromLine(String line) {
        List<String> operations = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '+' ||
                    line.charAt(i) == '-' ||
                    line.charAt(i) == '*' ||
                    line.charAt(i) == '/')
                operations.add(String.valueOf(line.charAt(i)));
        }

        return operations;
    }

    public static List<Float> getNumbersFromLine(String line) {

        line = line.replace(" ", "");
        String[] split = line.split("[-+*/]");
        List<Float> numbers = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].matches(NUMBER_PATTERN)) {
                numbers.add(Float.valueOf(split[i]));
            }
        }

        return numbers;
    }

    public static float getResult(List<Float> numbers, List<String> operations) {
        float firstNumber = numbers.get(0);
        float result = 0;
        for (int i = 0; i < operations.size(); i++) {
            result = mathematicalCalculation.calculate(firstNumber, numbers.get(i + 1), operations.get(i));
            firstNumber = result;
        }
        return result;
    }

    public static String replaceBraces(String line) {
        line = line.replace(" ", "");

        if (line.charAt(0) == '+') {
            line = line.substring(1);
        }
        if (line.charAt(0) == '-') {
            int index = 1;
            StringBuilder prefix = new StringBuilder();
            prefix.append("-");
            while (Character.isDigit(line.charAt(index)) && line.charAt(index + 1) != '-') {

                prefix.append(line.charAt(index));
                index++;
            }
            line = line.replace(prefix.toString(), "");
            line = new StringBuilder(line).append(prefix).toString();
            line = line.replace(" ", "");
            if (line.charAt(0) == '+') {
                line = line.substring(1);
            }
        }

        String[] splittedByBraces = line.split("[()]");
        for (int i = 0; i < splittedByBraces.length; i++) {
            if (splittedByBraces[i].contains("--")) {
                splittedByBraces[i] = splittedByBraces[i].replace("--", "+");
            }

            if (splittedByBraces[i].contains("+-")) {
                splittedByBraces[i] = splittedByBraces[i].replace("+-", "-");
            }

            if (splittedByBraces[i].contains("[-+*/]")) {

                splittedByBraces[i] = String.valueOf(calculate(splittedByBraces[i]));
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String s : splittedByBraces) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static float calculate(String line) {
        List<Float> numbers = getNumbersFromLine(line);
        List<String> operations = getOperationsFromLine(line);
        return getResult(numbers, operations);
    }

    public boolean isValidExpression(String line) {
        if (line == null || line.equals("")) {
            return false;
        }
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) < 40 || line.charAt(i) > 57) {
                return false;
            }

        }
        return true;
    }

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }
}
