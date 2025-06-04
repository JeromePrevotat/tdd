package com.humanbooster.tdd;

import com.humanbooster.tdd.mazesolver.MazeSolver;

public class Main {
    public static void main(String[] args) {
        MazeSolver mazeSolver = new MazeSolver();
        String[][] maze = {
            {"S"},
            {"E"}
        };
        String instructions = "";
        instructions = mazeSolver.solve(maze);
    }
}