import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){

            // 계산 선택 로직
            int select = getValidSelection(scanner, "사칙연산을 계산하려면: \"1\", 원의 넓이를 계산하려면: \"2\" 을 입력해주세요: ");

            if(select==1){
                // 사칙연산 계산 로직

                // getNonNegativeInteger를 통해 Scanner를 사용하여 사용자로부터 첫번째, 두번째 입력을 받고 입력값 유효성 검사 실시
                int firstNumber = getNonNegativeInteger(scanner, "첫 번째 숫자를 입력해주세요(양의 정수 또는 0만 입력 가능합니다): ");
                int secondNumber = getNonNegativeInteger(scanner, "두 번째 숫자를 입력해주세요(양의 정수 또는 0만 입력 가능합니다): ");

                // isValidOperator를 통해 Scanner를 사용하여 사용자로부터 세번째 입력을 받고 입력값 유효성검사 실시
                char applyOperator = isValidOperator(scanner, "사칙연산 기호를 입력하세요(+, -, *, /):");


                // Calculator 클래스 활용
                Calculator calculator = null;
                try {
                    calculator = new Calculator(firstNumber,secondNumber,applyOperator);
                } catch (InvalidCalculationException e) {
                    System.out.println("올바르지 않은 계산이 발생했습니다: " + e.getMessage());
                }
                double result = 0;
                try {
                    result = calculator.arithmeticCalculate();
                } catch (InvalidCalculationException e) {
                    System.out.println("올바르지 않은 계산이 발생했습니다: " + e.getMessage());
                }
                System.out.println("결과: " + result);
                calculator.arithmeticAddResultArray(result);

                // remove 입력시  가장 먼저 저장된 결과가 삭제, 다른입력시 넘어감
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제 / 다른키 누를시 넘어감)");
                String removeInput= scanner.nextLine();
                if ("remove".equals(removeInput)) {
                    calculator.arithmeticRemoveResultArray();
                }


                // inquiry 입력시 저장된 연산 결과 전부를 출력, 다른입력시 넘어감
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회 / 다른키 누를시 넘어감)");
                String getInput= scanner.nextLine();
                if ("inquiry".equals(getInput)) {
                    calculator.arithmeticInquiryResultArray();
                }
            }else{
                // 원의 넓이 계산 로직
                double circleRadius =  getPositiveDouble(scanner, "반지름을 입력하세요(cm): ");

                // Calculator 클래스 활용
                Calculator calculator = new Calculator(circleRadius);
                double result = calculator.circleCalculate();
                System.out.println("결과: " + result + "cm");
                calculator.circleAddResultArray(result);


                // remove 입력시  가장 먼저 저장된 결과가 삭제, 다른입력시 넘어감
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제 / 다른키 누를시 넘어감)");
                String removeInput= scanner.nextLine();
                if ("remove".equals(removeInput)) {
                    calculator.circleRemoveResultArray();
                }


                // inquiry 입력시 저장된 연산 결과 전부를 출력, 다른입력시 넘어감
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회 / 다른키 누를시 넘어감)");
                String getInput= scanner.nextLine();
                if ("inquiry".equals(getInput)) {
                    calculator.circleInquiryResultArray();
                }
            }



            // exit 입력 시 종료, 다른입력시 계산 무한 반복진행
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료 /  다른키 누를시 다음 계산 진행)");
            String continueInput= scanner.nextLine();
            if ("exit".equals(continueInput)) {
                break;
            }

        }
        scanner.close();

    }

    // 선택 입력값 유효성 검사 후 반환하는 메서드
    private static int getValidSelection(Scanner scanner, String prompt) {
        int selection;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                selection = scanner.nextInt();
                scanner.nextLine(); // 개행문자 처리
                if (selection == 1 || selection == 2) {
                    return selection;
                } else {
                    System.out.println("잘못된 입력입니다. 1 또는 2만 입력 가능합니다.");
                }
            } else {
                System.out.println("숫자를 입력해야 합니다. 1 또는 2를 입력하세요.");
                scanner.next(); // 잘못된 입력을 비우기
            }
        }
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

    // 연산자 입력값 유효성 검사후 반환하는 메서드
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

    // 반지름 입력값 유효성 검사후 반환하는 메서드
    private static double getPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();  // 입력값 앞뒤 공백 제거

            // 입력값이 없을 때 입력 다시 받기
            if (input.isEmpty()) {
                System.out.println("입력이 없습니다.");
                continue;
            }

            try {
                double radius = Double.parseDouble(input);

                // 음수일 때 입력 다시 받기
                if (radius <= 0) {
                    System.out.println("양의 실수만 입력 가능합니다.");
                    continue;
                }

                // 양의 실수일 경우 반복문 탈출
                return radius;
            } catch (NumberFormatException e) {
                System.out.println("실수 형태로 입력해주세요.");
            }
        }
    }



}