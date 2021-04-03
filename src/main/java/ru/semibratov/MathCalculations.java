package ru.semibratov;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MathCalculations {

    public static String getMath(List<String> RPNExpression) {

        Deque<BigDecimal> stack = new ArrayDeque<>();

        for (String s : RPNExpression) {
            if (!s.matches("[/*\\-+^]")) {
                stack.addFirst(new BigDecimal(s));
                continue;
            }
            BigDecimal bdLast = stack.pop();
            BigDecimal bdBeforeLast = stack.poll();

            switch (s) {
                case "*":
                    stack.push(bdBeforeLast.multiply(bdLast));
                    break;
                case "/":
                    stack.push(bdBeforeLast.divide(bdLast));
                    break;
                case "-":
                    stack.push(bdBeforeLast.subtract(bdLast));
                    break;
                case "+":
                    stack.push(bdBeforeLast.add(bdLast));
                    break;
                case "^":
                stack.push(bdBeforeLast.pow(bdBeforeLast.intValue()));
                break;
            }
        }

        return stack.pop().toString();
    }
}
