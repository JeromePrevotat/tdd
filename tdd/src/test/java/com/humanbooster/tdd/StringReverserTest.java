package com.humanbooster.tdd;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.humanbooster.tdd.stringreverser.StringReverser;

public class StringReverserTest {
    @Test
    void null_should_return_null() {
        assertTrue(StringReverser.reverse(null) == null);
    }

    @Test
    void empty_string_should_return_empty_string(){
        assertTrue(StringReverser.reverse("").isEmpty());
    }

    //Unicode ?

    @Test
    void single_character_should_return_same_character() {
        assertTrue(StringReverser.reverse("a").equals("a"));
    }

    @Test
    void multiple_characters_should_return_reversed_string() {
        assertTrue(StringReverser.reverse("abc").equals("cba"));
    }

    @Test
    void newLine_should_return_newLine(){
        assertTrue(StringReverser.reverse("\n").equals("\n"));
    }

    @Test
    void tab_should_return_tab() {
        assertTrue(StringReverser.reverse("\t").equals("\t"));
    }

    @Test
    void cr_should_return_cr() {
        assertTrue(StringReverser.reverse("\r").equals("\r"));
    }

    @Test
    void multiple_character_with_newline_at_begining_should_return_reversed_string_with_newline() {
        assertTrue(StringReverser.reverse("abc\n").equals("\ncba"));
    }

    @Test
    void multiple_character_with_tab_at_begining_should_return_reversed_string_with_tab() {
        assertTrue(StringReverser.reverse("abc\t").equals("\tcba"));
    }

    @Test
    void multiple_character_with_cr_at_begining_should_return_reversed_string_with_cr() {
        assertTrue(StringReverser.reverse("abc\r").equals("\rcba"));
    }

    @Test
    void multiple_character_with_newline_in_middle_should_return_reversed_string_with_newline() {
        assertTrue(StringReverser.reverse("ab\ncd").equals("dc\nba"));
    }

    @Test
    void multiple_character_with_tab_in_middle_should_return_reversed_string_with_tab() {
        assertTrue(StringReverser.reverse("ab\tcd").equals("dc\tba"));
    }

    @Test
    void multiple_character_with_cr_in_middle_should_return_reversed_string_with_cr() {
        assertTrue(StringReverser.reverse("ab\rcd").equals("dc\rba"));
    }

    @Test
    void multiple_character_with_newline_at_the_end_should_return_reversed_string_with_newline() {
        assertTrue(StringReverser.reverse("abc\n").equals("\ncba"));
    }

    @Test
    void multiple_character_with_tab_at_the_end_should_return_reversed_string_with_tab() {
        assertTrue(StringReverser.reverse("abc\t").equals("\tcba"));
    }

    @Test
    void multiple_character_with_cr_at_the_end_should_return_reversed_string_with_cr() {
        assertTrue(StringReverser.reverse("abc\r").equals("\rcba"));
    }

    @Test
    void multiple_character_with_newline_at_the_begining_and_the_end_should_return_reversed_string_with_newline() {
        assertTrue(StringReverser.reverse("\nabc\n").equals("\ncba\n"));
    }

    @Test
    void multiple_character_with_tab_at_the_begining_and_the_end_should_return_reversed_string_with_tab() {
        assertTrue(StringReverser.reverse("\tabc\t").equals("\tcba\t"));
    }

    @Test
    void multiple_character_with_cr_at_the_begining_and_the_end_should_return_reversed_string_with_cr() {
        assertTrue(StringReverser.reverse("\rabc\r").equals("\rcba\r"));
    }

    @Test
    void multiple_character_with_newline_at_the_begining_and_the_end_and_middle_should_return_reversed_string_with_newline() {
        assertTrue(StringReverser.reverse("\nab\ncd\n").equals("\ndc\nba\n"));
    }

    @Test
    void multiple_character_with_tab_at_the_begining_and_the_end_and_middle_should_return_reversed_string_with_tab() {
        assertTrue(StringReverser.reverse("\tab\tcd\t").equals("\tdc\tba\t"));
    }

    @Test
    void multiple_character_with_cr_at_the_begining_and_the_end_and_middle_should_return_reversed_string_with_cr() {
        assertTrue(StringReverser.reverse("\rab\rcd\r").equals("\rdc\rba\r"));
    }
}
