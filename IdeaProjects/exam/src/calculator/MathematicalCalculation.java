package calculator;

public interface MathematicalCalculation {

    float calculate(float firstNumber, float secondNumber, String operation);

    float add(float firstNumber, float secondNumber);

    float subtract(float firstNumber, float secondNumber);

    float multiply(float firstNumber, float secondNumber);

    float divide(float firstNumber, float secondNumber);
}
