import java.util.ArrayList;

public class Calculator {

    // 컬렉션 필드
   static ArrayList<Double> resultArray = new ArrayList<>();

    // 연산에 대한 결과를 반환하는  메서드
    public double calculate(int num1, int num2, char operator) throws InvalidCalculationException{
        switch (operator) {
            case '+':
                return num1 +num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new InvalidCalculationException("나눗셈 연산에서 분모(두번째 정수)에 0을 사용할 수 없습니다.");
                }
                return (double) num1 /num2;
            default:
                throw new InvalidCalculationException("지원되지 않는 연산자 입니다: " + operator);
        }
    }


}
