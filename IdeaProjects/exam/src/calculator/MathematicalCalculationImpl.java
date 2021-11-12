package calculator;

public class MathematicalCalculationImpl implements MathematicalCalculation {

    @Override
    public float calculate(float firstNumber, float secondNumber, String operation) {
        switch (operation) {
            case "+":
                return add(firstNumber, secondNumber);
            case "-":
                return subtract(firstNumber, secondNumber);
            case "*":
                return multiply(firstNumber, secondNumber);
            case "/":
                return divide(firstNumber, secondNumber);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public float add(float firstNumber, float secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public float subtract(float firstNumber, float secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public float multiply(float firstNumber, float secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public float divide(float firstNumber, float secondNumber) {
        return firstNumber / secondNumber;
    }
}
