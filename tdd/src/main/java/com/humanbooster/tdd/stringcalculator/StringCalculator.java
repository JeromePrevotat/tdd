package com.humanbooster.tdd.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static int add(String input) {
        List<String> separatorList = new ArrayList<>();
        // ADD BOTH DEFAULT SEPARATORS
        separatorList.add(",");
        separatorList.add("\n");
        String separator = "";
        String cleanedInput = input;
        List<Integer> negativeNumbers = new ArrayList<>();
        int result = 0;
        // ERROR HANDLING
        if (input == null) throw new NullPointerException("Input cannot be null");
        if (input.isEmpty()) throw new IllegalArgumentException("Input cannot be empty");
        // CUSTOM SEPARATOR
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        if (input.charAt(0) == '/' && input.length() > 3 && input.charAt(1) == '/') {
            separator = input.substring(2).split("\n")[0];
            //EMPTY SEPARATOR
            if (separator.isEmpty()) throw new IllegalArgumentException("Separator cannot be empty");
            // MULTIPLE CHARACTERS SEPARATOR
            if (separator.length() != 1) throw new IllegalArgumentException("Separator must be a single character");
            for (String digit : digits) if (separator.contains(digit)) throw new IllegalArgumentException("Invalid separator");
            // ADDS CUSTOM SEPARATOR TO THE LIST
            separatorList.add(separator);
            // REMOVE CUSTOM SEPARATOR FROM INPUT
            cleanedInput = input.substring( 4);
        }
        // REPLACE ALL SEPARATOR BY A COMMA
        for (String sep : separatorList) cleanedInput = cleanedInput.replace(sep, ",");
        // SPLIT THE INPUT BY COMMA
        String[] stringNumbers = cleanedInput.split(separatorList.get(0));
        try {
            for(String number : stringNumbers){
                // Skip empty strings
                if (number.isEmpty()) continue;
                int n = Integer.parseInt(number.trim());
                // Handle negative numbers
                if (number.charAt(0) == '-') negativeNumbers.add(n);
                // Ignore numbers greater than 1000
                if (n <= 1000 && n >= 0) result += n;
            }
            
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
        // System.out.println("Result: " + result);
        return result;
    }
}
