package operator;

public class DivideOperator implements Operator {
    public double operate(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return (double) num1 / num2;
    }
}