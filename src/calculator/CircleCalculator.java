package calculator;

import java.util.ArrayList;
import validation.InvalidCalculationException;
public class CircleCalculator extends Calculator {

    //필드
    private ArrayList<Double> resultArray;
    private static final double PI = 3.14;
    private double radius;

    // 생성자
    public CircleCalculator() {

        resultArray = new ArrayList<>();
    }

    // 세터
    public void setRadius(double circleRadius ) {
        radius = circleRadius ;
    }

    // 원의 넓이 계산 메서드
    @Override
    public double calculate() throws InvalidCalculationException {
        if (radius <= 0) {
            throw new InvalidCalculationException("반지름은 양수만 입력 할 수 있습니다");
        }
        return Math.PI * radius * radius; // 원의 넓이 계산
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
