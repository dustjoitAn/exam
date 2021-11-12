package calculator;

import java.util.List;

public class Calculator {

    private int numberOfDigits;

    private String model;

    private List<Integer> numbers;

    private List<String> operations;

    public Calculator() {}

    public Calculator(int numberOfDigits, String model, List<Integer> numbers, List<String> operations) {
        this.numberOfDigits = numberOfDigits;
        this.model = model;
        this.numbers = numbers;
        this.operations = operations;
    }

    public int getNumberOfDigits() {
        return numberOfDigits;
    }

    public void setNumberOfDigits(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<String> getOperations() {
        return operations;
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }
}
