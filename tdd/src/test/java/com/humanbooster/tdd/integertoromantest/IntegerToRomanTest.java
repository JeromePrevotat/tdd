package com.humanbooster.tdd.integertoromantest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

import com.humanbooster.tdd.integertoroman.IntegerToRoman;

public class IntegerToRomanTest {
    // ### 4. **Roman Numerals Converter**
    // **Énoncé :**
    // Implémente une méthode `String toRoman(int number)` qui convertit un entier (entre 1 et 3999) en nombre romain.

    // **Exemples :**
    // - `1` → `"I"`
    // - `4` → `"IV"`
    // - `9` → `"IX"`
    // - `58` → `"LVIII"`
    // - `1994` → `"MCMXCIV"`

    // **Contraintes :**
    // - Gérer toutes les combinaisons valides sans hardcoder chaque valeur.

    // Decomposer en puissance 10
    // Assigner le Character correspondant
    // 1 : I
    // 5 : V
    // 10 : X
    // 50 : L
    // 100 : C
    // 500 : D
    // 1000 : M
    // Easy Edge Case 5 * 10^x (5, 50, 500) & 10^x - 10^x-1 (9, 90, 900) 
    // Hard Edge Case 5 * 10^x - 1 * 10^x (4, 40, 400) - 5 * 10^x + 1 * 10^x (6, 60, 600)
    @Test
    void integer_under_lower_limit_should_throw_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.intToRoman(0);
        });
    }
    
    @Test
    void integer_greater_upper_limit_should_throw_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            IntegerToRoman.intToRoman(4000);
        });
    }

    /////////////////////////////////////////////////////////////////////////
    // Powers of Ten                                                       //
    /////////////////////////////////////////////////////////////////////////
    @Test
    void integer_1_should_return_I() {
        assertEquals("I", IntegerToRoman.intToRoman(1));
    }

    @Test
    void integer_10_should_return_X() {
        assertEquals("X", IntegerToRoman.intToRoman(10));
    }

    @Test
    void integer_100_should_return_C() {
        assertEquals("C", IntegerToRoman.intToRoman(100));
    }

    @Test
    void integer_1000_should_return_M() {
        assertEquals("M", IntegerToRoman.intToRoman(1000));
    }

    //////////////////////////////////////////////////////////////////////
    // n * 10^x (2, 20, 200)                                            //
    //////////////////////////////////////////////////////////////////////

    @Test
    void integer_2_should_return_II() {
        assertEquals("II", IntegerToRoman.intToRoman(2));
    }

    @Test
    void integer_20_should_return_XX() {
        assertEquals("XX", IntegerToRoman.intToRoman(20));
    }

    @Test
    void integer_200_should_return_CC() {
        assertEquals("CC", IntegerToRoman.intToRoman(200));
    }

    @Test
    void integer_2000_should_return_MM() {
        assertEquals("MM", IntegerToRoman.intToRoman(2000));
    }

    @Test
    void integer_3_should_return_III() {
        assertEquals("III", IntegerToRoman.intToRoman(3));
    }

    @Test
    void integer_30_should_return_XXX() {
        assertEquals("XXX", IntegerToRoman.intToRoman(30));
    }

    @Test
    void integer_300_should_return_CCC() {
        assertEquals("CCC", IntegerToRoman.intToRoman(300));
    }

    @Test
    void integer_3000_should_return_MMM() {
        assertEquals("MMM", IntegerToRoman.intToRoman(3000));
    }

    //////////////////////////////////////////////////////////////////////
    // 5 * 10^x - 1 * 10^x (4, 40, 400)                                 //
    //////////////////////////////////////////////////////////////////////
    @Test
    void integer_4_should_return_IV() {
        assertEquals("IV", IntegerToRoman.intToRoman(4));
    }

    @Test
    void integer_40_should_return_XL() {
        assertEquals("XL", IntegerToRoman.intToRoman(40));
    }

    @Test
    void integer_400_should_return_CD() {
        assertEquals("CD", IntegerToRoman.intToRoman(400));
    }

    //////////////////////////////////////////////////////////////////////
    /// 5 * 10^x (5, 50, 500)                                           //
    //////////////////////////////////////////////////////////////////////

    @Test
    void integer_5_should_return_V() {
        assertEquals("V", IntegerToRoman.intToRoman(5));
    }

    @Test
    void integer_50_should_return_L() {
        assertEquals("L", IntegerToRoman.intToRoman(50));
    }

    @Test
    void integer_500_should_return_D() {
        assertEquals("D", IntegerToRoman.intToRoman(500));
    }

    //////////////////////////////////////////////////////////////////////
    // 5 * 10^x + 1 * 10^x (6, 60, 600)                                 //
    //////////////////////////////////////////////////////////////////////
    @Test
    void integer_6_should_return_VI() {
        assertEquals("VI", IntegerToRoman.intToRoman(6));
    }

    @Test
    void integer_60_should_return_LX() {
        assertEquals("LX", IntegerToRoman.intToRoman(60));
    }

    @Test
    void integer_600_should_return_DC() {
        assertEquals("DC", IntegerToRoman.intToRoman(600));
    }

    //////////////////////////////////////////////////////////////////////
    // 10^x - 10^x-1 (9, 90, 900)                                       // 
    //////////////////////////////////////////////////////////////////////

    @Test
    void integer_9_should_return_IX() {
        assertEquals("IX", IntegerToRoman.intToRoman(9));
    }

    @Test
    void integer_90_should_return_XC() {
        assertEquals("XC", IntegerToRoman.intToRoman(90));
    }

    @Test
    void integer_900_should_return_CM() {
        assertEquals("CM", IntegerToRoman.intToRoman(900));
    }

    //////////////////////////////////////////////////////////////////////
    /// 5 + n * 10^x (7, 70, 700)                                      ///
    //////////////////////////////////////////////////////////////////////
    
    @Test
    void integer_7_should_return_VII() {
        assertEquals("VII", IntegerToRoman.intToRoman(7));
    }

    @Test
    void integer_70_should_return_LXX() {
        assertEquals("LXX", IntegerToRoman.intToRoman(70));
    }

    @Test
    void integer_700_should_return_DCC() {
        assertEquals("DCC", IntegerToRoman.intToRoman(700));
    }

    @Test
    void integer_8_should_return_VIII() {
        assertEquals("VIII", IntegerToRoman.intToRoman(8));
    }

    @Test
    void integer_80_should_return_LXXX() {
        assertEquals("LXXX", IntegerToRoman.intToRoman(80));
    }

    @Test
    void integer_800_should_return_DCCC() {
        assertEquals("DCCC", IntegerToRoman.intToRoman(800));
    }

    //////////////////////////////////////////////////////////////////////
    /// Combos                                                         ///
    //////////////////////////////////////////////////////////////////////

    @Test
    void integer_654_should_return_DCLIV() {
        assertEquals("DCLIV", IntegerToRoman.intToRoman(654));
    }

    @Test
    void integer_456_should_return_CDLVI() {
        assertEquals("CDLVI", IntegerToRoman.intToRoman(456));
    }

    @Test
    void integer_1469_should_return_MCDLXIX() {
        assertEquals("MCDLXIX", IntegerToRoman.intToRoman(1469));
    }

    @Test
    void integer_1964_should_return_MCMLXIV() {
        assertEquals("MCMLXIV", IntegerToRoman.intToRoman(1964));
    }

    @Test
    void integer_3984_should_return_MMMCMLXXXIV() {
        assertEquals("MMMCMLXXXIV", IntegerToRoman.intToRoman(3984));
    }

    @Test
    void integer_2736_should_return_MMDCCXXXVI() {
        assertEquals("MMDCCXXXVI", IntegerToRoman.intToRoman(2736));
    }

    //////////////////////////////////////////////////////////////////////
    /// A MORT LOUIS CROIX V BATON !!!!                                ///
    /// https://www.youtube.com/watch?v=HvFIt-2TGQE                    ///
    //////////////////////////////////////////////////////////////////////  
    
    @Test
    void integer_16_should_return_XVI() {
        assertEquals("XVI", IntegerToRoman.intToRoman(16));
    }
}
