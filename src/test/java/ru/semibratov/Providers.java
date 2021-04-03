package ru.semibratov;

import org.junit.jupiter.params.provider.Arguments;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Providers {

    public Providers() {}

    public static Stream<Arguments> testSumOperation() {
        return Stream.of(
                arguments(Arrays.asList("4", "2", "+"), "6"),
                arguments(Arrays.asList("4.2", "2.1", "+"), "6.3"),
                arguments(Arrays.asList("-1", "-4", "+"), "-5")
        );
    }

    public static Stream<Arguments> testSubOperation() {
        return Stream.of(
                arguments(Arrays.asList("4", "2", "-"), "2"),
                arguments(Arrays.asList("4.2", "2.1", "-"), "2.1"),
                arguments(Arrays.asList("-1", "-4", "-"), "3")
        );
    }

    public static Stream<Arguments> testMultiOperation() {
        return Stream.of(
                arguments(Arrays.asList("4", "2", "*"), "8"),
                arguments(Arrays.asList("4.2", "2.1", "*"), "8.82"),
                arguments(Arrays.asList("-1", "-4", "*"), "4")
        );
    }

    public static Stream<Arguments> testDivOperation() {
        return Stream.of(
                arguments(Arrays.asList("4", "2", "/"), "2"),
                arguments(Arrays.asList("4.2", "2.1", "/"), "2"),
                arguments(Arrays.asList("-1", "-4", "/"), "0.25")
        );
    }

    public static Stream<Arguments> testSeveralOperation() {
        return Stream.of(
                arguments(Arrays.asList("4", "2", "2", "/", "-"), "3"),
                arguments(Arrays.asList("4.2", "2.1", "2.1", "*", "+"), "8.61"),
                arguments(Arrays.asList("-1", "-4", "5", "/", "*"), "0.8")
        );
    }

    public static Stream<Arguments> testParsToExpression() {
        return Stream.of(
                arguments("5+2-3", Arrays.asList("5", "+", "2", "-", "3")),
                arguments("51.2*2.1/0.3", Arrays.asList("51.2", "*", "2.1", "/", "0.3")),
                arguments("(-1)*(2.2-3)", Arrays.asList("-1", "*", "(", "2.2", "-", "3", ")"))
        );
    }

    public static Stream<Arguments> testParsToRPNExpression() {
        return Stream.of(
                arguments(Arrays.asList("6", "-", "6", "*", "2"), Arrays.asList("6", "6", "2", "*", "-")),
                arguments(Arrays.asList("(", "6", "-", "6", ")", "*", "2"), Arrays.asList("6", "6", "-", "2", "*"))
        );
    }

    public static Stream<Arguments> testValidation() {
        return Stream.of(
                arguments("5-5="),
                arguments(""),
                arguments("5/0"),
                arguments("6-6*4+"),
                arguments("3--3"),
                arguments("(2-2(*4")
        );
    }
}
