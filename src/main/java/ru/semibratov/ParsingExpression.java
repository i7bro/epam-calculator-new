package ru.semibratov;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParsingExpression {

    public static List<String> parsToList(String expression) {
        StringBuilder sb = new StringBuilder();
        List<String> strings = new ArrayList<>();
        String currentString = "";
        boolean wasOpenBrace = false;

        for (int i = 0; i < expression.length(); i++) {
            currentString = String.valueOf(expression.charAt(i));

            if (currentString.equals(" ")) continue;

            if (currentString.equals("(") && String.valueOf(expression.charAt(i + 1)).equals("-")) {
                sb.append("-");
                wasOpenBrace = true;
                ++i;
            } else if (currentString.matches("[0-9.]")) {
                sb.append(currentString);
            } else if (currentString.equals(")") && wasOpenBrace) {
                strings.add(sb.toString());
                sb.delete(0, sb.length());
                wasOpenBrace = false;
            } else {
                if (sb.length() != 0) {
                    strings.add(sb.toString());
                    sb.delete(0, sb.length());
                }
                strings.add(currentString);
            }
        }
        if (sb.length() != 0) {
            strings.add(sb.toString());
        }

        return strings;
    }

    public static List<String> parsToRPN(List<String> expressionList) {
        Stack<String> stack = new Stack<>();
        List<String> RPNExpression = new ArrayList<>();
        String currentString = "";

        for (String s : expressionList) {
            currentString = s;
            if (currentString.equals("(")) {
                stack.push(currentString);
            } else if (currentString.equals(")")) {
                while (!stack.peek().equals("(")) {
                    RPNExpression.add(stack.pop());
                }
                stack.pop();
            } else if (getPriority(currentString) == 0) {
                RPNExpression.add(currentString);
            } else if (stack.empty() || getPriority(stack.peek()) <= getPriority(currentString)) {
                stack.push(currentString);
            } else {
                do {
                    RPNExpression.add(stack.pop());
                } while (!stack.empty());
                stack.push(currentString);
            }
        }
        while (!stack.empty()) {
            RPNExpression.add(stack.pop());
        }

        return RPNExpression;
    }

    private static int getPriority(String str) {
        if (str.matches("[\\^]")) return 3;
        else if (str.matches("[/*]")) return 2;
        else if (str.matches("[+\\-]")) return 1;
        else return 0;
    }
}
