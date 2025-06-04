package com.humanbooster.tdd.mazesolver;

import java.util.ArrayList;
import java.util.List;

public class MazeSolver {
    List<Node> nodes = new ArrayList<>();

    public String solve(String[][] maze) {
        // STEP 1: Validate the maze
        // STEP 2: First pass to map Nodes
        // STEP 3: Use Djikstra's algorithm to find the shortest path
        errorHandler(maze);
        return null;
    }
    
    private void errorHandler(String[][] maze) {
        if (maze == null) throw new NullPointerException("Maze cannot be null");
        if (maze[0].length == 0 || maze[0][0].length() == 0) throw new IllegalArgumentException("Maze cannot be empty");
        int x = 0;
        int y = 0;
        boolean empty = true;
        boolean invalidChar = false;
        int startCount = 0;
        int endCount = 0;
        while (y < maze.length) {
            while(x < maze[y].length){
                if (!maze[y][x].equals("")) empty = false;
                if (!maze[y][x].equals("S")) startCount++;
                if (!maze[y][x].equals("E")) endCount++;
                if (!maze[y][x].equals("S")
                    && !maze[y][x].equals("E")
                    && !maze[y][x].equals(".")
                    && !maze[y][x].equals("#")
                    ) invalidChar = true;
                x++;
            }
            y++;
        }
        if (empty) throw new IllegalArgumentException("Maze cannot be empty");
        if (startCount == 0) throw new IllegalArgumentException("Maze must have a start point 'S'");
        if (startCount > 1) throw new IllegalArgumentException("Maze must have only one start point 'S'");
        if (endCount > 1) throw new IllegalArgumentException("Maze must have only one end point 'E'");
        if (endCount == 0) throw new IllegalArgumentException("Maze must have an end point 'E'");
        if (invalidChar) throw new IllegalArgumentException("Maze contains invalid characters");
    }

    public void mapNodes(String[][] maze){
        int x = 0;
        int y = 0;
        while (y < maze.length) {
            while(x < maze[y].length){
                // SKIP WALLS
                if (maze[y][x].equals("#")) continue;
                if (isNode(maze, x, y)) this.nodes.add(createNode(x, y, maze[y][x]));
                x++;
            }
            y++;
        }
    }

    public boolean isNode(String[][] maze, int x, int y){
        if (maze[y][x].equals("S") || maze[y][x].equals("E")) return true;
        if (maze[y][x].equals(".")){
            // CHECK NORTH & SOUTH ARE WALLS == Corridor E/W
            if (y > 0 && maze[y-1][x].equals("#")
            && y < maze.length - 1 && maze[y+1][x].equals("#")) return false;
            // CHECK EAST & WEST ARE WALLS == Corridor N/S
            if (x > 0 && maze[y][x-1].equals("#")
                && x < maze[y].length - 1 && maze[y][x+1].equals("#")) return false;
        }
        return true;
    }

    public Node createNode(int x, int y, String around){
        throw new UnsupportedOperationException("Node creation not implemented yet");
    }

    public boolean generateInstructions(String instructions){
        throw new IllegalArgumentException("generateInstructions not implemented yet");
    }
}
