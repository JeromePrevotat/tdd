package com.humanbooster.tdd.stringcalculatortest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.humanbooster.tdd.stringcalculator.StringCalculator;

public class StringCalculatorTest {

    /////////////////////////////////////////////////////////////////////////////////
    /// INVALIDATION TESTS                                                        ///
    /////////////////////////////////////////////////////////////////////////////////

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

    /////////////////////////////////////////////////////////////////////////////////
    /// VALIDATION TESTS                                                          ///
    /////////////////////////////////////////////////////////////////////////////////
    @Test
    public void input_with_two_single_digits_should_return_the_sum() throws Exception {
        assertEquals(6, new StringCalculator().add("4,2"));
    }

    @Test
    public void input_with_a_single_digit_and_a_two_digits_number_should_return_the_sum() throws Exception {
        assertEquals(42, new StringCalculator().add("1, 41"));
    }

    @Test
    public void input_with_two_two_digits_numbers_should_return_the_sum() throws Exception {
        assertEquals(100, new StringCalculator().add("50,50"));
    }

    @Test
    @ParameterizedTest
    @CsvSource(
        {
            //"expected, number1, number2",
            "42,21,21",
            "9,6,3",
            "10,9,1",
            "101,99,2",
            "1000,500,500",
            "999,666,333",
            "1000,999,1",
            "1001,999,2",
            "1010,1000,10",
            "1515,1000,515",
            "1998,999,999",
        }
    )
    public void input_with_random_number_of_digits_should_return_the_sum_of_the_two(int expected, int number1, int number2) throws Exception {
        assertEquals(expected, new StringCalculator().add(number1 + "," + number2));
    }

    @Test
    @ParameterizedTest
    @CsvSource(
        {
            //"expected, number1, number2",
            "190,90,60,40",
            "175,75,60,40",
        }
    )
    public void input_with_random_number_of_digits_should_return_the_sum_of_all_3(int expected, int n1, int n2, int n3) throws Exception {
        assertEquals(expected, new StringCalculator().add(n1 + "," + n2 + "," + n3));
    }

    @Test
    @ParameterizedTest
    @CsvSource(
        {
            //"expected, number1, number2",
            "315,150,10,80,75",
            "540,150,50,90,250",
        }
    )
    public void input_with_random_number_of_digits_should_return_the_sum_of_all_4(int expected, int n1, int n2, int n3, int n4) throws Exception {
        assertEquals(expected, new StringCalculator().add(n1 + "," + n2 + "," + n3 + "," + n4));
    }

    @Test
    @ParameterizedTest
    @CsvSource(
        {
            //"expected, number1, number2",
            "540,250,40,200,10,40",
            "370,200,10,60,10,90",
        }
    )
    public void input_with_random_number_of_digits_should_return_the_sum_of_all_5(int expected, int n1, int n2, int n3, int n4, int n5) throws Exception {
        assertEquals(expected, new StringCalculator().add(n1 + "," + n2 + "," + n3 + "," + n4 + "," + n5));
    }

    @Test
    @ParameterizedTest
    @CsvSource(
        {
            //"expected, number1, number2...",
            "390,100,100,60,40,90",
            "750,75,300,25,50,50,250"
        }
    )
    public void input_with_random_number_of_digits_should_return_the_sum_of_all_6(int expected, int n1, int n2, int n3, int n4, int n5, int n6) throws Exception {
        assertEquals(expected, new StringCalculator().add(n1 + "," + n2 + "," + n3 + "," + n4 + "," + n5 + "," + n6));
    }

    @Test
    @ParameterizedTest
    @CsvSource(
        {
            //"expected, number1, number2...",
            "390,100,100,60,40,90",
            "750,75,300,25,50,50,250"
        }
    )
    public void input_with_newline_separator_with_random_number_of_digits_should_return_the_sum_of_all_6(int expected, int n1, int n2, int n3, int n4, int n5, int n6) throws Exception {
        assertEquals(expected, new StringCalculator().add(n1 + "\n" + n2 + "\n" + n3 + "\n" + n4 + "\n" + n5 + "\n" + n6));
    }

    @Test
    @ParameterizedTest
    @CsvSource(
        {
            //"expected, number1, number2...",
            "//!\n390,100,100,60,40,90",
            "//!\n750,75,300,25,50,50,250"
        }
    )
    public void input_with_custom_separator_with_random_number_of_digits_should_return_the_sum_of_all_6(int expected, int n1, int n2, int n3, int n4, int n5, int n6) throws Exception {
        assertEquals(expected, new StringCalculator().add(n1 + "!" + n2 + "!" + n3 + "!" + n4 + "!" + n5 + "!" + n6));
    }
}
