package calculator;

import validation.InvalidCalculationException;


import java.util.ArrayList;


public abstract class Calculator<T extends Number> {


    // 각 연산을 처리하는 메서드를 직접 Operator enum을 사용하여 정의합니다.
    // 매개변수 확장
    public double add(T num1, T num2) {
        return Operator.ADD.apply(num1.doubleValue(), num2.doubleValue());
    }

    public double subtract(T num1, T num2) {
        return Operator.SUBTRACT.apply(num1.doubleValue(), num2.doubleValue());
    }

    public double multiply(T num1, T num2) {
        return Operator.MULTIPLY.apply(num1.doubleValue(), num2.doubleValue());
    }

    public double divide(T num1, T num2) {
        if (num2.doubleValue() == 0) {
            throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 숫자)에 0을 사용할 수 없습니다.");
        }
        return Operator.DIVIDE.apply(num1.doubleValue(), num2.doubleValue());
    }

    public double mod(T num1, T num2) {
        return Operator.MODULO.apply(num1.doubleValue(), num2.doubleValue());
    }

    // 추상 메서드, 각 하위 클래스에서 구현할 메서드
    public abstract double calculate() throws InvalidCalculationException;
    public abstract ArrayList<Double> getResultArray();
    public abstract void addResult(double result);
    public abstract void removeResult();
    public abstract void inquiryResult();
}