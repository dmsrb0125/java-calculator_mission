import java.util.ArrayList;

public abstract class Calculator {

    // Calculator 클래스에 사칙연산 클래스들을 어떻게 활용
    protected Operator addOperator;
    protected Operator subtractOperator;
    protected Operator multiplyOperator;
    protected Operator divideOperator;

    // 생성자함수에서 사칙연산 클래스들을 초기화
    public Calculator() {
        this.addOperator = new AddOperator();
        this.subtractOperator = new SubtractOperator();
        this.multiplyOperator = new MultiplyOperator();
        this.divideOperator = new DivideOperator();
    }

    public double add(int num1, int num2) {
        return addOperator.operate(num1, num2);
    }

    public double subtract(int num1, int num2) {
        return subtractOperator.operate(num1, num2);
    }

    public double multiply(int num1, int num2) {
        return multiplyOperator.operate(num1, num2);
    }

    public double divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0을 사용할 수 없습니다.");
        }
        return divideOperator.operate(num1, num2);
    }

    // 추상 메서드, 각 하위 클래스에서 구현할 메서드
    public abstract double calculate() throws InvalidCalculationException;
    public abstract ArrayList<Double> getResultArray();
    public abstract void addResult(double result);
    public abstract void removeResult();
    public abstract void inquiryResult();
}
