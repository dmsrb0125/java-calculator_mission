package calculator;

import validation.InvalidCalculationException;


import java.util.ArrayList;


public abstract class Calculator {


    // 각 연산을 처리하는 메서드를 직접 Operator enum을 사용하여 정의합니다.
    public double add(int num1, int num2) {
        return Operator.ADD.apply(num1, num2);
    }

    public double subtract(int num1, int num2) {
        return Operator.SUBTRACT.apply(num1, num2);
    }

    public double multiply(int num1, int num2) {
        return Operator.MULTIPLY.apply(num1, num2);
    }

    public double divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0을 사용할 수 없습니다.");
        }
        return Operator.DIVIDE.apply(num1, num2);
    }

    public double mod(int num1, int num2) {
        return Operator.MODULO.apply(num1, num2);
    }

    // 추상 메서드, 각 하위 클래스에서 구현할 메서드
    public abstract double calculate() throws InvalidCalculationException;
    public abstract ArrayList<Double> getResultArray();
    public abstract void addResult(double result);
    public abstract void removeResult();
    public abstract void inquiryResult();
}