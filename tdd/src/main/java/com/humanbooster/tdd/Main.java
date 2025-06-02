package com.humanbooster.tdd;

import com.humanbooster.tdd.stringreverser.StringReverser;

public class Main {
    public static void main(String[] args) {
        System.out.println("LENGTH: " + "\n".length());
        System.out.println("TEST: " + StringReverser.reverse("ab\rcd"));
        System.out.println("TEST: " + new StringBuilder("ab\rcd").reverse().toString());
    }
}