package ru.semibratov;

public class Validation {

    public static void rawExpressionValidation(String rawExpression) throws IllegalArgumentException {
        /**
         * check empty expression
         */
        if (rawExpression.equals("")) {
            throw new IllegalArgumentException("Выражение не должно быть пустым");
        }

        /**
         * check dividing 0
         */
        if (rawExpression.matches(".+/0|.+/0\\.0")) {
            throw new IllegalArgumentException("На 0 делить нельзя!");
        }

        /**
         * check illegal symbol in expression
         */
        if (!rawExpression.matches("[[0-9]/*\\-+.^() ]+")) {
            throw new IllegalArgumentException("Недопустимый символ в выражении");
        }

        /**
         * check start and finish expression is number or bracket
         */
        if (!rawExpression.matches("^[ 0-9(].+[0-9) ]$")) {
            throw new IllegalArgumentException("Выражение должно начинаться и заканчиваться цифрой или скобкой");
        }

        /**
         * check count of operators
         */
        if (rawExpression.split("[-*/+]").length > rawExpression.split("[-*/+]+").length) {
            throw new IllegalArgumentException("Недопустимое количество операторов в выражении");
        }

        /**
         * check valid braces
         */
        int leftBrace = 0;
        for (int i=0; i<rawExpression.length(); i++) {
            char currentChar = rawExpression.charAt(i);
            if (currentChar == '(') {
                leftBrace++;
            } else if (currentChar == ')') {
                leftBrace--;
            }
        }
        if (leftBrace != 0)
            throw new IllegalArgumentException("Неверно расставлены скобки!");
    }
}
