package calculator;

// 이넘 타입형식

public enum Operator {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MODULO('%');

    private final char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public static Operator fromChar(char op) {
        for (Operator operator : Operator.values()) {
            if (operator.symbol == op) {
                return operator;
            }
        }
        throw new IllegalArgumentException("지원되지 않는 연산자 입니다:" + op);
    }


    // enum에 제네닉사용이 불가하므로 슈퍼클래스사용
    public double apply(Number num1, Number num2) {
        double dNum1 = num1.doubleValue();
        double dNum2 = num2.doubleValue();

        switch (this) {
            case ADD:
                return dNum1 + dNum2;
            case SUBTRACT:
                return dNum1 - dNum2;
            case MULTIPLY:
                return dNum1 * dNum2;
            case DIVIDE:
                if (dNum2 == 0) throw new ArithmeticException("나눗셈 연산에서 분모(두번째 수)에 0을 사용할 수 없습니다.");
                return dNum1 / dNum2;
            case MODULO:
                return dNum1 % dNum2;
            default:
                throw new IllegalArgumentException("지원되지 않는 연산자 입니다:" + this.symbol);
        }
    }
}
