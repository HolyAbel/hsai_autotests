package org.example;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalcTests {
    static Calculator calc;

    @BeforeAll
    public static void initCalc() {
        calc = new Calculator();
    }

    @Test
    public void testSum() {
        assertEquals(5, calc.sum(3, 2), "testSum() problem!");
    }

    @Test
    public void testSin() {
        assertEquals(0.7, calc.sin(0.785), 0.01, "testSin() problem!");
    }

    @Test
    public void DivBy0() {
        assertThrows(NumberFormatException.class, () -> {   calc.div(10, 0);    });
    }

    @ParameterizedTest
    @CsvSource({"8, 2, 4", "9, 3, 3", "2, 2, 2"})
    public void testMult(int excepted, int a, int b) {
        assertEquals(excepted, calc.mult(a, b));
    }
}
