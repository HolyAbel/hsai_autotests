package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultTests extends CalcTests {
    @ParameterizedTest
    @CsvSource({"3.5, 2, 7", "3, 2.5, 7.5", "13.25, 7.5, 99.375", "0.25, 7, 1.75", "4, 0.15, 0.6", "13.2541, 0, 0", "0, 12.21, 0"})
    public void testMultCorectnessPos(double a, double b, double excepcted) {
        assertEquals(excepcted, calc.mult(a, b), delta);
    }

    @ParameterizedTest
    @CsvSource({"-3.5, 2, -7", "3, -2.5, -7.5", "-13.25, -7.5, 99.375", "-0.25, 7, -1.75", "-4, 0.15, -0.6", "13.2541, -0, 0", "0, -12.21, 0"})
    public void testMultCorectnessNeg(double a, double b, double excepcted) {
        assertEquals(excepcted, calc.mult(a, b), delta);
    }
}
