/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.peterpreneur.tictactoe;

import java.util.Scanner;

/**
 *
 * @author peter
 */
public class TicTacToe {

    static char currentPlayer;
    static Scanner scanner = new Scanner(System.in);
    static char[][] board = new char[3][3];
    static char[] t3Board = new char[9];

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");

        // System.out.println("Name the first player:");
        // String firstName = scanner.nextLine();
        // System.out.println("firstName: " + firstName);
        // System.out.println("Name the second plahyer:");
        // String secondName = scanner.nextLine();
        // System.out.println("secondName: " + secondName);
        //initialize the board
        initializeBoard(t3Board);

        //print the board
        printBoard(t3Board);

        boolean continueFlag = true;

        //do until all cells are filled or somebody one
        //since there are 9 elements in Array do a for loop
        for (int i = 0; i < t3Board.length; i++) {
            if (i % 2 == 0) {
                currentPlayer = 'X';
            } else {
                currentPlayer = 'O';
            }

            askToMove(currentPlayer);
        }

        do {
            //ask the current player for a move
            // askForMove();

            //validate the move
            // isValidMove(t3Board);
            //apply the move
            printBoard(t3Board);

            // check if any space is still empty 
            // if no, then stop
            // if yes, then check if the selected space is still empty
            // if no, then ask user to select another space
            // if yes, then check if there's a 3 cross winner
            // if no, then switch to next player 
            // if yes, then sout "Player X win!"
            // continueFlag = continueMove(t3Board);
        } while (true);

        //check win or draw
        //switch player
        // scanner.close();
    }

    private static void initializeBoard(char[] t3Board) {
        for (int i = 0; i < t3Board.length; i++) {
            t3Board[i] = (char) ('1' + i);
        }
    }

    private static void printBoard(char[] t3Board) {
        for (int i = 0; i < t3Board.length; i++) {

            System.out.print(t3Board[i] + " ");

            int modVal = i % 3;
            if (modVal == 2) {
                System.out.println();
            }
        }
    }

    public static void askToMove(char currentPlayer) {
        int input = 0;

        do {
            System.out.println("Player " + currentPlayer + " ,enter location (1-9): ");
            int cell = scanner.nextInt();

            if (isValid(cell)) {
                t3Board[cell - 1] = currentPlayer;
                input = 1;
            } else {
                System.out.println("Invalid!");
            }
            printBoard(t3Board);
        } while (input == 0);
    }

    private static boolean isValid(int cell) {
        char cellVal = t3Board[cell - 1];
        System.out.println("cellVal=" + cellVal);

        return !(cellVal == 'X' || cellVal == 'O');
    }

}
