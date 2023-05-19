package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class IsPositiveTests extends CalcTests {
    @ParameterizedTest
    @CsvSource({"1", "15326"})
    public void testPosIsTrue(long a) {
        assertTrue(calc.isPositive(a));
    }

    @ParameterizedTest
    @CsvSource({"-1", "-1266243"})
    public void testPosIsFalse(long a) {
        assertFalse(calc.isPositive(a));
    }

    @Test
    public void testZeroIsNotPos() {
        assertFalse(calc.isPositive(0));
    }
}
