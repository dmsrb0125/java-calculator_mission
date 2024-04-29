import java.util.ArrayList;

public class Calculator {

    // 컬렉션 필드
    static ArrayList<Double> resultArray = new ArrayList<>();

    // 필드
    int num1;
    int num2;
    char operator;
    double result;

    // 생성자 함수
    public Calculator(int firstNumber, int secondNumber, char applyOperator) throws InvalidCalculationException {
        num1 = firstNumber;
        num2 = secondNumber;
        operator = applyOperator;
        result = calculate();
        resultArray.add(result);
    }

    // 연산에 대한 결과를 반환하는 내부 메서드
    private double calculate() throws InvalidCalculationException{
        switch (this.operator) {
            case '+':
                return this.num1 + this.num2;
            case '-':
                return this.num1 - this.num2;
            case '*':
                return this.num1 * this.num2;
            case '/':
                if (this.num2 == 0) {
                    throw new InvalidCalculationException("나눗셈 연산에서 분모(두번째 정수)에 0을 사용할 수 없습니다.");
                }
                return (double) this.num1 / this.num2;
            default:
                throw new InvalidCalculationException("지원되지 않는 연산자 입니다: " + this.operator);
        }
    }
}
