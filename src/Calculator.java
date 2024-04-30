import java.util.ArrayList;

public abstract class Calculator {

    // 추상 메서드로 메서드 정의
    public abstract double calculate() throws InvalidCalculationException;
    public abstract  ArrayList<Double> getResultArray();

    public abstract void addResult(double result);
    public abstract void removeResult();
    public abstract  void inquiryResult();


}
