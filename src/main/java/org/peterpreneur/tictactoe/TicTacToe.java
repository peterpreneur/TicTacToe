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

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Name the first player:");
        String firstName = scanner.nextLine();
        System.out.println("firstName: " + firstName);

        System.out.println("Name the second plahyer:");
        String secondName = scanner.nextLine();
        System.out.println("secondName: " + secondName);        

        //initialize the board

        //print the board

        //ask the current player for a move

        //validate the move

        //apply the move

        //check win or draw

        //switch player

        scanner.close();


    }
}
