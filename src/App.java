import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Scanner를 사용하여 사용자로부터 첫번째, 두번째 입력을 받고 입력값을  getNonNegativeIntege를 통해 유효성검사 실시
        int firstNumber = getNonNegativeInteger(scanner, "첫 번째 숫자를 입력해주세요(양의 정수 또는 0만 입력 가능합니다): ");
        int secondNumber = getNonNegativeInteger(scanner, "두 번째 숫자를 입력해주세요(양의 정수 또는 0만 입력 가능합니다): ");
        scanner.close();
    }

    // 음수 입력을 확인하는 메서드
    private static int getNonNegativeInteger(Scanner scanner, String prompt) {
        System.out.print(prompt);
        int number = scanner.nextInt();
        while (number < 0) {
            System.out.print("양의 정수 또는 0만 입력 가능합니다. 다시 입력해주세요:");
            number = scanner.nextInt();
        }
        return number;
    }
}