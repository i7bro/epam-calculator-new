package ru.semibratov;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleRWTest {

    ConsoleRW consoleRW = new ConsoleRW();

    @Test
    @DisplayName("Тест ввода с консоли валидного выражения")
    void read_valid_test() {
        assertEquals("5-4*2-5", consoleRW.read(new Scanner("5-4*2-5")));
    }

    @Test
    @DisplayName("Вывод ответа")
    void write_answer_test() {
        assertThat(consoleRW.write("55"), equalTo(true));
    }

    @Test
    @DisplayName("Вывод ответа при значении null")
    void write_answer_null_test() {
        assertThat(consoleRW.write(null), equalTo(false));
    }
}