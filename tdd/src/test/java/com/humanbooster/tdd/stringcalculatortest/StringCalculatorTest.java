package com.humanbooster.tdd.stringcalculatortest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import org.junit.jupiter.api.Test;

import com.humanbooster.tdd.stringcalculator.StringCalculator;

public class StringCalculatorTest {
    @Test
    public void input_null_should_return_null_exeption() {
        assertThrowsExactly(NullPointerException.class, () -> {
            new StringCalculator().add(null);
        });
    }

    @Test
    public void input_empty_should_return_illegal_argument_exception(){
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new StringCalculator().add("");
        });
    }

    @Test
    public void input_number_greater_than_1000_should_return_be_ignored() throws Exception {
        assertEquals(1, new StringCalculator().add("1000,1"));
    }

    @Test
    public void input_should_contain_at_least_one_number() throws Exception {
        assertEquals(1, new StringCalculator().add("1"));
    }

    @Test
    public void input_negative_numbers_should_throw_exception_and_return_the_list() throws Exception {
        assertAll(
            () -> assertThrowsExactly(IllegalArgumentException.class, () -> {
                new StringCalculator().add("-1,-2");
            }),
            () -> assertEquals(List.of(-1, -2), new StringCalculator().add("-1,-2"))
        );
    }

    @Test
    public void input_two_digits_should_return_the_sum() throws Exception {
        assertEquals(3, new StringCalculator().add("1,2"));
    }

    @Test
    public void input_comma_separator_should_be_valid() throws Exception {
        assertEquals(3, new StringCalculator().add("1,2"));
    }

    @Test
    public void input_newline_separator_should_be_valid() throws Exception {
        assertEquals(3, new StringCalculator().add("1\n2"));
    }

    @Test
    public void input_starting_with_two_backslashes_defines_a_custome_separator_and_is_valid() throws Exception {
        assertEquals(3, new StringCalculator().add("//;\n1;2"));
    }

    @Test
    public void input_custom_separator_cannot_be_a_digit() throws Exception {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new StringCalculator().add("//1\n1,2");
        });
    }

    @Test
    public void input_custom_separator_must_be_a_single_character() throws Exception {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new StringCalculator().add("//;;\n1,2");
        });
    }

    
}
