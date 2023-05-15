package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivTests extends CalcTests {
    @Test
    public void testDivByZero() {
        assertThrows(NumberFormatException.class, () -> calc.div(17, 0), "zeroDivTest problem!");
    }

    @ParameterizedTest
    @CsvSource({"2, 1, 2", "16, 4, 4", "-2, 1, -2", "0, 2, 0"})
    public void testdivCorectnessInt(double a, double b, int excepcted) {
        assertEquals(excepcted, calc.div(a, b), delta);
    }

    @ParameterizedTest
    @CsvSource({"3, 2, 1.5", "2, 4, 0.5", "13, -4, -3.25", "1237, 13, 95.15"})
    public void testdivCorectnessDouble(double a, double b, double excepcted) {
        assertEquals(excepcted, calc.div(a, b), delta);
    }
}
