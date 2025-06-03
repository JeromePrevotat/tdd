package com.humanbooster.tdd.stringcalculatortest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.humanbooster.tdd.stringcalculator.StringCalculator;

public class StringCalculatorTest {
    @Test
    public void input_null_should_return_null_exeption() {
        assertThrows(NullPointerException.class, () -> {
            new StringCalculator().add(null);
        });
    }

    @Test
    public void input_empty_should_return_illegal_argument_exception(){
        assertThrows(IllegalArgumentException.class, () -> {
            new StringCalculator().add("");
        });
    }

    
}
