package calculator;

import java.io.*;
import java.util.List;

public class CalculationProcess {

    private static FileManager fileManager = FileManager.getInstance();

    public static void main(String[] args) {
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        // Read the content from file
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace(" ", "");
                if (fileManager.isValidExpression(line)) {

                    line = FileManager.replaceBraces(line);

                    List<String> operations = fileManager.getOperationsFromLine(line);
                    float result;
                    if (!operations.isEmpty()) {

                        List<Float> numbers = fileManager.getNumbersFromLine(line);
                        result = fileManager.getResult(numbers, operations);
                        appendStrToFile(outputFile, result + "\n");
                    } else {
                        result = Float.parseFloat(line);
                        appendStrToFile(outputFile, result + "\n");
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void appendStrToFile(File file, String str) {
        try {

            // Open given file in append mode by creating an
            // object of BufferedWriter class
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(file, true));

            // Writing on output stream
            out.write(str);
            // Closing the connection
            out.close();
        }

        // Catch block to handle the exceptions
        catch (IOException e) {

            // Display message when exception occurs
            System.out.println("exception occoured" + e);
        }
    }

}
