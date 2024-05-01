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

        }
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

    // 추가로직 메서드로 통합 분리
    private static void manageResults(Scanner scanner, Calculator calculator) {
        while (true) {
            if (calculator instanceof ArithmeticCalculator) {
                System.out.println("로직이 완료되었습니다. 저장된 값 관리 또는 계산을 종료 시킬 수 있습니다:(다른키 누를시 계산 재실행)");
                System.out.println("  'inquiry' - 모든 결과 조회");
                System.out.println("  'bigger'  - 지정된 값 이상의 결과 조회");
                System.out.println("  'remove'  - 가장 오래된 결과 삭제");
                System.out.println("  'exit'  - 계산 종료");
            } else if (calculator instanceof CircleCalculator) {
                System.out.println("로직이 완료되었습니다. 저장된 값 관리 또는 계산을 종료 시킬 수 있습니다:(다른키 누를시 계산 재실행)");
                System.out.println("  'inquiry' - 모든 결과 조회");
                System.out.println("  'remove'  - 가장 오래된 결과 삭제");
                System.out.println("  'exit'  - 계산 종료");
            }


            String action = scanner.nextLine().trim().toLowerCase();

            switch (action) {
                case "remove":
                    calculator.removeResult();
                    System.out.println("결과가 삭제되었습니다.");
                    break;  // 작업 수행 후 다시 메뉴로
                case "inquiry":
                    calculator.inquiryResult();
                    break;  // 작업 수행 후 다시 메뉴로
                case "bigger":
                    if (calculator instanceof ArithmeticCalculator) {
                        System.out.print("기준 값 입력: ");
                        double threshold = scanner.nextDouble();
                        scanner.nextLine();  // 개행문자 처리
                        ((ArithmeticCalculator) calculator).printResultsGreaterThan(threshold);
                    } else {
                        System.out.println("이 기능은 산술 연산기에서만 사용 가능합니다.");
                    }
                    break;  // 작업 수행 후 다시 메뉴로
                case "exit":
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    System.exit(0);
                default:
                    return;
            }
        }
    }


}
