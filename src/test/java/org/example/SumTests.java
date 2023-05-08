package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTests extends CalcTests {
    @ParameterizedTest
    @CsvSource({"1, 9223372036854775807, -9223372036854775808", "-9223372036854775808, -1, 9223372036854775807", "-1, 2, 1", "0, 3, 3", "3, 0, 3", "-1, 0, -1", "3, 0, 3"})
    public void testSum(long a, long b, long excepted) {
        assertEquals(excepted, calc.sum(a, b), "intTestSum() problem!");
    }
}
