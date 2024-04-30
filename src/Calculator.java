import java.util.ArrayList;

public class Calculator {

    // 컬렉션 필드
    private static ArrayList<Double> resultArray = new ArrayList<>();

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

    // Getter 메서드
    public static ArrayList<Double> getResultArray() {
        return resultArray;
    }

    // 결과값 리스트에 저장하는 Setter 메서드
    public  void addResultArray(double result) {
        resultArray.add(result);
    }

    // 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드
    public  void removeResultArray() {
        resultArray.remove(0);
    }


}
