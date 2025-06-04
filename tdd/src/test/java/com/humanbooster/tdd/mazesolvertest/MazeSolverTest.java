package com.humanbooster.tdd.mazesolvertest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.humanbooster.tdd.mazesolver.MazeSolver;

public class MazeSolverTest {
    MazeSolver mazeSolver;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    /// MAZE VALIDATION TESTS                                                                           ///
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @BeforeEach
    public void setUp() {
        this.mazeSolver = new MazeSolver();
    }

    @Test
    public void null_maze_should_throw_null_pointer_exception() {
        String[][] nullMaze = null;

        assertThrowsExactly(NullPointerException.class, () -> mazeSolver.solve(nullMaze));
    }

    @ParameterizedTest
    @MethodSource("generateEmptyMazesTest")
    public void empty_maze_should_throw_illegal_argument_exception(String[][] emptyMaze) {
        assertThrowsExactly(IllegalArgumentException.class, () -> mazeSolver.solve(emptyMaze));
    }

    static Stream<String[][]> generateEmptyMazesTest() {
        return Stream.of(
            new String[][]{{}},
            new String[][]{{""}},
            new String[][]{{}, {""}},
            new String[][]{{""}, {""}}
        );
    }

    @Test
    public void maze_without_start_should_throw_illegal_argument_exception() {
        String[][] mazeWithoutStart = new String[][]{
            {"#","E"},
            {"#","."},
        };
        assertThrowsExactly(IllegalArgumentException.class, () -> mazeSolver.solve(mazeWithoutStart));

    }

    @Test
    public void maze_without_end_should_throw_illegal_argument_exception() {
        String[][] mazeWithoutEnd = new String[][]{
            {"#","S"},
            {"#","."},
        };
        assertThrowsExactly(IllegalArgumentException.class, () -> mazeSolver.solve(mazeWithoutEnd));

    }

    @Test
    public void maze_without_start_nor_end_should_throw_illegal_argument_exception() {
        String[][] mazeWithoutStartNorEnd = new String[][]{
            {"#","."},
            {"#","."},
        };
        assertThrowsExactly(IllegalArgumentException.class, () -> mazeSolver.solve(mazeWithoutStartNorEnd));
    }

    @Test
    public void maze_with_multiple_start_should_throw_illegal_argument_exception(){
        String[][] mazeWithMultipleStart = new String[][]{
            {"S","S"},
            {"E","#"},
        };
        assertThrowsExactly(IllegalArgumentException.class, () -> mazeSolver.solve(mazeWithMultipleStart));
    }

    @Test
    public void maze_with_multiple_end_should_throw_illegal_argument_exception(){
        String[][] mazeWithMultipleEnd = new String[][]{
            {"S","#"},
            {"E","E"},
        };
        assertThrowsExactly(IllegalArgumentException.class, () -> mazeSolver.solve(mazeWithMultipleEnd));
    }

    @Test
    public void maze_with_multiple_start_and_end_should_throw_illegal_argument_exception(){
        String[][] mazeWithMultipleStartAndEnd = new String [][]{
            {"S","S"},
            {"E","E"},
        };
        assertThrowsExactly(IllegalArgumentException.class, () -> mazeSolver.solve(mazeWithMultipleStartAndEnd));
    }

    @Test
    public void maze_without_path_should_throw_illegal_argument_exception(){
        String[][] mazeFilledWithWalls = new String [][]{
            {"S","#","#"},
            {"#","#","#"},
            {"#","#","E"},
        };
        assertThrowsExactly(IllegalArgumentException.class, () -> mazeSolver.solve(mazeFilledWithWalls));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    /// NODES TESTS                                                                           ///
    /////////////////////////////////////////////////////////////////////////////////////////////
    
    @Test
    public void isNode_should_return_true_for_start_node() {
        String[][] maze = {{"S"}};
        assertTrue(mazeSolver.isNode(maze, 0, 0));
    }

    @Test
    public void isNode_should_return_true_for_end_node() {
        String[][] maze = {{"E"}};
        assertTrue(mazeSolver.isNode(maze, 0, 0));
    }

    @Test
    public void border_NS_corridor_should_return_false() {
        String[][] maze = {
            {"#", ".", "#"},
        };
        assertFalse(mazeSolver.isNode(maze, 1, 0));
    }

    @Test
    public void border_EW_corridor_should_return_false() {
        String[][] maze = {
            {"#"},
            {"."},
            {"#"},
        };
        assertFalse(mazeSolver.isNode(maze, 0, 1));
    }

    @Test
    public void junction_T_ENS_should_return_true() {
        String[][] maze = {
            {"#", ".", "#"},
            {".", ".", "#"},
            {"#", ".", "#"},
        };
        assertTrue(mazeSolver.isNode(maze, 1, 1));
    }

    @Test
    public void junction_T_NSE_should_return_true() {
        String[][] maze = {
            {"#", ".", "#"},
            {".", ".", "."},
            {"#", "#", "#"},
        };
        assertTrue(mazeSolver.isNode(maze, 1, 1));
    }

    @Test
    public void junction_T_NSW_should_return_true() {
        String[][] maze = {
            {"#", ".", "#"},
            {"#", ".", "."},
            {"#", ".", "#"},
        };
        assertTrue(mazeSolver.isNode(maze, 1, 1));
    }

    @Test
    public void junction_T_ESW_should_return_true() {
        String[][] maze = {
            {"#", "#", "#"},
            {".", ".", "."},
            {"#", ".", "#"},
        };
        assertTrue(mazeSolver.isNode(maze, 1, 1));
    }

    @Test
    public void junction_T_ES_should_return_true() {
        String[][] maze = {
            {"#", "#", "#"},
            {".", ".", "#"},
            {"#", ".", "#"},
        };
        assertTrue(mazeSolver.isNode(maze, 1, 1));
    }

    @Test
    public void junction_T_EN_should_return_true() {
        String[][] maze = {
            {"#", ".", "#"},
            {".", ".", "#"},
            {"#", "#", "#"},
        };
        assertTrue(mazeSolver.isNode(maze, 1, 1));
    }

    @Test
    public void junction_T_WN_should_return_true() {
        String[][] maze = {
            {"#", ".", "#"},
            {"#", ".", "."},
            {"#", "#", "#"},
        };
        assertTrue(mazeSolver.isNode(maze, 1, 1));
    }

    @Test
    public void junction_T_WS_should_return_true() {
        String[][] maze = {
            {"#", "#", "#"},
            {"#", ".", "."},
            {"#", ".", "#"},
        };
        assertTrue(mazeSolver.isNode(maze, 1, 1));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    /// INSTRUCTIONS TESTS                                                                    ///
    /////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void null_instructions_should_throw_null_pointer_exception() {
        String instructions = null;
        assertThrowsExactly(NullPointerException.class, () -> mazeSolver.generateInstructions(instructions));
    }

    @Test
    public void empty_instructions_should_throw_illegal_argument_exception() {
        String instructions = "";
        assertThrowsExactly(IllegalArgumentException.class, () -> mazeSolver.generateInstructions(instructions));
    }

    @Test
    public void instructions_should_contain_only_valid_characters() {
        String instructions = "N,E,S,W";
        assertTrue(mazeSolver.generateInstructions(instructions));
    }
}
