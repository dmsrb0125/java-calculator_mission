import java.util.ArrayList;

public class ArithmeticCalculator extends Calculator {

    // 필드
    private ArrayList<Double> resultArray;
    private int num1;
    private int num2;
    private char operator;

    // 생성자
    public ArithmeticCalculator() {
        this.resultArray = new ArrayList<>();
    }

    // 세터
    public void setValues(int firstNumber, int secondNumber, char applyOperator) {
        this.num1 = firstNumber;
        this.num2 = secondNumber;
        this.operator = applyOperator;
    }



    // 사칙연산 계산 메서드
    @Override
    public double calculate() throws InvalidCalculationException {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new InvalidCalculationException("Division by zero is not allowed.");
                }
                return (double) num1 / num2;
            default:
                throw new InvalidCalculationException("Unsupported operator: " + operator);
        }
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
}
