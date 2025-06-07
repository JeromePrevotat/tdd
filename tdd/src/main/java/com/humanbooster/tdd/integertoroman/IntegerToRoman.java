package com.humanbooster.tdd.integertoroman;

public class IntegerToRoman {
    public static String intToRoman(int number) {
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
        // Hard Edge Case 5 * 10^x - 1 * 10^x (4, 40, 400)
        //- `58` → `"LVIII"`
        //- `1994` → `"MCMXCIV"`
        // Exception Handling
        if (number < 1 || number > 3999) throw new IllegalArgumentException("Number must be between 1 and 3999");

        String result = "";
        int maxPowerOfTen = getMaxPowerOfTen(number); // Get number length (=power of ten)
        int power = maxPowerOfTen; // Starts from the far right (units) and goes to the left (thousands)
        int i = 0;
        // Roman numerals for power of ten and multiples of five
        String[] powerOfTenInRomanNumerals = {"I", "X", "C", "M"};
        String[] mutliplesOfFivesInRomanNumerals = {"V", "L", "D"};
        
        while (power >= 0) {
            int chiffre = getDigitFromNumberAtIndex(number, power); // Get the digit at the current power of ten
            // 0 has no symbol and is ignored, it will be retrivied by the next power of ten
            if (chiffre == 0) {
                power--;
                continue;
            }
            // 5 * 10^x - 1 * 10^x (4, 40, 400)
            if (chiffre == 4){
                result += mutliplesOfFivesInRomanNumerals[maxPowerOfTen - power];
                result += powerOfTenInRomanNumerals[maxPowerOfTen - power];
                power--;
                continue;
            }
            
            // Insert the correct symbol for 5 * 10^x
            if (chiffre % 5 == 0 ){
                result += mutliplesOfFivesInRomanNumerals[maxPowerOfTen - power];
                power--;
                continue;
            }
            // 10^x+1 - 10^x (9, 90, 900)
            if (chiffre % 9 == 0 ){
                result += powerOfTenInRomanNumerals[maxPowerOfTen - power + 1];
                result += powerOfTenInRomanNumerals[maxPowerOfTen - power];
                power--;
                continue;
            }
            // 2 ou 3 == 7 ou 8 % 5
            i = 0;
            while (i < chiffre % 5) {
                result += powerOfTenInRomanNumerals[maxPowerOfTen - power];
                i++;
            }
            // 6, 7 ou 8 -> Insert the correct symbol for 5 * 10^x + Iy * 10^x-1 
            if (chiffre - 5 > 0) result += mutliplesOfFivesInRomanNumerals[maxPowerOfTen - power];
            power--;
        }
        // Reverse the Strin into the correct order
        StringBuilder sb = new StringBuilder(result);
        result = sb.reverse().toString();
        // System.out.println("===== RESULT: " + result + " =====\n");
        return result;
    }

    private static int getMaxPowerOfTen(int number) {
        return String.valueOf(number).length() - 1; // 10^0 = 1
    }

    private static int getDigitFromNumberAtIndex(int number, int index){
        // Cast numer to String, get the char at index, back from char to String, Cast to Integer
        return Integer.valueOf(String.valueOf(String.valueOf(number).charAt(index)));
    }
}
