import java.util.ArrayList;

public class Calculator {

    private static ArrayList<Double> arithmeticResultArray; // 사칙연산 컬렉션 필드
    private static ArrayList<Double> circleResultArray; // 원의 넓이 컬렉션 필드
    private static final double PI = 3.14; // 원주율은 고정값이니 상수로서언하고 static으로 선언함으로써, 프로그램의 어떤 부분에서든 접근할 수 있는 하나의 공유된 원주율 값만이 메모리에 저장되므로, 각 인스턴스마다 원주율 값을 별도로 저장할 필요가 없게 되어 메모리 효율을 증가시킬수있다
    private int num1; // 첫번째 입력값
    private int num2; // 두번째 입력값
    private char operator; // 연산자
    private  double radius; // 원의 반지름

    // 생성자에서  배열 초기화
    public Calculator() {
        arithmeticResultArray = new ArrayList<>();
        circleResultArray = new ArrayList<>();
    }

    // 사칙연산 Setter 메서드
    public void setArithmetic(int firstNumber, int secondNumber, char applyOperator)  {
        num1 = firstNumber;
        num2 = secondNumber;
        operator = applyOperator;
    }
    // 원의넓이 Setter 메서드
    public void setCircle(double circleRadius)  {
        radius = circleRadius;
    }


    // 사칙연산에 대한 결과를 반환하는 메서드
    public double arithmeticCalculate() throws InvalidCalculationException{
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new InvalidCalculationException("나눗셈 연산에서 분모(두번째 정수)에 0을 사용할 수 없습니다.");
                }
                return (double) num1 / num2;
            default:
                throw new InvalidCalculationException("지원되지 않는 연산자 입니다: " + operator);
        }
    }

    // 사칙연산 저장값 Getter 메서드
    public static ArrayList<Double> arithmeticGetResultArray() {
        return arithmeticResultArray;
    }

    // 사칙연산 결과값 리스트에 저장하는 메서드
    public  void arithmeticAddResultArray(double result) {
        arithmeticResultArray.add(result);
    }

    // 사칙연산 결과 저장 리스트에서 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드
    public void arithmeticRemoveResultArray() {
        arithmeticResultArray.remove(0);
    }

    // 사칙연산 결과 저장 리스트에 저장된 연산 결과들을 조회하는 기능을 가진 메서드
    public void arithmeticInquiryResultArray(){
        for(double i: arithmeticResultArray){
            System.out.println(i);
        }
    }


    // 원의 넓이를 구하는 메서드
    public double circleCalculate() {
        return PI * radius * radius;
    }

    // 원의 넓이 저장값 Getter 메서드
    public static ArrayList<Double> circleGetResultArray() {
        return circleResultArray;
    }

    // 원의 넓이 결과값 리스트에 저장하는 메서드
    public  void circleAddResultArray(double result) {
        circleResultArray.add(result);
    }


    // 원의 넓이 결과 저장 리스트에서 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드
    public void circleRemoveResultArray(){
        circleResultArray.remove(0);
    }

    // 원의 넓이 결과 저장 리스트에 저장된 연산 결과들을 조회하는 기능을 가진 메서드
    public void circleInquiryResultArray(){
        for(double i: circleResultArray){
            System.out.println(i);
        }
    }

}
