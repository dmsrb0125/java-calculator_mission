import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] resultArray =  new double[10]; // 연산 결과 10개를 저장할 수 있는 배열 선언 및 생성
        int count =0; // 연산의 결과를 비어있는 곳에 저장하기 위해 저장할 때마다 count 합니다.
        while (true){
            // getNonNegativeInteger를 통해 Scanner를 사용하여 사용자로부터 첫번째, 두번째 입력을 받고 입력값 유효성 검사 실시
            int firstNumber = getNonNegativeInteger(scanner, "첫 번째 숫자를 입력해주세요(양의 정수 또는 0만 입력 가능합니다): ");
            int secondNumber = getNonNegativeInteger(scanner, "두 번째 숫자를 입력해주세요(양의 정수 또는 0만 입력 가능합니다): ");

            // isValidOperator를 통해 Scanner를 사용하여 사용자로부터 세번째 입력을 받고 입력값 유효성검사 실시
            char applyOperator = isValidOperator(scanner, "사칙연산 기호를 입력하세요(+, -, *, /):");
            double result = calculate(firstNumber,secondNumber,applyOperator);
            System.out.println("결과: " + result);

            // exit 입력 시 종료, 다른입력시 계산 무한 반복진행
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료), 다른키 누를시 계산 진행");
            String continueInput= scanner.nextLine();
            if ("exit".equals(continueInput)) {
                break;
            }
            resultArray[count] = result;
            count += 1;
        }
        scanner.close();


    }

    // 피연산자 입력값 유효성검사후 반환하는 메서드
    private static int getNonNegativeInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            // 입력값이 없을 때 입력 다시받기
            if (input.isEmpty()) {
                System.out.println("입력이 없습니다.");
                continue;
            }

            try {
                int number = Integer.parseInt(input);

                // 음수일 때 입력 다시받기
                if (number < 0) {
                    System.out.println("양의 정수 또는 0만 입력 가능합니다.");
                    continue;
                }

                // 양의 정수 또는 0일 경우 반복문 탈출
                return number;
            } catch (NumberFormatException e) {
                System.out.println("정수 형태로 입력해주세요");
            }
        }
    }

    // 연산자 입력값 유효성검사후 반환하는 메서드
    public static char isValidOperator(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty() && input.length() == 1 && "+-*/".indexOf(input.charAt(0)) != -1) {
                return input.charAt(0);  // 유효한 연산자가 입력된 경우, 해당 연산자 반환
            }
            System.out.println("사칙연산자만 입력 가능합니다");
        }
    }

    // 연산에대한 결과를 반환하는 메서드
    public static double calculate(int num1, int num2, char operator){
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    return Double.NaN;
                }
                return (double) num1 / num2;
            default:
                System.out.println("지원되지 않는 연산자입니다.");
                return Double.NaN;
        }
    }



}
