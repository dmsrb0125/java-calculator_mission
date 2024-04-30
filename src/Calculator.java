import java.util.ArrayList;

public class Calculator {

    private ArrayList<Double> resultArray; // 결과를 저장할 컬렉션 필드
    private int num1;
    private int num2;
    private char operator;

    // 생성자에서  배열 초기화
    public Calculator() {
        resultArray = new ArrayList<>();
    }


    // 계산 수행 메서드
    public double calculate() throws InvalidCalculationException {
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

    // Setter 메서드 -> 객체생성을 반복문 밖에 하였고 해당 입력은 반복로직을 통해 입력을 받기때문에 초기 생성자 초기화가아닌 세터를 통한 초기화 사용
    public void setValues(int firstNumber, int secondNumber, char applyOperator)  {
        num1 = firstNumber;
        num2 = secondNumber;
        operator = applyOperator;
    }


    // Getter 메서드
    public ArrayList<Double> getResultArray() {
        return resultArray;
    }

    // 결과값 리스트에 저장하는 메서드
    public void addResultArray(double result) {
        resultArray.add(result);
    }

    // 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드
    public void removeResultArray() {
        resultArray.remove(0);
    }

    //저장된 연산 결과들을 조회하는 기능을 가진 메서드
    public void inquiryResultArray(){
        for(double i: resultArray){
            System.out.println(i);
        }
    }

}
