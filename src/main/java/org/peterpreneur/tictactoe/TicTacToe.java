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
    static char[] t3Board = new char[9];

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");

        initializeBoard(t3Board);
        printBoard(t3Board);

        boolean gameOver = false;

        for (int i = 0; i < t3Board.length && !gameOver; i++) {
            if (i % 2 == 0) {
                currentPlayer = 'X';
            } else {
                currentPlayer = 'O';
            }

            askToMove(currentPlayer);

            // Check if current player won
            if (checkWinner(currentPlayer)) {
                System.out.println("\nPlayer " + currentPlayer + " WINS!");
                gameOver = true;
                break;
            }

            // Check for tie (board is full)
            if (isBoardFull()) {
                System.out.println("\nIt's a TIE!");
                gameOver = true;
            }
        }

        if (!gameOver) {
            System.out.println("\nGame ended unexpectedly");
        }

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
        boolean flag = false;

        do {
            System.out.println("Player " + currentPlayer + " ,enter location (1-9): ");
            int cell = scanner.nextInt();

            if (isValid(cell)) {
                t3Board[cell - 1] = currentPlayer;
                flag = true;
            } else {
                System.out.println("Invalid!");
            }
            printBoard(t3Board);

        } while (!flag);
    }

    private static boolean isValid(int cell) {
        // Check if cell is in valid range (1-9)
        if (cell < 1 || cell > 9) {
            return false;
        }

        char cellVal = t3Board[cell - 1];

        // Check if cell not already X nor O
        return !(cellVal == 'X' || cellVal == 'O');
    }

    private static boolean checkWinner(char player) {
        // All 8 winning combination
        int[][] winningCombos = {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, // rows
            {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, // columns
            {1, 5, 9}, {3, 5, 7} // diagonals
        };

        // Check each winning combination
        for (int[] combo : winningCombos) {
            char a = t3Board[combo[0] - 1];
            char b = t3Board[combo[1] - 1];
            char c = t3Board[combo[2] - 1];

            // If all 3 position match the current player
            if (a == player && b == player && c == player) {
                return true;
            }
        }
        return false;
    }

    // Check if board is full (tie game)
    private static boolean isBoardFull() {
        for (int i = 0; i < t3Board.length; i++) {
            if (t3Board[i] >= '1' && t3Board[i] <= '9') {
                return false;
            }
        }
        return true;
    }
}
