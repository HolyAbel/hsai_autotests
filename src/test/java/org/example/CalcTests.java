package org.example;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeAll;

public class CalcTests {
    static Calculator calc;

    static final double delta = 0.1;

    @BeforeAll
    public static void initCalc() {
        calc = new Calculator();
    }
}
