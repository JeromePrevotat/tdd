package com.humanbooster.tdd.stringreverser;

public class StringReverser {
    public static String reverse(String input){
        if (input == null) return null;
        if (input.isEmpty()) return "";
        String reversed = "";
        int i = input.length() - 1;
        while (i >= 0){
            reversed += input.charAt(i);
            i--;
        }
        return reversed;
    }
}
