import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Scanner를 사용하여 사용자로부터 첫번째 입력 받기
        System.out.print("첫 번째 숫자를 입력해주세요(양의 정수 또는 0만 입력 가능합니다): ");
        int firstNumber = scanner.nextInt();

        // 음수 입력을 확인하고 재요청
        while (firstNumber < 0) {
            System.out.println("양의 정수 또는 0만 입력 가능합니다. 다시 입력해주세요:");
            firstNumber = scanner.nextInt();
        }

        // Scanner를 사용하여 사용자로부터 두번째 입력 받기
        System.out.print("두 번째 숫자를 입력해주세요(양의 정수 또는 0만 입력 가능합니다) ");
        int secondNumber = scanner.nextInt();

        // 음수 입력을 확인하고 재요청
        while (secondNumber < 0) {
            System.out.println("양의 정수 또는 0만 입력 가능합니다. 다시 입력해주세요:");
            secondNumber= scanner.nextInt();
        }

    }
}