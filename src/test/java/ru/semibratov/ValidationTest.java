package ru.semibratov;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @ParameterizedTest
    @MethodSource("ru.semibratov.Providers#testValidation")
    @DisplayName("Ввод невалидного выражения")
    public void rawExpressionValidation(String exp) {
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.rawExpressionValidation(exp);
        });
    }
}