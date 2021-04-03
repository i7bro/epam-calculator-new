package ru.semibratov;

import java.util.Scanner;

public class ConsoleRW {

    public String read(Scanner input) {
        String rawExpression;
        while (true) {
            try {
                System.out.print("Введите выражение: ");
                rawExpression = input.nextLine();
                Validation.rawExpressionValidation(rawExpression);
                break;
            } catch (Exception e) {
                System.out.println("ВНИМАНИЕ! " + e.getMessage() + "!");
            }
        }
        return rawExpression;
    }

    public boolean write(String value) {
        if (value != null) {
            System.out.println("Ответ: " + value);
            return true;
        }
        return false;
    }

}
