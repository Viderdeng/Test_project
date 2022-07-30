package Calculator;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int output;

    public static void main(String[] args) {
        System.out.println("Введите выражение:");
        String input = scanner.nextLine();
        char[] userInput = new char[20];

        for (int i = 0; i < input.length(); i++) {
            userInput[i] = input.charAt(i);
            if (userInput[i] =='+') {
                operation = '+';
            }
            if (userInput[i] =='-') {
                operation = '-';
            }
            if (userInput[i] =='*') {
                operation = '*';
            }
            if (userInput[i] =='/') {
                operation = '/';
            }
        }
        String userInputString = String.valueOf(userInput);
        String[] blacks = userInputString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        number1 = romanToNumber(stable00);
        number2 = romanToNumber(string03);

        if (number1 < 0 && number2 < 0) {
            output = 0;
        } else {
            output = calculated(number1, number2, operation);
            System.out.println("Вывод для римских цифр");
            String resultRoman = convertArabToRomanian(output);
            System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
        }
        number1 = Integer.parseInt(stable00);
        number2 = Integer.parseInt(string03);
        output = calculated(number1, number2, operation);
        System.out.println("Вывод:");
        System.out.println(number1 + " " + operation + " " + number2 + " = " + output);
    }


    private static String convertArabToRomanian(int numArabian) {
        String[] romanian = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"
        };
        final String s = romanian[numArabian];
        return s;
    }
    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Ошибка, неверный формат!");
        }
        return -1;
    }
    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Исключение : " + e);
                    System.out.println("Разрешены только целые числа");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }
        return result;
    }
}
