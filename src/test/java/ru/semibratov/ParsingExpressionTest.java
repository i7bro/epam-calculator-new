package ru.semibratov;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import static org.hamcrest.Matchers.*;

class ParsingExpressionTest {

    @ParameterizedTest
    @MethodSource("ru.semibratov.Providers#testParsToExpression")
    @DisplayName("Тест парсинга строки в список")
    void parsToList_test(String rawExp, List<String> expected) {
        assertThat(ParsingExpression.parsToList(rawExp), equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("ru.semibratov.Providers#testParsToRPNExpression")
    void parsToRPN_test(List<String> RPNExp, List<String> expected) {
        assertThat(ParsingExpression.parsToRPN(RPNExp), equalTo(expected));
    }
}