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

    public double apply(int num1, int num2) {
        switch (this) {
            case ADD:
                return num1 + num2;
            case SUBTRACT:
                return num1 - num2;
            case MULTIPLY:
                return num1 * num2;
            case DIVIDE:
                if (num2 == 0) throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0을 사용할 수 없습니다.");
                return num1 / (double) num2;
            case MODULO:
                return num1 % num2;
            default:
                throw new IllegalArgumentException("지원되지 않는 연산자 입니다:" + this.symbol);
        }
    }
}
