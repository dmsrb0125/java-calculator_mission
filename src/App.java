import calculator.ArithmeticCalculator;
import calculator.Calculator;
import calculator.CircleCalculator;
import validation.InputValidator;
import validation.InvalidCalculationException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();

        while (true) {
            int select = InputValidator.getValidSelection(scanner, "산수연산을 계산하려면: \"1\", 원의 넓이를 계산하려면: \"2\" 을 입력해주세요: ");

            if (select == 1) {
                performCalculation(scanner, arithmeticCalculator);
            } else if (select == 2) {
                performCalculation(scanner, circleCalculator);
            }

            if (!continueCalculating(scanner)) break;
        }
        scanner.close();
    }

    // 선택된 계산기 유형에 따라 적절한 계산을 수행하고 결과를 관리하는 메서드.
    private static void performCalculation(Scanner scanner, Calculator calculator) {
        if (calculator instanceof ArithmeticCalculator) {
            double firstNumber = InputValidator.getDouble(scanner, "첫 번째 숫자를 입력해주세요: ");
            double secondNumber = InputValidator.getDouble(scanner, "두 번째 숫자를 입력해주세요: ");
            char applyOperator = InputValidator.isValidOperator(scanner, "연산 기호를 입력하세요(+, -, *, /, %):");
            ((ArithmeticCalculator) calculator).setValues(firstNumber, secondNumber, applyOperator);
        } else if (calculator instanceof CircleCalculator) {
            double circleRadius = InputValidator.getPositiveDouble(scanner, "반지름을 입력하세요(cm): ");
            ((CircleCalculator) calculator).setRadius(circleRadius);
        }

        try {
            double result = calculator.calculate();
            System.out.printf("결과: %.2f\n", result);
            calculator.addResult(result);
        } catch (InvalidCalculationException e) {
            System.out.println("올바르지 않은 계산이 발생했습니다: " + e.getMessage());
        }

        manageResults(scanner, calculator);
    }

    // 추가로직 메서드로 분리
    private static void manageResults(Scanner scanner, Calculator calculator) {
        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제 / 다른키 누를시 넘어감)");
        if ("remove".equals(scanner.nextLine())) {
            calculator.removeResult();
        }

        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회 / 다른키 누를시 넘어감)");
        if ("inquiry".equals(scanner.nextLine())) {
            calculator.inquiryResult();
        }
    }

    // 계산 진행 여부확인 메서드로 분리
    private static boolean continueCalculating(Scanner scanner) {
        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료 / 다른키 누를시 다음 계산 진행)");
        String continueInput = scanner.nextLine();
        return !"exit".equals(continueInput);
    }
}
