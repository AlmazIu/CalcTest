package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalcTest {

    @Test
    @DisplayName("Проверка сложения")
    void summ() {
        Calc testcalc = new Calc();
        int result = testcalc.summ(0, 99);
        Assertions.assertEquals(99, result);
    }


    @Test
    @DisplayName("Проверка вычитания")
    void diff() {
        Calc testcalc = new Calc();
        int result = testcalc.diff(0, 99);
        Assertions.assertEquals(-99, result);
    }

    @ParameterizedTest(name = "#{index} - сложение {0} и {1} ожидаем {2}")
    @CsvSource({"1, 9, 10", "-9,10,1", "0,0,0"})
    @DisplayName("Проверка сложения параметризованная")
    @Tag("sum")
    void summ(int a, int b, int expectedResult) {
        Calc testcalc = new Calc();
        int result = testcalc.summ(a, b);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "#{index} - вычитание {0} и {1} ожидаем {2}")
    @CsvSource({"1, 9, -8", "-9,10,-19", "0,0,0"})
    @DisplayName("Проверка вычитания параметризованная")
    @Tag("diff")
    void diff(int a, int b, int expectedResult) {
        Calc testcalc = new Calc();
        int result = testcalc.diff(a, b);
        Assertions.assertEquals(expectedResult, result);
    }

}