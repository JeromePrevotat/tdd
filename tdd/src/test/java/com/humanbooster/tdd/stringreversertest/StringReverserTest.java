package com.humanbooster.tdd.stringreversertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.humanbooster.tdd.stringreverser.StringReverser;

public class StringReverserTest {
    @Test
    void null_should_return_null() {
        assertEquals(null, StringReverser.reverse(null));
    }

    @Test
    void empty_string_should_return_empty_string(){
        assertEquals("", StringReverser.reverse(""));
    }

    //Unicode ?

    @Test
    void single_character_should_return_same_character() {
        assertEquals("a", StringReverser.reverse("a"));
    }

    @Test
    void multiple_characters_should_return_reversed_string() {
        assertEquals("cba", StringReverser.reverse("abc"));
    }

    @Test
    void newLine_should_return_newLine(){
        assertEquals("\n", StringReverser.reverse("\n"));
    }

    @Test
    void tab_should_return_tab() {
        assertEquals("\t", StringReverser.reverse("\t"));
    }

    @Test
    void cr_should_return_cr() {
        assertEquals("\r", StringReverser.reverse("\r"));
    }

    @Test
    void multiple_character_with_newline_at_begining_should_return_reversed_string_with_newline() {
        assertEquals("\ncba", StringReverser.reverse("abc\n"));
    }

    @Test
    void multiple_character_with_tab_at_begining_should_return_reversed_string_with_tab() {
        assertEquals("\tcba", StringReverser.reverse("abc\t"));
    }

    @Test
    void multiple_character_with_cr_at_begining_should_return_reversed_string_with_cr() {
        assertEquals("\rcba", StringReverser.reverse("abc\r"));
    }

    @Test
    void multiple_character_with_newline_in_middle_should_return_reversed_string_with_newline() {
        assertEquals("dc\nba", StringReverser.reverse("ab\ncd"));
    }

    @Test
    void multiple_character_with_tab_in_middle_should_return_reversed_string_with_tab() {
        assertEquals("dc\tba", StringReverser.reverse("ab\tcd"));
    }

    @Test
    void multiple_character_with_cr_in_middle_should_return_reversed_string_with_cr() {
        assertEquals("dc\rba", StringReverser.reverse("ab\rcd"));
    }

    @Test
    void multiple_character_with_newline_at_the_end_should_return_reversed_string_with_newline() {
        assertEquals("\ncba", StringReverser.reverse("abc\n"));
    }

    @Test
    void multiple_character_with_tab_at_the_end_should_return_reversed_string_with_tab() {
        assertEquals("\tcba", StringReverser.reverse("abc\t"));
    }

    @Test
    void multiple_character_with_cr_at_the_end_should_return_reversed_string_with_cr() {
        assertEquals("\rcba", StringReverser.reverse("abc\r"));
    }

    @Test
    void multiple_character_with_newline_at_the_begining_and_the_end_should_return_reversed_string_with_newline() {
        assertEquals("\ncba\n", StringReverser.reverse("\nabc\n"));
    }

    @Test
    void multiple_character_with_tab_at_the_begining_and_the_end_should_return_reversed_string_with_tab() {
        assertEquals("\tcba\t", StringReverser.reverse("\tabc\t"));
    }

    @Test
    void multiple_character_with_cr_at_the_begining_and_the_end_should_return_reversed_string_with_cr() {
        assertEquals("\rcba\r", StringReverser.reverse("\rabc\r"));
    }

    @Test
    void multiple_character_with_newline_at_the_begining_and_the_end_and_middle_should_return_reversed_string_with_newline() {
        assertEquals("\ndc\nba\n", StringReverser.reverse("\nab\ncd\n"));
    }

    @Test
    void multiple_character_with_tab_at_the_begining_and_the_end_and_middle_should_return_reversed_string_with_tab() {
        assertEquals("\tdc\tba\t", StringReverser.reverse("\tab\tcd\t"));
    }

    @Test
    void multiple_character_with_cr_at_the_begining_and_the_end_and_middle_should_return_reversed_string_with_cr() {
        assertEquals("\rdc\rba\r", StringReverser.reverse("\rab\rcd\r"));
    }
}
