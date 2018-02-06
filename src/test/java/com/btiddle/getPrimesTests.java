package com.btiddle;

import java.util.Arrays;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import static com.btiddle.PrintTable.getPrimes;

public class getPrimesTests {

    //
    // Positive Tests
    //

    @Test
    public void positive_size_1() {
        long[] actual = getPrimes(1L);
        long[] expected = new long[] { 2 };
        assertTrue(Arrays.equals(actual, expected));
    }

    @Test
    public void positive_size_2() {
        long[] actual = getPrimes(2L);
        long[] expected = new long[] { 2, 3 };
        assertTrue(Arrays.equals(actual, expected));
    }

    @Test
    public void positive_size_3() {
        long[] actual = getPrimes(3L);
        long[] expected = new long[] { 2, 3, 5 };
        assertTrue(Arrays.equals(actual, expected));
    }

    @Test
    public void positive_size_10() {
        long[] actual = getPrimes(10L);
        long[] expected = new long[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        assertTrue(Arrays.equals(actual, expected));
    }

    @Test
    public void positive_size_100() {
        long[] actual = getPrimes(100L);
        long[] expected = new long[]{
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
            127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
            179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
            233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
            283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
            353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
            419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
            467, 479, 487, 491, 499, 503, 509, 521, 523, 541
        };
        assertTrue(Arrays.equals(actual, expected));
    }

    @Test
    public void positive_size_200() {
        long[] actual = getPrimes(200L);
        long[] expected = new long[]{
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
            127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
            179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
            233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
            283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
            353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
            419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
            467, 479, 487, 491, 499, 503, 509, 521, 523, 541,
            547, 557, 563, 569, 571, 577, 587, 593, 599, 601,
            607, 613, 617, 619, 631, 641, 643, 647, 653, 659,
            661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
            739, 743, 751, 757, 761, 769, 773, 787, 797, 809,
            811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
            877, 881, 883, 887, 907, 911, 919, 929, 937, 941,
            947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013,
            1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069,
            1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151,
            1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223
        };
        assertTrue(Arrays.equals(actual, expected));
    }

    //
    // Negative Tests
    //

    @Test(expectedExceptions = {NumberFormatException.class })
    public void negative_less_than_0() {
        getPrimes(-1L);
    }

    @Test(expectedExceptions = {NumberFormatException.class })
    public void negative_equal_to_0() {
        getPrimes(0L);
    }

    @Test(expectedExceptions = {NumberFormatException.class })
    public void negative_greater_than_max_9223372036854775807() {
        getPrimes(9223372036854775807L + 1L);
    }

}
