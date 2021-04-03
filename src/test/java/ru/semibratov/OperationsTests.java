package ru.semibratov;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OperationsTests {

    @ParameterizedTest
    @MethodSource("ru.semibratov.Providers#testSumOperation")
    @DisplayName("Проверка операции суммирования")
    public void mathCalculations_add_test(List<String> RPNExpressoin, String expected) {
        assertEquals(expected, MathCalculations.getMath(RPNExpressoin));
    }

    @ParameterizedTest
    @MethodSource("ru.semibratov.Providers#testSubOperation")
    @DisplayName("Проверка операции вычитания")
    public void mathCalculations_sub_test(List<String> RPNExpressoin, String expected) {
        assertEquals(expected, MathCalculations.getMath(RPNExpressoin));
    }

    @ParameterizedTest
    @MethodSource("ru.semibratov.Providers#testMultiOperation")
    @DisplayName("Проверка операции умножения")
    public void mathCalculations_multi_test(List<String> RPNExpressoin, String expected) {
        assertEquals(expected, MathCalculations.getMath(RPNExpressoin));
    }

    @ParameterizedTest
    @MethodSource("ru.semibratov.Providers#testDivOperation")
    @DisplayName("Проверка операции деления")
    public void mathCalculations_div_test(List<String> RPNExpressoin, String expected) {
        assertEquals(expected, MathCalculations.getMath(RPNExpressoin));
    }

    @ParameterizedTest
    @MethodSource("ru.semibratov.Providers#testSeveralOperation")
    @DisplayName("Проверка нескольких операций в выражении")
    public void mathCalculations_several_operators_test(List<String> RPNExpressoin, String expected) {
        assertEquals(expected, MathCalculations.getMath(RPNExpressoin));
    }
}
