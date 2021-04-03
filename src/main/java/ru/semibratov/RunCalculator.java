package ru.semibratov;

import java.util.List;
import java.util.Scanner;

public class RunCalculator {

    public static void run() {
        ConsoleRW consoleRW = new ConsoleRW();
        String expression = consoleRW.read(new Scanner(System.in));
        List<String> RPNExpression = ParsingExpression.parsToRPN(ParsingExpression.parsToList(expression));
        String answer = MathCalculations.getMath(RPNExpression);
        consoleRW.write(answer);
    }
}
