package calculator;

import validation.InvalidCalculationException;

import java.util.ArrayList;

public class ArithmeticCalculator<T extends Number> extends Calculator<T> {
    // 필드
    private ArrayList<Double> resultArray;
    private T num1;
    private T num2;
    private Operator operator;  // 타입을 Operator 이넘으로 선언

    // 생성자
    public ArithmeticCalculator() {
        this.resultArray = new ArrayList<>();
    }


    // 세터
    public void setValues(T firstNumber, T secondNumber, char applyOperator) {
        num1 = firstNumber;
        num2 = secondNumber;
        operator = Operator.fromChar(applyOperator);
    }


    // 산수연산 계산 메서드
    @Override
    public double calculate() throws InvalidCalculationException {
        return operator.apply(num1, num2);
    }

    // 게터
    @Override
    public ArrayList<Double> getResultArray() {
        return resultArray;
    }

    // 결과값 리스트에 저장하는 메서드
    @Override
    public void addResult(double result) {
        resultArray.add(result);
    }

    // 저장 리스트에서 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드
    @Override
    public void removeResult() {
        if (!resultArray.isEmpty()) {
            resultArray.remove(0);
        }
    }

    // 저장 리스트에 저장된 연산 결과들을 조회하는 기능을 가진 메서드
    @Override
    public void inquiryResult() {
        for (double result : resultArray) {
            System.out.println(result);
        }
    }
    // 저장된 결과 중 사용자가 지정한 값보다 큰 결과를 조회
    public void printResultsGreaterThan(double threshold) {
        resultArray.stream()
                .filter(result -> result > threshold)
                .forEach(System.out::println);
    }
}