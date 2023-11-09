package com.company;

import Logic.Helper.Helper;
import Logic.Modes.BFS;
import Logic.Modes.DFS;
import Logic.Modes.UserMode;
import Structure.Models.*;
import Structure.Moves.MoveResult;
import com.sun.glass.ui.Window;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        while (true) {

            Board initBoard;
            Scanner input = new Scanner (System.in);
            System.out.println ("Chose a Level from 1 to 3");
            char key = input.next ().charAt (0);
            if (key == '1')
                initBoard = Level.level1 ();
            else if (key == '2')
                initBoard = Level.level2 ();
            else if (key == '3')
                initBoard = Level.level3 ();
            else {

                break;
            }

            System.out.println ("Choose an algorithm \n 1.User Mode\n 2.BFS \n 3.DFS");
            key = input.next ().charAt (0);
            if (key == '1')
                new UserMode (initBoard);

            else if (key == '2')
                calculateExecutionTime (() -> {
                    new BFS (initBoard);
                });

            else if (key == '3')
                calculateExecutionTime (() -> {
                    new DFS (initBoard);
                });

            else {
                break;
            }
        }
    }

    private static void calculateExecutionTime(Runnable function) {
        long startTime = System.nanoTime();
        function.run();
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1e9; // Convert to seconds
        System.out.println("Execution time: " + executionTime + " seconds");
    }

}
