package validation;

import java.util.Scanner;

public class InputValidator {

    public static int getValidSelection(Scanner scanner, String prompt) {
        while (true) {
            System.out.print("산수연산을 계산하려면: \"1\", 원의 넓이를 계산하려면: \"2\" 을 입력해주세요: ");
            if (scanner.hasNextInt()) {
                int selection = scanner.nextInt();
                scanner.nextLine(); // 개행문자 처리
                if (selection == 1 || selection == 2) {
                    return selection;
                } else {
                    System.out.println("잘못된 입력입니다. 1 또는 2만 입력 가능합니다.");
                }
            } else {
                System.out.println("숫자를 입력해야 합니다. 1 또는 2를 입력하세요.");
                scanner.nextLine(); // 잘못된 입력을 비우기
            }
        }
    }

    public static double getDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("입력이 없습니다.");
                continue;
            }
            try {
                double number = Double.parseDouble(input);
                return number; // 모든 실수 입력을 받아들임
            } catch (NumberFormatException e) {
                System.out.println("실수 형태로 입력해주세요.");
            }
        }
    }

    public static char isValidOperator(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.length() == 1 && "+-*/%".indexOf(input.charAt(0)) != -1) {
                return input.charAt(0);
            }
            System.out.println("보기에 연산만 입력 가능합니다.");
        }
    }

    public static double getPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("입력이 없습니다.");
                continue;
            }
            try {
                double radius = Double.parseDouble(input);
                if (radius <= 0) {
                    System.out.println("양의 실수만 입력 가능합니다.");
                    continue;
                }
                return radius;
            } catch (NumberFormatException e) {
                System.out.println("실수 형태로 입력해주세요.");
            }
        }
    }
}
