package com.btiddle;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import static com.btiddle.PrintTable.getInput;

public class getInputTests {

    private static String SPACES = "ERROR: Spaces are not allowed in input value.";
    private static String NULL = "ERROR: Empty string is an invalid input value.";
    private static String NON_DIGITS = "ERROR: Input is not a valid number.";
    private static String USAGE = "primetable: Print a multiplication table of prime numbers.";

    //
    // Positive Tests
    //

    @Test
    public void positive_size_001() {
        StringWriter output = new StringWriter();
        String input = "1\n";
        assertEquals(getInput(
            new Scanner(input), new PrintWriter(output)), 1);
        assertFalse(output.toString().contains(USAGE));
    }

    @Test
    public void positive_size_002() {
        StringWriter output = new StringWriter();
        String input = "02\n";
        assertEquals(getInput(
            new Scanner(input), new PrintWriter(output)), 2);
        assertFalse(output.toString().contains(USAGE));
    }

    @Test
    public void positive_size_003() {
        StringWriter output = new StringWriter();
        String input = "003\n";
        assertEquals(getInput(
            new Scanner(input), new PrintWriter(output)), 3);

        assertFalse(output.toString().contains(USAGE));
    }

    @Test
    public void positive_size_004() {
        StringWriter output = new StringWriter();
        String input = "0004\n";
        assertEquals(getInput(
            new Scanner(input), new PrintWriter(output)), 4);
        assertFalse(output.toString().contains(USAGE));
    }

    @Test
    public void positive_size_005() {
        StringWriter output = new StringWriter();
        String input = "5\n";
        assertEquals(getInput(
            new Scanner(input), new PrintWriter(output)), 5);
        assertFalse(output.toString().contains(USAGE));
    }

    @Test
    public void positive_equal_to_max_9223372036854775807() {
        StringWriter output = new StringWriter();
        String input = "9223372036854775807\n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertEquals(getInput(
            new Scanner(input), new PrintWriter(output)), 9223372036854775807L);
    }

    //
    // Negative Tests
    //

    @Test
    public void negative_null_string() {
        StringWriter output = new StringWriter();
        String input = "\n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains(NULL));
        assertTrue(output.toString().contains(USAGE));
    }

    @Test
    public void negative_space_at_front() {
        StringWriter output = new StringWriter();
        String input = " 1\n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains(SPACES));
        assertTrue(output.toString().contains(USAGE));
    }

    @Test
    public void negative_space_in_middle() {
        StringWriter output = new StringWriter();
        String input = "1 1\n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains(SPACES));
        assertTrue(output.toString().contains(USAGE));
    }

    @Test
    public void negative_space_at_end() {
        StringWriter output = new StringWriter();
        String input = "202 \n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains(SPACES));
        assertTrue(output.toString().contains(USAGE));
    }

    @Test
    public void negative_letter_at_front() {
        StringWriter output = new StringWriter();
        String input = "A345\n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains(NON_DIGITS));
        assertTrue(output.toString().contains(USAGE));
    }

    @Test
    public void negative_letter_in_middle() {
        StringWriter output = new StringWriter();
        String input = "93A71\n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains(NON_DIGITS));
        assertTrue(output.toString().contains(USAGE));
    }

    @Test
    public void negative_letter_at_end() {
        StringWriter output = new StringWriter();
        String input = "8432Z\n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains(NON_DIGITS));
        assertTrue(output.toString().contains(USAGE));
    }

    @Test
    public void negative_punctuation_at_front() {
        StringWriter output = new StringWriter();
        String input = "!3421\n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains(NON_DIGITS));
        assertTrue(output.toString().contains(USAGE));
    }

    @Test
    public void negative_punctuation_in_middle() {
        StringWriter output = new StringWriter();
        String input = "144.144\n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains(NON_DIGITS));
        assertTrue(output.toString().contains(USAGE));
    }

    @Test
    public void negative_punctuation_at_end() {
        StringWriter output = new StringWriter();
        String input = "411?\n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains(NON_DIGITS));
        assertTrue(output.toString().contains(USAGE));
    }

    @Test
    public void negative_larger_than_max_9223372036854775807() {
        StringWriter output = new StringWriter();
        String input = "9223372036854775808\n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains(NON_DIGITS));
        assertTrue(output.toString().contains(USAGE));
    }

    @Test
    public void negative_equal_to_0() {
        StringWriter output = new StringWriter();
        String input = "0\n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains(NON_DIGITS));
        assertTrue(output.toString().contains(USAGE));
    }

    @Test
    public void negative_less_than_zero() {
        StringWriter output = new StringWriter();
        String input = "-1\n";
        getInput(new Scanner(input), new PrintWriter(output));
        assertTrue(output.toString().contains(NON_DIGITS));
        assertTrue(output.toString().contains(USAGE));
    }
}
