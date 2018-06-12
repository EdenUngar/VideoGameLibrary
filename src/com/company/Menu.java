package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);

    //menu to prompt user for library options
    public void startMenu() {

        System.out.println("What would you like to do? " +
                "\n1. Add Game to Library " +
                "\n2. Remove Game from Library " +
                "\n3. View Available Games " +
                "\n4. Check Out a Game " +
                "\n5. Check In a Game" +
                "\n6. View Checked Out Games" +
                "\n7. Exit Program ");
        try {
            switch (input.nextInt()) {
                case 1:
                    //add game to library
                    break;
                case 2:
                    //remove game from library
                    break;
                case 3:
                    //view available games
                    break;
                case 4:
                    //check out a game
                    break;
                case 5:
                    //check in a game
                    break;
                case 6:
                    //view checked out games
                    break;
                case 7:
                    System.out.println("Thank you for using the Video Game Library");
                    //exit program
                    System.exit(0);
                    break;
                default:
                    //handle invalid int inputs (prompt user and loop to menu)
                    System.out.println("Not a valid entry. Please enter a number between 1 and 7. ");
                    startMenu();
                    break;
            }
        } catch (InputMismatchException ime) {
            //handle non int invalid inputs (prompt user and loop to menu)
            input.nextLine();
            System.out.println("Not a valid entry. Please enter a number between 1 and 7. ");
            startMenu();
        }

    }

}
